package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.TestBase;

@DisplayName("Main Page web tests")
@Tag("web")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("User can access to main page after language selection")
    void userCanAccessToMainPageAfterLanguageSelection() {
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
    }

    @Test
    @DisplayName("Check Title")
    void checkTitle() {
        landingPage
                .openPage()
                .checkTitle();
    }

    @ParameterizedTest
    @DisplayName("Checking titles for pages")
    @CsvSource({
            "Главная, Главная - TMDB",
            "Фильмы, Фильмы - TMDB",
            "Сериалы, Сериалы - TMDB"
    })
    void checkTitleForPages(String menuElement, String topMenuTitle) {
        landingPage
                .openPage()
                .clickRussian();
        landingPage.modalMouseUsageComponent
                .verifyThatModalMessageMouseIsVisible()
                .clickOnYesButton();
        landingPage
                .verifyThatPageIsOpen()
                .clickRussian();
        mainPage.topMenuComponent
                .clickLogo();
        mainPage.leftMenuComponent
                .clickElementWithText(menuElement);
        mainPage.topMenuComponent
                .checkTitle(topMenuTitle);
    }

}
