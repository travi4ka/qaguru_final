package tests;

import api.LoginApi;
import api.ProfilesApi;
import api.UserApi;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.BrowserstackMobileDriver;
import config.LocalMobileDriver;
import config.WebDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.*;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public LandingPage landingPage = new LandingPage();
    public MainPage mainPage = new MainPage();
    public ReleasesPage releasesPage = new ReleasesPage();
    public SearchPage searchPage = new SearchPage();

    public LoginApi loginApi = new LoginApi();
    public UserApi userApi = new UserApi();
    public ProfilesApi profilesApi = new ProfilesApi();

    @BeforeAll
    public static void setDriver() {
        switch (System.getProperty("env")) {
            case "mobile_local":
                Configuration.browser = LocalMobileDriver.class.getName();
                Configuration.browserSize = null;
                break;
            case "mobile_bs":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                Configuration.browserSize = null;
                break;
            case "web_local", "web_remote":
                new WebDriver();
                break;
            case "api":
                break;
            default:
                throw new RuntimeException("Wrong environment");
        }
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        if (!System.getProperty("env").equals("api")) open();
    }

    @AfterEach
    void afterEach() {
        switch (System.getProperty("env")) {
            case "mobile_local":
                Attach.pageSource();
                closeWebDriver();
                break;
            case "mobile_bs":
                String sessionId = Selenide.sessionId().toString();
                Attach.pageSource();
                closeWebDriver();
                Attach.addVideo(sessionId);
                break;
            case "web_remote":
                Attach.screenshotAs("Last screenshot");
                Attach.pageSource();
                Attach.browserConsoleLogs();
                Attach.addVideo();
                clearBrowserCookies();
                sessionStorage().clear();
                localStorage().clear();
                break;
            case "web_local":
                Attach.screenshotAs("Last screenshot");
                Attach.pageSource();
                Attach.browserConsoleLogs();
                clearBrowserCookies();
                sessionStorage().clear();
                localStorage().clear();
                break;
            case "api":
                break;
            default:
                throw new RuntimeException("Wrong environment");
        }
    }
}
