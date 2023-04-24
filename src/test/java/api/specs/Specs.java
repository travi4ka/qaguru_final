package api.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static helpers.CustomApiListener.withCustomTemplates;
import static tests.TestBase.configApi;

public class Specs {

    public static RequestSpecification requestSpecificationWithToken(String token) {
        return new RequestSpecBuilder()
                .setBaseUri(configApi.getBaseApiUrl())
                .setBasePath(configApi.getBaseApiPath())
                .addHeader("token", token)
                .addFilter(withCustomTemplates())
                .build();
    }

    public static RequestSpecification requestSpecificationWithoutToken() {
        return new RequestSpecBuilder()
                .setBaseUri(configApi.getBaseApiUrl())
                .setBasePath(configApi.getBaseApiPath())
                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addFilter(withCustomTemplates())
                .build();
    }
}
