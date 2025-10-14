package starter.ui.checkoutui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckOutUi {

    public static Target BUTTON_CHECKOUT= Target.the("button checkout").located(By.xpath("//button[@data-test='checkout']"));

    public static final Target ITEM_PRICES = Target.the("Label with prices").locatedBy(".inventory_item_price");

    public static final Target ITEM_TOTAL = Target.the("subtotal").locatedBy(".summary_subtotal_label");

    public static final Target TAX = Target.the("Tax").locatedBy(".summary_tax_label");

    public static final Target TOTAL = Target.the("total").locatedBy(".summary_total_label");

    public static final Target FINISH_BUTTON = Target.the(" Finish boton").locatedBy("#finish");

    public static final Target CONFIRMATION_MESSAGE = Target.the("Order confirmation message").located(By.cssSelector(".complete-header"));
    public static final Target ERROR_MESSAGE = Target.the("error message").located(By.cssSelector("h3[data-test='error']"));
}
