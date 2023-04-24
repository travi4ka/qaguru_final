package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@DisplayName("Releases Page web tests")
@Tag("web")
public class ReleasesPage extends TestBase {

    @Test
    @DisplayName("It Is Possible To Open Releases page")
    void itIsPossibleToInstallAnExtension() {
        landingPage
                .openPage()
                .clickRussian();
        landingPage.modalMouseUsageComponent
                .verifyThatModalMessageMouseIsVisible()
                .clickOnYesButton();
        landingPage
                .verifyThatPageIsOpen()
                .clickRussian();
        mainPage
                .verifyThatPageIsOpen();
        mainPage.topMenuComponent
                .clickLogo();
        mainPage.leftMenuComponent
                .clickElementWithText("Релизы");
        releasesPage
                .verifyThatPageIsOpen();
    }
}
