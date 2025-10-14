package starter.tasks.checkouttasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.ui.checkoutui.CheckOutFormUi;




public class FillFormCheckOutTask implements Task {

    public String first,last,zip;


    public FillFormCheckOutTask(String first, String last, String zip) {
        this.first = first;
        this.last = last;
        this.zip = zip;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(first).into(CheckOutFormUi.FIRST_NAME),
                Enter.theValue(last).into(CheckOutFormUi.LAST_NAME),
                Enter.theValue(zip).into(CheckOutFormUi.ZIP),
                Click.on(CheckOutFormUi.BUTTON_CONTINUE)
        );
    }

    public static FillFormCheckOutTask fillInputsAndLogin(String first, String last,String zip){
        return Tasks.instrumented(FillFormCheckOutTask.class,first,last,zip);
    }
}
