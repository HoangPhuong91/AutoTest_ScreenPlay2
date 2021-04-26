package firstscreenplay.features.search;

import firstscreenplay.questions.Popup;
import firstscreenplay.tasks.Login;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class LoginStory {

    // Define webdriver
    @Managed(uniqueSession = true)
    public WebDriver myDriver;

    //2. Define actor
    Actor phuonghq = Actor.named("Phuonghq");

    //3. Define actor ability
    @Before
    public void canBrowserTheWeb(){
        // Ability of actor
        phuonghq.can(BrowseTheWeb.with(myDriver));
    }

    @Test
    public void show_popup_error_message_with_wrong_password() {
        phuonghq.attemptsTo(Login.withUsername("phuonghq.chemeng@gmail.com").andPassword("123456789"));

        phuonghq.should(seeThat(Popup.getMessage(), equalTo("Có lỗi xảy ra:- Mật khẩu không đúng, vui lòng kiểm tra lại")));
    }
}