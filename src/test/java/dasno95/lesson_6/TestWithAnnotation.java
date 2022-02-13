package dasno95.lesson_6;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class TestWithAnnotation extends BaseAnnotation {

    @Step("Open home page")
    public void openHomePage () {
        open("https://github.com");
    }

    @Step("Search for repository {repository}")
    public void searchForRepository (String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Go to repository {repository}")
    public void openRepositoryPage (String repository) {
        $(linkText(repository)).click();
    }

    @Step("Open tab Issues")
    public void openIssuesTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Check existence of Issue with number {number}")
    public void shouldSeeIssueWithNumber(int number) {
        $(withText("#" + number)).should(visible);
    }

    @Attachment(value = "Screenshot", type = "text/html", fileExtension = "html")
    public byte[] attachPageSource() {
        return WebDriverRunner.source().getBytes(StandardCharsets.UTF_8);
    }

    @Test
    @Owner("dasno95")
    @Feature("Issues")
    @Story("Search for Issue from Repository page")
    @DisplayName("Search for Issue by unauthorized user")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "GitHub", url = "https://github.com")
    public void annotatedStepsTest() {
        TestWithAnnotation annotationSteps = new TestWithAnnotation();
        annotationSteps.openHomePage();
        annotationSteps.searchForRepository("eroshenkoam/allure-example");
        annotationSteps.openRepositoryPage("eroshenkoam/allure-example");
        annotationSteps.openIssuesTab();
        annotationSteps.shouldSeeIssueWithNumber(74);
    }
}