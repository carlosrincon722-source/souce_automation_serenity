package starter.questions.cart;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import starter.questions.product.ProdcutCartCounterQuestion;
import starter.ui.productui.ProductUI;

import java.util.List;

import static starter.ui.cartui.CartUi.LIST_ITEMS;

public class CartNumberQuestion implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        List<WebElementFacade> element= LIST_ITEMS.resolveAllFor(actor);
        if(element.isEmpty()){
            return 0;
        }
        return element.size();
    }

    public static Question<Integer> CartCounterProducts(){
        return new CartNumberQuestion();
    }
}