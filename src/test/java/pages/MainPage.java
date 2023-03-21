package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.LeftMenu;
import pages.components.TopMenu;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement title = $(byText("Главная - TMDB"));
    private SelenideElement languageRussianElement = $(byText("Русский"));

    public LeftMenu leftMenu = new LeftMenu();
    public TopMenu topMenu = new TopMenu();

    @Step("Page is open")
    public MainPage pageIsOpen() {
        title.shouldBe(visible);
        return this;
    }

    @Step("Click 'Русский'")
    public MainPage clickRussian() {
        languageRussianElement.click();
        return this;
    }
}
