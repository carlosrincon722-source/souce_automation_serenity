package starter.ui.Loginui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {

    public static Target INPUT_USERNAME= Target.the("username input").located(By.id("user-name"));
    public static Target INPUT_PASSWORD= Target.the("password input").located(By.id("password"));
    public static Target BUTTON_LOGIN= Target.the("login button").located(By.id("login-button"));
    public static Target ALERT_TEXT= Target.the("alert login").located(By.xpath("//h3[@data-test='error']"));

}
