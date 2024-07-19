import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class DragDropTest {
    @BeforeAll
    static void setUpTests() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void selenideManualActionDDTest() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        actions()
                .moveToElement($("#column-a")).clickAndHold()
                .moveToElement($("#column-b")).release().perform();

        $("#column-a").$(byTagAndText("header", "B")).shouldBe(exist);
        $("#column-b").$(byTagAndText("header", "A")).shouldBe(exist);

        actions()
                .moveToElement($("#column-a")).clickAndHold()
                .moveToElement($("#column-b")).release().perform();

        $("#column-a").$(byTagAndText("header", "A")).shouldBe(exist);
        $("#column-b").$(byTagAndText("header", "B")).shouldBe(exist);

    }

    @Test
    void selenideElementDragAndDropTest(){

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").$(byTagAndText("header", "B")).shouldBe(exist);
        $("#column-b").$(byTagAndText("header", "A")).shouldBe(exist);
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").$(byTagAndText("header", "B")).shouldNotBe(exist);
        $("#column-b").$(byTagAndText("header", "A")).shouldNotBe(exist);

    }
}