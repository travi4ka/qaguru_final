package tests.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@DisplayName("Api tests")
@Tag("api")
public class ApiTests extends TestBase {

    @Test
    @DisplayName("It is possible to log in")
    void itIsPossibleToLogIn() {
        api.logIn();
    }

    @Test
    @DisplayName("Verify That User has 1 bot linked")
    void verifyThatUserHas1BotLinked() {
        api
                .logIn()
                .verifyThatUserHas1BotLinked();
    }

    @Test
    @DisplayName("Users email matches entered credentials")
    void usersEmailMatchesEnteredCredentials() {
        api
                .logIn()
                .verifyThatEmailInRequestAndResponseIsTheSameWhenLoggingIn();
    }

    @Test
    @DisplayName("User has profile with name 'Common' attached")
    void userHasProfileWithNameCommonAttached() {
        api
                .logIn()
                .verifyThatUserHasCommonProfile();
    }

    @Test
    @DisplayName("Verify That User has iptv stored in GitHub")
    void verifyThatUserHasIptvStoredInGitHub() {
        api
                .logIn()
                .verifyThatUserHasIptvStoredInGitHub();
    }
}
