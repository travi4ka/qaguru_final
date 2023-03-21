package api;

import api.models.ProfileModel;
import api.responces.ProfilesAllResponse;
import api.specs.Specs;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfilesApi {
    private Specs specs = new Specs();

    @Step("User has profile 'Common'")
    public void userHasProfileCommon() {
        ProfilesAllResponse getUserResponse = given()
                .spec(specs.requestSpecificationWithToken())
                .when()
                .get("/profiles/all")
                .then()
                .statusCode(200)
                .extract()
                .as(ProfilesAllResponse.class);
        Boolean isCommon = false;
        for (ProfileModel profileModel : getUserResponse.getProfiles()) {
            if (profileModel.getName().equals("Общий")) {
                isCommon = true;
                break;
            }
        }
        assertTrue(isCommon);
    }
}
