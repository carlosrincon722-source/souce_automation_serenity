package starter.tasks.carttasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import starter.tasks.logintasks.FillInputsAndLoginTask;
import starter.ui.cartui.CartUi;

public class GoCartTask implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(Click.on(CartUi.BUTTON_CART));
    }

    public static GoCartTask goToCartPage(){
        return Tasks.instrumented(GoCartTask.class);
    }
}
