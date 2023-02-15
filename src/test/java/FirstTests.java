import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTests {

    @Test
    void successfulQGRLoginTest() {

        Configuration.holdBrowserOpen = true;

        open("https://qa.guru/cms/system/login/");
        $(".login-form ").shouldHave(text("Войти"));
        $("[name=email]").setValue("qagurubot@gmail.com");
        $("[name=password]").setValue("qagurupassword");

        $(".btn-success").click();

        $(".main-header__login").click();

        $(".logined-form").shouldHave(text("Здравствуйте, QA_GURU_BOT"));

    }

    @Test
    void successfulDuckDuckGoSearchTest() {

        Configuration.holdBrowserOpen = true;

        open("https://duckduckgo.com/");
        $("[id=search_form_input_homepage]").setValue("selenide").pressEnter();
        $("[id=links]").shouldHave(text("https://selenide.org"));

    }


}

