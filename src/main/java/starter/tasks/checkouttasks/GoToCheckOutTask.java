package starter.tasks.checkouttasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import starter.tasks.carttasks.GoCartTask;

import static starter.ui.checkoutui.CheckOutUi.BUTTON_CHECKOUT;

public class GoToCheckOutTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BUTTON_CHECKOUT));
    }

    public static GoToCheckOutTask goToCheckOutTask(){
        return Tasks.instrumented(GoToCheckOutTask.class);
    }
}
