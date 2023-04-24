package api;

import api.responses.GetAllProfilesResponse;

import static api.specs.Specs.requestSpecificationWithToken;
import static io.restassured.RestAssured.given;

public class ProfilesApi {

    public GetAllProfilesResponse userHasProfileCommon(String token) {
        return given()
                .spec(requestSpecificationWithToken(token))
                .when()
                .get("/profiles/all")
                .then()
                .statusCode(200)
                .extract()
                .as(GetAllProfilesResponse.class);
    }
}
