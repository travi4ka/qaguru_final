package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import static tests.TestBase.config;

public class WebDriver {
    public WebDriver() {
        Configuration.browser = config.getBrowser();
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.remote = config.getRemote();
        Configuration.browserSize = config.getBrowserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", java.util.Map.<String, Object>of("enableVNC", true, "enableVideo", true));
        Configuration.browserCapabilities = capabilities;
    }

}
