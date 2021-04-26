package firstscreenplay.ui;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginScreen {
    public static final Target UserName = Target.the("UserName field").located(net.serenitybdd.core.annotations.findby.By.cssSelector("input[type=email]"));
    public static final Target PassWord = Target.the("PassWord field").located(net.serenitybdd.core.annotations.findby.By.cssSelector("input[type=password]"));
    public static final Target LoginButton = Target.the("Login button").located(net.serenitybdd.core.annotations.findby.By.xpath("//button[@class=\"my-btn -btn-pill -btn-grd-bg\"]"));
    public static final Target PopupLabel = Target.the("Popup message").located(By.xpath("//div[@class=\"my-alert -alert-danger\"]"));
}
