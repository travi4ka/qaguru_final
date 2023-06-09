package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import pages.components.ModalMouseUsageComponent;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LandingPage {
    private String title = "Lampa";

    private SelenideElement titleHeader = $(byText("Добро пожаловать"));
    private SelenideElement languageRussianElement = $(byText("Русский"));

    public ModalMouseUsageComponent modalMouseUsageComponent = new ModalMouseUsageComponent();

    @Step("Open landing page")
    public LandingPage openPage() {
        open(Configuration.baseUrl);
        verifyThatPageIsOpen();
        return this;
    }

    @Step("Page is open")
    public LandingPage verifyThatPageIsOpen() {
        titleHeader.shouldBe(visible);
        return this;
    }

    @Step("Check title")
    public LandingPage checkTitle() {
        Assertions.assertEquals(title, WebDriverRunner.getWebDriver().getTitle());
        return this;
    }

    @Step("Click 'Русский'")
    public LandingPage clickRussian() {
        languageRussianElement.click();
        return this;
    }
}
