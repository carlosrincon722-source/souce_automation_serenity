package starter.tasks.navegation;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class OpenMainLoginTask implements Task {

    private static final EnvironmentVariables ENVIRONMENT_VARIABLES= SystemEnvironmentVariables.createEnvironmentVariables();

    @Override
    public <T extends Actor> void performAs(T actor) {
        String urlWeb= EnvironmentSpecificConfiguration.from(ENVIRONMENT_VARIABLES).getProperty("pages.default");
        actor.attemptsTo(Open.url(urlWeb));
    }

    public static OpenMainLoginTask openMainLogin(){
        return Tasks.instrumented(OpenMainLoginTask.class);
    }
}
