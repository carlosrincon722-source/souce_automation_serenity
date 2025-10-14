package starter.tasks.producttasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static starter.ui.productui.ProductUI.SELECT_FILTER;

public class OrderProductsTask implements Task {
    private String value;

    public OrderProductsTask(String value) {
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(SelectFromOptions.byValue(value).from(SELECT_FILTER));
    }

    public static OrderProductsTask orderProducBy(String value){
    return Tasks.instrumented(OrderProductsTask.class,value);
    }
}
