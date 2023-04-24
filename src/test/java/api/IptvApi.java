package api;

import api.responses.GetAllIptvLinkedResponse;

import static api.specs.Specs.requestSpecificationWithToken;
import static io.restassured.RestAssured.given;

public class IptvApi {

    public GetAllIptvLinkedResponse getAllIptvLinked(String token) {
        return given()
                .spec(requestSpecificationWithToken(token))
                .when()
                .get("/iptv/all")
                .then()
                .statusCode(200)
                .extract()
                .as(GetAllIptvLinkedResponse.class);
    }
}
