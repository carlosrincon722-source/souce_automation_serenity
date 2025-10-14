package starter.tasks.logintasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static starter.ui.Loginui.LoginUI.*;

public class FillInputsAndLoginTask implements Task {

    public String username,password;

    public FillInputsAndLoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(INPUT_USERNAME),
                Enter.theValue(password).into(INPUT_PASSWORD),
                Click.on(BUTTON_LOGIN)
        );
    }

    public static FillInputsAndLoginTask fillInputsAndLogin(String username,String password){
        return Tasks.instrumented(FillInputsAndLoginTask.class,username,password);
    }
}
