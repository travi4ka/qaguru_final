package tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@DisplayName("Api tests")
public class ApiTests extends TestBase {
    @Test
    @Tag("api")
    @DisplayName("It is possible to log in")
    void itIsPossibleToLogIn() {
        loginApi
                .logIn();
    }

    @Test
    @Tag("api")
    @DisplayName("Users email matches entered credentials")
    void usersEmailMatchesEnteredCredentials() {
        loginApi
                .logIn();
        userApi
                .userSEmailMatchesEnteredCredentials();
    }

    @Test
    @Tag("api")
    @DisplayName("User has profile with name 'Common' attached")
    void userHasProfileWithNameCommonAttached() {
        loginApi
                .logIn();
        profilesApi
                .userHasProfileCommon();
    }
}
