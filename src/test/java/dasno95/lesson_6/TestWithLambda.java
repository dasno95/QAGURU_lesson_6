package dasno95.lesson_6;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class TestWithLambda {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 74;

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void testIssueSearchWithLambda () {

        step("Open home page", () -> {
            open("https://github.com/");
        });

        step("Search for repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Go to repository " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Open tab Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Check existence of Issue with number " + NUMBER, () -> {
            $(withText("#" + NUMBER)).should(visible);
        });
    }
}