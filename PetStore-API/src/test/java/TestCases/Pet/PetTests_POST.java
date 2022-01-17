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


public class PetTests_POST extends TestBase implements PetConstants {

    String jsonPath = ".//src/test/resources/pet.json";

    @Test
    public void T01_createPet_200() throws IOException {

        logger.info("POST Process Working - 200 ");

        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);
        petObject.put("id", PetID());
        petObject.getJSONObject("category").put("id", "0001");
        String jsonBody = petObject.toString();
        System.out.println(jsonBody);
        given().given()
                .contentType("application/json")
                .body(petObject.toString())
                .when()
                .post(Var.apiUrl + POST_ENDPOINT)
                .then()
                .statusCode(200)
                .assertThat().body("status", equalTo("available")).log().all();
    }
    @Test
    public void T02_createPet_500() throws IOException {

        logger.info("POST Process Working - 500 ");

        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);
        petObject.put("id", "onur");
        petObject.getJSONObject("category").put("id", "0001");
        String jsonBody = petObject.toString();
        System.out.println(jsonBody);
        given().given()
                .contentType("application/json")
                .body(petObject.toString())
                .when()
                .post(Var.apiUrl + POST_ENDPOINT)
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
                .post(Var.apiUrl + POST_ENDPOINT)
                .then()
                .statusCode(405)
                .assertThat().body("message", equalTo("no data")).log().all();

    }
    public void T04_createPet_200(Integer id) throws IOException {

        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);
        petObject.put("id", id);
        petObject.getJSONObject("category").put("id", "0001");
        String jsonBody = petObject.toString();
        System.out.println(jsonBody);
        given().given()
                .contentType("application/json")
                .body(petObject.toString())
                .when()
                .post(Var.apiUrl + POST_ENDPOINT)
                .then()
                .statusCode(200)
                .assertThat().body("status", equalTo("available")).log().all();
    }
}

