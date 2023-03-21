package api.specs;

import api.requests.LoginRequest;
import api.responces.LoginResponse;
import config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;

import java.net.URLEncoder;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Specs {
    private Config config = ConfigFactory.create(Config.class, System.getProperties());
    private LoginRequest loginRequest = new LoginRequest();
    private String token;

    public RequestSpecification requestSpecificationWithToken() {
        return new RequestSpecBuilder()
                .setBaseUri(config.getBaseApiUrl())
                .setBasePath(config.getBaseApiPath())
                .addHeader("token", token != null ? token : getToken())
                .addFilter(withCustomTemplates())
                .build();
    }

    public RequestSpecification requestSpecificationWithoutToken() {
        return new RequestSpecBuilder()
                .setBaseUri(config.getBaseApiUrl())
                .setBasePath(config.getBaseApiPath())
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addFilter(withCustomTemplates())
                .build();
    }

    public String getToken() {
        loginRequest.setEmail(config.getEmailApi());
        loginRequest.setPassword(config.getPasswordApi());

        LoginResponse loginResponse = given()
                .spec(requestSpecificationWithoutToken())
                .body(format("email=%s&password=%s", URLEncoder.encode(loginRequest.getEmail(), UTF_8), URLEncoder.encode(loginRequest.getPassword(), UTF_8)))
                .when()
                .post("/users/signin")
                .then()
                .statusCode(200)
                .extract()
                .as(LoginResponse.class);
        token = loginResponse.getUser().getToken();
        return token;
    }
}
