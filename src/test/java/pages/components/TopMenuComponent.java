package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TopMenuComponent {
    private SelenideElement logo = $("div.head__logo-icon");
    private SelenideElement titleReleases;
    private SelenideElement actions = $("div.head__actions");
    private SelenideElement searchIcon = actions.$$("div").first();

    @Step("Click logo")
    public TopMenuComponent clickLogo() {
        logo.click();
        return this;
    }

    @Step("Click search")
    public TopMenuComponent clickSearch() {
        searchIcon.click();
        return this;
    }

    @Step("Check title")
    public TopMenuComponent checkTitle(String value) {
        titleReleases = $(byText(value));
        titleReleases.shouldBe(visible);
        return this;
    }


}
