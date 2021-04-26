package firstscreenplay.tasks;

import firstscreenplay.ui.LoginScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    private String username;
    private String password;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://fado.vn/dang-nhap?redirect=https%3A%2F%2Ffado.vn%2F"),
                Enter.theValue(this.username).into(LoginScreen.UserName),
                Enter.theValue(this.password).into(LoginScreen.PassWord),
                Click.on(LoginScreen.LoginButton)
        );
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginBuilder withUsername(String username)
    {
        return new LoginBuilder(username);
    }

    public static class LoginBuilder
    {
        private String username;
        public LoginBuilder(String username)
        {
            this.username = username;
        }

        public Login andPassword(String password)
        {
            return instrumented(Login.class, this.username, password);
        }
    }
}
