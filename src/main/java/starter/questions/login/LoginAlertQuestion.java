package starter.questions.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static starter.ui.Loginui.LoginUI.ALERT_TEXT;

public class LoginAlertQuestion implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(ALERT_TEXT, WebElementStateMatchers.isVisible()));


        return actor.asksFor(Text.of(ALERT_TEXT));
    }

    public static Question<String> validateAlert(){
        return new LoginAlertQuestion();
    }
}
