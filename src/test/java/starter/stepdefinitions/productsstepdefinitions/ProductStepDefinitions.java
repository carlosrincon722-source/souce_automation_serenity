package starter.stepdefinitions.productsstepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.CoreMatchers;
import starter.questions.product.ProdcutCartCounterQuestion;
import starter.questions.product.ProductFilterQuestions;
import starter.tasks.producttasks.AddProductTask;
import starter.tasks.producttasks.OrderProductsTask;
import starter.tasks.producttasks.RemoveProductTask;

import java.util.Random;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static starter.utils.UserSetupUtil.generateRandomNumberOfProduct;

public class ProductStepDefinitions {



    @When("the user select the filter value {string}")
    public void theUserSelectTheFilterValue(String value) {
        OnStage.theActorCalled("user").attemptsTo(OrderProductsTask.orderProducBy(value));
    }

    @Then("the user has to look at the products in a specific order {string} and the value in the filter")
    public void theUserHasToLookAtTheProductsInASpecificOrderAndTheValueInTheFilter(String order) {
        OnStage.theActorCalled("user").should(
                seeThat(ProductFilterQuestions.isOrderBy(order),CoreMatchers.equalTo(true)),
                seeThat(ProductFilterQuestions.isTheValueCorrect(order),CoreMatchers.equalTo(true))
        );

    }

    @When("the user adds a random number of products to the cart")
    public void theUserAddsARandomNumberOfProductsToTheCart() {

        OnStage.theActorCalled("user").remember("cuantity",generateRandomNumberOfProduct());
        OnStage.theActorInTheSpotlight().attemptsTo(AddProductTask.addProduct());
    }

    @Then("the cart counter should display the correct number of products")
    public void theCartCounterShouldDisplayTheCorrectNumberOfProducts() {
        Integer cuantity=OnStage.theActorInTheSpotlight().recall("cuantity");
        OnStage.theActorInTheSpotlight().should(seeThat(ProdcutCartCounterQuestion.prodcutCartCounter(),CoreMatchers.equalTo(cuantity)));
    }

    @And("the user removes the products that he added")
    public void theUserRemovesTheProductsThatHeAdded() {
        //Integer cuantity=OnStage.theActorInTheSpotlight().recall("cuantity");
        OnStage.theActorInTheSpotlight().attemptsTo(RemoveProductTask.removeProduct());
        OnStage.theActorCalled("user").remember("cuantity",0);
    }
}
