package api;

import api.models.ProfileModel;
import io.qameta.allure.Step;

import static org.junit.jupiter.api.Assertions.*;
import static tests.TestBase.configApi;

public class ApiBase {
    private AuthApi authApi = new AuthApi();
    private UserApi userApi = new UserApi();
    private ProfilesApi profilesApi = new ProfilesApi();
    private BotsApi botsApi = new BotsApi();
    private IptvApi iptvApi = new IptvApi();

    private String token;

    @Step("Log in")
    public ApiBase logIn() {
        token = authApi.logInAndGetToken();
        return this;
    }

    @Step("Verify That User has 1 bot linked")
    public ApiBase verifyThatUserHas1BotLinked() {
        assertEquals(1, botsApi.getAllBotsForUser(getToken()).getBots().size());
        return this;
    }

    @Step("Verify That User has iptv stored in GitHub")
    public ApiBase verifyThatUserHasIptvStoredInGitHub() {
        assertTrue(iptvApi.getAllIptvLinked(getToken()).getIptv().stream().filter(x -> x.getUrl().contains("github.io")).toList().size() > 0);
        return this;
    }

    @Step("Verify That Email In Request And Response Is The Same")
    public ApiBase verifyThatEmailInRequestAndResponseIsTheSameWhenLoggingIn() {
        assertEquals(configApi.getEmailApi(), userApi.getUserDetails(getToken()).getUser().getEmail());
        return this;
    }

    @Step("Verify That User Has 'Common' Profile")
    public ApiBase verifyThatUserHasCommonProfile() {
        for (ProfileModel profileModel : profilesApi.userHasProfileCommon(getToken()).getProfiles()) {
            if (profileModel.getName().equals("Общий")) return this;
        }
        fail("User doesn't have 'Общий' profile");
        return this;
    }

    @Step("Get Token")
    public String getToken() {
        return token = token != null ? token : authApi.logInAndGetToken();
    }
}
