package starter.ui.checkoutui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckOutFormUi {

    //FORM
    public static Target FIRST_NAME= Target.the("input first name").located(By.id("first-name"));
    public static Target LAST_NAME= Target.the("input last name").located(By.id("last-name"));
    public static Target ZIP= Target.the("input zip").located(By.id("postal-code"));
    public static Target BUTTON_CONTINUE= Target.the("button continue").located(By.id("continue"));
}
