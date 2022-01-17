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


public class PetTests_FindByID_GET extends TestBase implements PetConstants {


    PetTests_POST petTests_post = new PetTests_POST();
    PetTests_PUT  petTests_put  = new PetTests_PUT();

    @Test
    public void T01_getFindBy_ID_Sold_Pet_200() throws IOException {

        logger.info("Get Find By ID Also Status as Sold Process Working - 200 ");
        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);
        Integer petID = PetID();
        logger.info("POST Process with PetID");
        petTests_post.T04_createPet_200(petID);
        petObject.put("id",petID);
        petObject.getJSONObject("category").put("name", "marley");
        logger.info("PUT Process with PetID");
        petTests_put.T04_updatePet_200(petID,"sold");
        String jsonBody = petObject.toString();
        System.out.println(jsonBody);
        sleep(10000);
        given().given()
                .contentType("application/json")
                .when()
                .get(Var.apiUrl + GET_ENDPOINT + petID)
                .then()
                .statusCode(200)
                .assertThat().body("status", equalTo("sold"))
                .assertThat().body("category.name", equalTo("marley"))
                .log().all();
    }
    @Test
    public void T02_getFindBy_Pending_ID_200() throws IOException {

        logger.info("Get Find By ID Also Status as Pending Process Working - 200 ");
        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);
        Integer petID = PetID();
        logger.info("POST Process with PetID");
        petTests_post.T04_createPet_200(petID);
        petObject.put("id",petID);
        petObject.getJSONObject("category").put("name", "marley");
        logger.info("PUT Process with PetID");
        petTests_put.T04_updatePet_200(petID,"pending");
        String jsonBody = petObject.toString();
        System.out.println(jsonBody);
        sleep(10000);
        given().given()
                .contentType("application/json")
                .when()
                .get(Var.apiUrl + GET_ENDPOINT + petID)
                .then()
                .statusCode(200)
                .assertThat().body("status", equalTo("pending"))
                .assertThat().body("category.name", equalTo("marley"))
                .log().all();
    }
}