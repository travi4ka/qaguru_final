package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    private SelenideElement searchTooltip = $("div.search__input");

    @Step("Page is open")
    public SearchPage pageIsOpen() {
        searchTooltip.shouldBe(visible);
        return this;
    }

    @Step("Type message")
    public SearchPage typeSearchText(String value) {
        for (int i = 0; i < value.length(); i++) {
            $$("span").findBy(exactText(String.valueOf(value.charAt(i)))).parent().click();
        }
        return this;
    }

    @Step("Check entered message")
    public SearchPage checkValueOfInputField(String value) {
        searchTooltip.shouldHave(textCaseSensitive(value));
        return this;
    }
}
