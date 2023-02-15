import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestDrafts {

    @BeforeEach
    void setUp() {
        //Configuration.holdBrowserOpen = true;

        open("about:blank");

        // Selenide.clearBrowserCookies();

    }

    @Test
    void successfulGoogleSearchTest() {

        open("https://www.google.com/");

        // $("button + button").click();

        $$("button + button").asFixedIterable().forEach(element -> element.click());

        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));

    }


    @Test
    void SuccessfulDoubleGoogleSearchTest() {

        open("https://www.google.com/");

        $$("button + button").asFixedIterable().forEach(element -> element.click());
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));

        open("https://www.google.com/");

        $$("button + button").asFixedIterable().forEach(element -> element.click());
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));

    }


    @Test
    void successfulDuckDuckGoSearchTest() {

        open("https://duckduckgo.com/");
        $("[id=search_form_input_homepage]").setValue("selenide").pressEnter();
        $("[id=links]").shouldHave(text("https://selenide.org"));

    }


    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}

