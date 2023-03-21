package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LeftMenu {
    private SelenideElement settingsItem;

    @Step("Click element of menu")
    public LeftMenu clickElementWithText(String text) {
        settingsItem = $(byText(text));
        settingsItem.click();
        return this;
    }
}
