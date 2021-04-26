package firstscreenplay.questions;

import firstscreenplay.ui.LoginScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Popup implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return LoginScreen.PopupLabel.resolveFor(actor).getText();
    }

    public static Question<String> getMessage()
    {
        return new Popup();
    }
}
