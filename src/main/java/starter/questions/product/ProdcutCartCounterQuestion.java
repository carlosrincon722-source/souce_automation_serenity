package starter.questions.product;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import starter.ui.productui.ProductUI;

import java.util.List;

public class ProdcutCartCounterQuestion implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        List<WebElementFacade> element=ProductUI.COUNTER_PRODUCTS_CART.resolveAllFor(actor);
        if(element.isEmpty()){
            return 0;
        }
        return Integer.valueOf(element.get(0).getText());
    }

    public static Question<Integer> prodcutCartCounter(){
        return new ProdcutCartCounterQuestion();
    }
}
