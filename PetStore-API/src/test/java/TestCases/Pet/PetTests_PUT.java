package TestCases.Pet;

import Base.TestBase;
import Contants.PetConstants;
import com.google.common.io.Resources;
import org.json.JSONObject;
import org.testng.annotations.Test;
import variables.Var;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetTests_PUT extends TestBase implements PetConstants {

    String jsonPath = ".//src/test/resources/pet.json";
    PetTests_POST petTests_post = new PetTests_POST();

    @Test
    public void T01_updatePet_200() throws IOException {

        logger.info("PUT Process Working - 200 ");
        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);
        Integer petID = PetID();
        logger.info("POST Process with PetID");
        petTests_post.T04_createPet_200(petID);
        petObject.put("id",petID);
        petObject.getJSONObject("category").put("name", "marley");
        String jsonBody = petObject.toString();
        System.out.println(jsonBody);
        given().given()
                .contentType("application/json")
                .body(petObject.toString())
                .when()
                .put(Var.apiUrl + PUT_ENDPOINT)
                .then()
                .statusCode(200)
                .assertThat().body("status", equalTo("available"))
                .assertThat().body("category.name", equalTo("marley"))
                .log().all();
    }
    @Test
    public void T02_updatePet_500() throws IOException {
        logger.info("POST Process Working - 500 ");
        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);
        Integer petID = PetID();
        logger.info("POST Process with PetID");
        petTests_post.T04_createPet_200(petID);
        petObject.put("id",petID);
        petObject.getJSONObject("category").put("id", "XXXX");
        String jsonBody = petObject.toString();
        System.out.println(jsonBody);
        given().given()
                .contentType("application/json")
                .body(petObject.toString())
                .when()
                .put(Var.apiUrl + PUT_ENDPOINT)
                .then()
                .statusCode(500)
                .assertThat().body("message", equalTo("something bad happened")).log().all();
    }
    @Test
    public void T03_createPet_405() throws IOException {

        logger.info("POST Process Working - 405 ");
        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);
        given().given()
                .contentType("application/json")
                .body("")
                .when()
                .put(Var.apiUrl + PUT_ENDPOINT)
                .then()
                .statusCode(405)
                .assertThat().body("message", equalTo("no data")).log().all();
    }
    public void T04_updatePet_200(Integer id , String statusName) throws IOException {

        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);
        petTests_post.T04_createPet_200(id);
        petObject.put("id",id);
        petObject.getJSONObject("category").put("name", "marley");
        petObject.put("status",statusName);
        String jsonBody = petObject.toString();
        System.out.println(jsonBody);
        given().given()
                .contentType("application/json")
                .body(petObject.toString())
                .when()
                .put(Var.apiUrl + PUT_ENDPOINT)
                .then()
                .statusCode(200)
                .assertThat().body("status", equalTo(statusName))
                .assertThat().body("category.name", equalTo("marley"))
                .log().all();

    }
}
