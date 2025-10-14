package starter.tasks.checkouttasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static starter.ui.checkoutui.CheckOutUi.*;

public class CalculateCheckOutPricesTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> prices = ITEM_PRICES.resolveAllFor(actor);
        if (prices.isEmpty()) {
            throw new NoSuchElementException("no hay elementos para calcular precio");
        }


        double subtotalCalculated = prices.stream()
                .mapToDouble(p -> Double.parseDouble(p.getText().replace("$", "").trim()))
                .sum();


        String subtotalText = ITEM_TOTAL.resolveFor(actor).getText();
        String taxText =  TAX.resolveFor(actor).getText();
        String totalText =  TOTAL.resolveFor(actor).getText();

        double subtotalShown = Double.parseDouble(subtotalText.replace("Item total: $", "").trim());
        double taxShown = Double.parseDouble(taxText.replace("Tax: $", "").trim());
        double totalShown = Double.parseDouble(totalText.replace("Total: $", "").trim());


        boolean subtotalOk = Math.abs(subtotalCalculated - subtotalShown) < 0.01;
        boolean totalOk = Math.abs((subtotalShown + taxShown) - totalShown) < 0.01;
        if (subtotalOk && totalOk) {
            actor.attemptsTo(Click.on(FINISH_BUTTON));
        } else {
            throw new AssertionError("El cálculo del total es incorrecto. No se completó la compra.");
        }

    }

    public static CalculateCheckOutPricesTask calculatePrice(){
        return Tasks.instrumented(CalculateCheckOutPricesTask.class);
    }
}
