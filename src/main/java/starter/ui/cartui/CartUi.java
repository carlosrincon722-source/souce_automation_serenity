package starter.ui.cartui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartUi {



    public static Target BUTTON_CART= Target.the("button cart").located(By.xpath("//a[@data-test='shopping-cart-link']"));
    public static Target LIST_ITEMS=Target.the("List of products").located(By.xpath("//div[@data-test='inventory-item']"));
}
