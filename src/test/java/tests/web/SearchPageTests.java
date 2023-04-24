package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

@DisplayName("Search Page web tests")
@Tag("web")
public class SearchPageTests extends TestBase {

    @Test
    @DisplayName("It Is Possible to search data")
    void itIsPossibleToSearchData() {
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
                .clickSearch();
        searchPage
                .verifyThatPageIsOpen()
                .typeSearchText("мандалорец")
                .checkValueOfInputField("мандалорец");
    }

}
