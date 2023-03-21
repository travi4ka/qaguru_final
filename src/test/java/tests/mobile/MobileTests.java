package tests.mobile;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

@DisplayName("Mobile tests")
public class MobileTests extends TestBase {
    @Test
    @Story("Story_1")
    @Tag("mobile")
    @DisplayName("English language choosing")
    void clickRussianLanguage() {
        step("Click 'English'",
                () -> $x("//*[@text='English']").click()
        );
    }

    @Test
    @Story("Story_1")
    @Tag("mobile")
    @DisplayName("Check broken links")
    void checkThePresenceOfBrokenImages() {
        step("Click 'English'",
                () -> $x("//*[@text='English']").click()
        );
        step("Click 'Logo'",
                () -> $x("//*[@text='logo-icon']").click()
        );
        step("Click 'Releases'",
                () -> $x("//*[@text='Releases']").click()
        );
        step("Check presence of broken links",
                () -> $$x("//*[@text='img_broken']")
                        .shouldHave(sizeGreaterThan(1))
        );
    }

    @Test
    @Story("Story_1")
    @Tag("mobile")
    @DisplayName("Check that user is not logged in")
    void checkThatUserIsNotLoggedIn() {
        step("Click 'English'",
                () -> $x("//*[@text='English']").click()
        );
        step("Click 'Logo'",
                () -> $x("//*[@text='logo-icon']").click()
        );
        step("Click 'Settings'",
                () -> $x("//*[@text='Settings']").click()
        );
        step("Click 'Account'",
                () -> $x("//*[@text='Account']").click()
        );
        step("Check that there is a 'Login failed' phrase",
                () -> $x("//*[@text='Login failed']").shouldBe(visible)
        );
    }
}
