package pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LeftMenuComponent {

    @Step("Click element of menu")
    public LeftMenuComponent clickElementWithText(String text) {
        $(byText(text)).click();
        return this;
    }
}
