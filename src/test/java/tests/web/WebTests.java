package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tests.TestBase;

@DisplayName("Web tests")
public class WebTests extends TestBase {
    @Test
    @Tag("web")
    @DisplayName("User can access to main page after language selection")
    void userCanAccessToMainPageAfterLanguageSelection() {
        landingPage
                .openPage()
                .clickRussian();
        landingPage.modal
                .modalIsOpenMouse()
                .clickYes();
        landingPage
                .pageIsOpen()
                .clickRussian();
        mainPage
                .pageIsOpen();
    }

    @Test
    @Tag("web")
    @DisplayName("It Is Possible To Open Releases page")
    void itIsPossibleToInstallAnExtension() {
        landingPage
                .openPage()
                .clickRussian();
        landingPage.modal
                .modalIsOpenMouse()
                .clickYes();
        landingPage
                .pageIsOpen()
                .clickRussian();
        mainPage
                .pageIsOpen();
        mainPage.topMenu
                .clickLogo();
        mainPage.leftMenu
                .clickElementWithText("Релизы");
        releasesPage
                .pageIsOpen();
    }

    @Test
    @Tag("web")
    @DisplayName("It Is Possible to search data")
    void itIsPossibleToSearchData() {
        landingPage
                .openPage()
                .clickRussian();
        landingPage.modal
                .modalIsOpenMouse()
                .clickYes();
        landingPage
                .pageIsOpen()
                .clickRussian();
        mainPage
                .pageIsOpen();
        mainPage.topMenu
                .clickSearch();
        searchPage
                .pageIsOpen()
                .typeSearchText("мандалорец")
                .checkValueOfInputField("мандалорец");
    }

    @ParameterizedTest
    @Tag("web")
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
        landingPage.modal
                .modalIsOpenMouse()
                .clickYes();
        landingPage
                .pageIsOpen()
                .clickRussian();
        mainPage.topMenu
                .clickLogo();
        mainPage.leftMenu
                .clickElementWithText(menuElement);
        mainPage.topMenu
                .checkTitle(topMenuTitle);
    }

    @Test
    @Tag("web")
    @DisplayName("Check Title")
    void checkTitle() {
        landingPage
                .openPage()
                .checkTitle();
    }
}
