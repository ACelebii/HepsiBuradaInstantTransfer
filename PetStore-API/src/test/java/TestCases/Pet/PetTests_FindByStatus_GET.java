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


public class PetTests_FindByStatus_GET extends TestBase implements PetConstants {

    PetTests_POST petTests_post = new PetTests_POST();
    PetTests_PUT petTests_put = new PetTests_PUT();

    @Test
    public void T01_getFindsStatusPet_Sold_200() throws IOException {

        logger.info("Get Find By Status Process Working - 200 ");
        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);
        Integer petID = PetID();
        logger.info("POST Process with PetID");
        petTests_post.T04_createPet_200(petID);
        petObject.put("id", petID);
        petObject.getJSONObject("category").put("name", "marley");
        petTests_put.T04_updatePet_200(petID, "sold");
        String jsonBody = petObject.toString();
        System.out.println(jsonBody);
        given().given()
                .contentType("application/json")
                .when()
                .get(Var.apiUrl + GET_findByStatus_Sold)
                .then()
                .statusCode(200)
                .assertThat().body("status[2]", equalTo("sold"))
                .log().all();
    }
    @Test
    public void T02_getFindsStatusPet_Available_200() throws IOException {

        logger.info("Get Find By Status -Available- Process Working - 200 ");
        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);
        Integer petID = PetID();
        logger.info("POST Process with PetID");
        petTests_post.T04_createPet_200(petID);
        petObject.put("id", petID);
        petObject.getJSONObject("category").put("name", "marley");
        petTests_put.T04_updatePet_200(petID, "availabla");
        String jsonBody = petObject.toString();
        System.out.println(jsonBody);
        given().given()
                .contentType("application/json")
                .when()
                .get(Var.apiUrl + GET_findByStatus_Available)
                .then()
                .statusCode(200)
                .assertThat().body("status[2]", equalTo("available"))
                .log().all();
    }
    @Test
    public void T03_getFindsStatusPet_Pending_200() throws IOException {

        logger.info("Get Find By Status -PENDING- Process Working - 200 ");
        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);
        Integer petID = PetID();
        logger.info("POST Process with PetID");
        petTests_post.T04_createPet_200(petID);
        petObject.put("id", petID);
        petObject.getJSONObject("category").put("name", "marley");
        petTests_put.T04_updatePet_200(petID, "pending");
        String jsonBody = petObject.toString();
        System.out.println(jsonBody);
        given().given()
                .contentType("application/json")
                .when()
                .get(Var.apiUrl + GET_findByStatus_Pending)
                .then()
                .statusCode(200)
                .assertThat().body("status[2]", equalTo("pending"))
                .log().all();
    }
}