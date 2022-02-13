package dasno95.lesson_6;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseAnnotation {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    public void saveSources() {
        TestWithAnnotation testWithAnnotation = new TestWithAnnotation();
        testWithAnnotation.attachPageSource();
    }
}