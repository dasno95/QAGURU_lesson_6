package dasno95.lesson_6;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.*;

public class SelenideTest extends BaseAnnotation {

    @Test
    public void testIssueSearch() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();
        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#74")).should(visible);
    }
}