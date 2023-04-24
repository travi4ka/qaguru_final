package tests;

import api.ApiBase;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.ConfigApi;
import configs.ConfigMobile;
import configs.ConfigWeb;
import drivers.BrowserstackMobileDriver;
import drivers.LocalMobileDriver;
import drivers.WebDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.LandingPage;
import pages.MainPage;
import pages.ReleasesPage;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public static ConfigWeb configWeb = ConfigFactory.create(ConfigWeb.class, System.getProperties());
    public static ConfigMobile configMobile = ConfigFactory.create(ConfigMobile.class, System.getProperties());
    public static ConfigApi configApi = ConfigFactory.create(ConfigApi.class, System.getProperties());

    public LandingPage landingPage = new LandingPage();
    public MainPage mainPage = new MainPage();
    public ReleasesPage releasesPage = new ReleasesPage();
    public SearchPage searchPage = new SearchPage();

    public ApiBase api = new ApiBase();

    @BeforeAll
    public static void beforeAll() {
        switch (System.getProperty("taskName")) {
            case "mobile":
                Configuration.browser = System.getProperty("env").equals("local") ? LocalMobileDriver.class.getName() : BrowserstackMobileDriver.class.getName();
                Configuration.browserSize = null;
                break;
            case "web":
                new WebDriver();
                break;
            case "api":
                break;
            default:
                throw new RuntimeException("Wrong task name");
        }
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        if (!System.getProperty("taskName").equals("api")) open();
    }

    @AfterEach
    void afterEach() {
        switch (System.getProperty("taskName")) {
            case "mobile":
                if (System.getProperty("env").equals("local")) {
                    Attach.pageSource();
                    closeWebDriver();
                } else {
                    String sessionId = Selenide.sessionId().toString();
                    Attach.pageSource();
                    closeWebDriver();
                    Attach.addVideo(sessionId);
                }
                break;
            case "web":
                Attach.screenshotAs("Last screenshot");
                Attach.pageSource();
                Attach.browserConsoleLogs();
                if (System.getProperty("env").equals("remote")) Attach.addVideo();
                clearBrowserCookies();
                sessionStorage().clear();
                localStorage().clear();
                break;
            case "api":
                break;
            default:
                throw new RuntimeException("Wrong task name");
        }
    }
}
