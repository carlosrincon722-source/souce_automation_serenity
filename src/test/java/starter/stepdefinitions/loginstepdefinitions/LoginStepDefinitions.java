package starter.stepdefinitions.loginstepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import starter.questions.login.LoginAlertQuestion;
import starter.questions.login.LoginSuccesQuestion;

import static org.hamcrest.CoreMatchers.equalTo;
import static starter.tasks.logintasks.FillInputsAndLoginTask.fillInputsAndLogin;

public class LoginStepDefinitions {

    @When("the user try to login in the web page with the username {string} and password {string}")
    public void theUserTryToLoginInTheWebPageWithTheUsernameAndPassword(String username, String password) {
        OnStage.theActorCalled("user").attemptsTo(fillInputsAndLogin(username,password));
    }
    @Then("the user must see the result {string}")
    public void theUserMustSeeTheResult(String alert) {
        OnStage.theActorCalled("user").should(GivenWhenThen.seeThat(LoginAlertQuestion.validateAlert(),equalTo(alert)));
    }

    @Then("the user must see the inventory")
    public void theUserMustSeeTheInventory() {
        OnStage.theActorCalled("user").should(GivenWhenThen.seeThat(LoginSuccesQuestion.validateAlert(),equalTo(true)));
    }
}
