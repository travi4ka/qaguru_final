package api;

import api.responses.GetAllBotsResponse;

import static api.specs.Specs.requestSpecificationWithToken;
import static io.restassured.RestAssured.given;

public class BotsApi {

    public GetAllBotsResponse getAllBotsForUser(String token) {
        return given()
                .spec(requestSpecificationWithToken(token))
                .when()
                .get("/bot_management/all")
                .then()
                .statusCode(200)
                .extract()
                .as(GetAllBotsResponse.class);
    }
}
