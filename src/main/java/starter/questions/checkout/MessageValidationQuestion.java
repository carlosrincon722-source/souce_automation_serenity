package starter.questions.checkout;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static starter.ui.checkoutui.CheckOutUi.CONFIRMATION_MESSAGE;
import static starter.ui.checkoutui.CheckOutUi.ERROR_MESSAGE;

public class MessageValidationQuestion {

    public static Question<Boolean> confirmationOrder(  String message) {

        return actor -> {
            actor.attemptsTo(WaitUntil.the(CONFIRMATION_MESSAGE, WebElementStateMatchers.isVisible()));
           return CONFIRMATION_MESSAGE.resolveFor(actor).getText().equalsIgnoreCase(message);
        };
    }

    public static Question<Boolean> errorMessageValidation(  String message) {

        return actor -> {
            actor.attemptsTo(WaitUntil.the(ERROR_MESSAGE, WebElementStateMatchers.isVisible()));
            return ERROR_MESSAGE.resolveFor(actor).getText().equalsIgnoreCase(message);
        };
    }



}
