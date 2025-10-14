package starter.questions.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static starter.ui.productui.ProductUI.LABEL_PRODUCT;

public class LoginSuccesQuestion implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(LABEL_PRODUCT, WebElementStateMatchers.isVisible()));


        return actor.asksFor(Text.of(LABEL_PRODUCT)).equals("Products");
    }

    public static Question<Boolean> validateAlert(){
        return new LoginSuccesQuestion();
    }
}
