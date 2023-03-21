package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TopMenu {
    private SelenideElement logo = $("div.head__logo-icon");
    private SelenideElement titleReleases;
    private SelenideElement actions = $("div.head__actions");
    private SelenideElement searchIcon = actions.$$("div").first();

    @Step("Click logo")
    public TopMenu clickLogo() {
        logo.click();
        return this;
    }

    @Step("Click search")
    public TopMenu clickSearch() {
        searchIcon.click();
        return this;
    }

    @Step("Check title")
    public TopMenu checkTitle(String value) {
        titleReleases = $(byText(value));
        titleReleases.shouldBe(visible);
        return this;
    }


}
