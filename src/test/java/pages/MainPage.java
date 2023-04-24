package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.LeftMenuComponent;
import pages.components.TopMenuComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement title = $(byText("Главная - TMDB"));
    private SelenideElement languageRussianElement = $(byText("Русский"));

    public LeftMenuComponent leftMenuComponent = new LeftMenuComponent();
    public TopMenuComponent topMenuComponent = new TopMenuComponent();

    @Step("Page is open")
    public MainPage verifyThatPageIsOpen() {
        title.shouldBe(visible);
        return this;
    }

}
