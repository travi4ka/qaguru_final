package pages;

import pages.components.TopMenu;
import io.qameta.allure.Step;

public class ReleasesPage {
    public TopMenu topMenu = new TopMenu();

    @Step("Page is open")
    public ReleasesPage pageIsOpen() {
        topMenu.checkTitle("Цифровые релизы");
        return this;
    }
}
