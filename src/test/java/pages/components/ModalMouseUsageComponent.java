package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalMouseUsageComponent {
    private SelenideElement modal = $("div.modal__body");
    private SelenideElement modalMessageMouse = modal.$(byText("Хотите переключить на управление мышью?"));
    private SelenideElement modalYesButton = modalMessageMouse.sibling(0).$(byText("Да"));

    @Step("Modal is open, Mouse")
    public ModalMouseUsageComponent verifyThatModalMessageMouseIsVisible() {
        modalMessageMouse.shouldBe(visible);
        return this;
    }

    @Step("Click Yes")
    public ModalMouseUsageComponent clickOnYesButton() {
        modalYesButton.click();
        return this;
    }


}
