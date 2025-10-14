package starter.stepdefinitions.hooks;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import starter.tasks.navegation.OpenMainLoginTask;

import static starter.utils.UserSetupUtil.isLoggedIn;

public class CommonSteps {
    @Given("The user open the web page")
    public void theUserOpenTheWebPage() {
        OnStage.theActorCalled("user").attemptsTo(OpenMainLoginTask.openMainLogin());
    }

    @Given("The user has logged in with the username {string} and the password {string}")
    public void the_user_has_logged_in_with_the_username_and_the_password(String user, String password) {
       OnStage.theActorCalled("user").attemptsTo(isLoggedIn(user,password));
    }
}
