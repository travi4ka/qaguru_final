package pages;

import pages.components.TopMenuComponent;
import io.qameta.allure.Step;

public class ReleasesPage {
    public TopMenuComponent topMenuComponent = new TopMenuComponent();

    @Step("Page is open")
    public ReleasesPage verifyThatPageIsOpen() {
        topMenuComponent.checkTitle("Цифровые релизы");
        return this;
    }
}
