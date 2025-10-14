package starter.tasks.producttasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import starter.ui.productui.ProductUI;

import java.util.List;

public class RemoveProductTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        int cuantity=actor.recall("cuantity");
        List<WebElementFacade> buttonList= ProductUI.REMOVE_PRODUCT_BUTTON.resolveAllFor(actor);
        for(int i=0;i<cuantity;i++){
            buttonList.get(i).click();
        }

    }

    public static RemoveProductTask removeProduct(){
        return Tasks.instrumented(RemoveProductTask.class);
    }
}
