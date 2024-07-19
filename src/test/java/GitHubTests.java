import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class GitHubTests {
    @BeforeAll
    static void setUpTests() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void downloadPagesTest(){

        open("https://github.com");
        $$(".HeaderMenu-item").find(text(" Solutions ")).hover();
        $$(".HeaderMenu-dropdown-link").find(text(" Enterprise ")).click();
        $(".enterprise-hero-heading").shouldHave(text("The AI-powered developer platform."));
    }

}
