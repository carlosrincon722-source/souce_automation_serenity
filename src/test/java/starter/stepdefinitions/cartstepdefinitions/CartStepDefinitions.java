package starter.stepdefinitions.cartstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.CoreMatchers;
import starter.questions.cart.CartNumberQuestion;
import starter.questions.product.ProdcutCartCounterQuestion;
import starter.tasks.carttasks.GoCartTask;
import starter.tasks.producttasks.RemoveProductTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CartStepDefinitions {


    @And("the user go to the cart page")
    public void theUserRemovesTheProductsThatHeAdded() {
        OnStage.theActorCalled("user").attemptsTo(GoCartTask.goToCartPage());
    }

    @Then("The user sees the same number of products that he selected")
    public void theCartCounterShouldDisplayTheCorrectNumberOfProducts() {
        Integer cuantity=OnStage.theActorInTheSpotlight().recall("cuantity");
        OnStage.theActorInTheSpotlight().should(seeThat(CartNumberQuestion.CartCounterProducts(), CoreMatchers.equalTo(cuantity)));
    }
}
