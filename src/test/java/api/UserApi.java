package api;

import api.responces.GetUserResponse;
import api.specs.Specs;
import config.Config;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserApi {
    private Config config = ConfigFactory.create(Config.class, System.getProperties());
    private Specs specs = new Specs();

    @Step("User's email matches entered credentials")
    public void userSEmailMatchesEnteredCredentials() {
        GetUserResponse getUserResponse = given()
                .spec(specs.requestSpecificationWithToken())
                .when()
                .get("/users/get")
                .then()
                .statusCode(200)
                .extract()
                .as(GetUserResponse.class);
        assertEquals(config.getEmailApi(), getUserResponse.getUser().getEmail());
    }
}
