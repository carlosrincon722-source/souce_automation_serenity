package starter.ui.productui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductUI {
    public static Target LABEL_PRODUCT= Target.the("Label product").located(By.xpath("//span[@data-test='title']"));
    public static Target SELECT_FILTER=Target.the("select filter ").located(By.xpath("//select[@data-test='product-sort-container']"));
    public static Target NAME_PRODUCT_LABEL=Target.the("contain the name").located(By.xpath("//div[@data-test='inventory-item-name']"));
    public static Target PRICE_PRODUCT_LABEL=Target.the("contain the price").located(By.xpath("//div[@data-test='inventory-item-price']"));
    public static Target ADD_PRODUCT_BUTTON=Target.the("add product button").locatedBy("//div[@class='pricebar']//button");
    public static Target COUNTER_PRODUCTS_CART=Target.the("counter products in cart").located(By.xpath("//span[@data-test='shopping-cart-badge']"));
    public static Target REMOVE_PRODUCT_BUTTON=Target.the("remove product button").locatedBy("//div[@class='pricebar']//button[text()='Remove']");
}
