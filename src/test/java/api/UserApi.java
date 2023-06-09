package api;

import api.responses.GetUserResponse;

import static api.specs.Specs.requestSpecificationWithToken;
import static io.restassured.RestAssured.given;

public class UserApi {

    public GetUserResponse getUserDetails(String token) {
        return given()
                .spec(requestSpecificationWithToken(token))
                .when()
                .get("/users/get")
                .then()
                .statusCode(200)
                .extract()
                .as(GetUserResponse.class);
    }
}
