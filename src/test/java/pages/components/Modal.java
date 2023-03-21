package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Modal {
    private SelenideElement modal = $("div.modal__body");
    private SelenideElement modalMessageMouse = modal.$(byText("Хотите переключить на управление мышью?"));
    private SelenideElement modalMessageInstall = modal.$(byText("Для применения плагина необходимо перезагрузить приложение"));
    private SelenideElement modalYesButton = modalMessageMouse.sibling(0).$(byText("Да"));

    @Step("Modal is open, Mouse")
    public Modal modalIsOpenMouse() {
        modalMessageMouse.shouldBe(visible);
        return this;
    }

    @Step("Modal is open, Install")
    public Modal modalIsOpenInstall() {
        modalMessageInstall.shouldBe(visible);
        return this;
    }

    @Step("Click Yes")
    public Modal clickYes() {
        modalYesButton.click();
        return this;
    }


}
