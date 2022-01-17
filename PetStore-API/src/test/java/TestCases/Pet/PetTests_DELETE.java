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

public class PetTests_DELETE extends TestBase implements PetConstants {

    String jsonPath = ".//src/test/resources/pet.json";
    PetTests_POST petTests_post = new PetTests_POST();
    PetTests_PUT  petTests_put  = new PetTests_PUT();

    @Test
    public void T01_deletePet_200() throws IOException {

        logger.info("DELETE Process Working - 200 ");
        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);
        Integer petID = PetID();
        logger.info("POST Process with PetID");
        petTests_post.T04_createPet_200(petID);
        petObject.put("id",petID);
        logger.info("PUT Process with PetID");
        petTests_put.T04_updatePet_200(petID,"sold");
        String jsonBody = petObject.toString();
        System.out.println(jsonBody);
        sleep(5000);
        given().given()
                .contentType("application/json")
                .when()
                .delete(Var.apiUrl + DELETE_ENDPOINT + petID )
                .then()
                .statusCode(200)
                .log().all();

    }
}