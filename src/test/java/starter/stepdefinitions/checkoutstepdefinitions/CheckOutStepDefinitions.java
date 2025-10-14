package starter.stepdefinitions.checkoutstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import starter.questions.checkout.MessageValidationQuestion;
import starter.tasks.carttasks.GoCartTask;
import starter.tasks.checkouttasks.CalculateCheckOutPricesTask;
import starter.tasks.checkouttasks.FillFormCheckOutTask;
import starter.tasks.checkouttasks.GoToCheckOutTask;
import starter.tasks.producttasks.AddProductTask;

import static starter.utils.UserSetupUtil.generateRandomNumberOfProduct;

public class CheckOutStepDefinitions {

    @And("the user has added some products and check the products in the cart page")
    public void theUserHasAddedSomeProductsAndCheckTheProductsInTheCartPage() {
        OnStage.theActorCalled("user").remember("cuantity",generateRandomNumberOfProduct());
        OnStage.theActorCalled("user").attemptsTo(
                AddProductTask.addProduct(),
                GoCartTask.goToCartPage());
    }

    @And("the user goes to the checkout page")
    public void theUserGoesToTheCheckoutPage() throws InterruptedException {
        OnStage.theActorCalled("user").attemptsTo(
                GoToCheckOutTask.goToCheckOutTask());



    }


    @And("the user fills the form with first name {string}, last name {string} and postal code {string}")
    public void theUserFillsTheFormWithFirstNameLastNameAndPostalCode(String first, String last, String zip) {
    OnStage.theActorCalled("user").attemptsTo(FillFormCheckOutTask.fillInputsAndLogin(first,last,zip));
    }

    @And("the user calculate the price and finish the purchase")
    public void theUserCalculateThePriceAndFinishThePurchase() {
        OnStage.theActorCalled("user").attemptsTo(CalculateCheckOutPricesTask.calculatePrice());
    }

    @Then("the user should see the message {string}")
    public void theUserShouldSeeTheMessage(String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat("mensaje de confirmación es correcto", MessageValidationQuestion.confirmationOrder(message), Matchers.is(true)));
    }

    @Then("the user should see the error message {string}")
    public void theUserShouldSeeTheErrorMessage(String message) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat("mensaje de confirmación es correcto", MessageValidationQuestion.errorMessageValidation(message), Matchers.is(true)));
    }
}
