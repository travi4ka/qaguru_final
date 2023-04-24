package api;

import api.requests.LoginRequest;
import api.responses.LoginResponse;

import java.net.URLEncoder;

import static api.specs.Specs.requestSpecificationWithoutToken;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;
import static tests.TestBase.configApi;

public class AuthApi {

    public String logInAndGetToken() {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(configApi.getEmailApi());
        loginRequest.setPassword(configApi.getPasswordApi());

        LoginResponse loginResponse = given()
                .spec(requestSpecificationWithoutToken())
                .body(format("email=%s&password=%s", URLEncoder.encode(loginRequest.getEmail(), UTF_8), URLEncoder.encode(loginRequest.getPassword(), UTF_8)))
                .when()
                .post("/users/signin")
                .then()
                .statusCode(200)
                .extract()
                .as(LoginResponse.class);
        return loginResponse.getUser().getToken();
    }
}
