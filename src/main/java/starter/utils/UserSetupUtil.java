package starter.utils;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.questions.login.LoginSuccesQuestion;
import starter.tasks.logintasks.FillInputsAndLoginTask;
import starter.tasks.navegation.OpenMainLoginTask;

import java.util.Random;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserSetupUtil {

    public static Performable isLoggedIn(String username, String password) {
        return Task.where("login in SauceDemo",
                OpenMainLoginTask.openMainLogin(),
                FillInputsAndLoginTask.fillInputsAndLogin(username, password),
                Ensure.that(LoginSuccesQuestion.validateAlert()).isTrue()
        );
    }

    public static int generateRandomNumberOfProduct(){
        Random random=new Random();
    return random.nextInt(6 - 1 + 1) + 1;

    }
}
