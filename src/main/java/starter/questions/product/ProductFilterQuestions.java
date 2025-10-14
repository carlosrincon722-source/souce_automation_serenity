package starter.questions.product;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.SelectedVisibleTextValue;
import starter.ui.productui.ProductUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static starter.ui.productui.ProductUI.SELECT_FILTER;


public class ProductFilterQuestions  {

    public static Question<Boolean> isOrderBy(String order) {
        return actor -> {
            List<String> listNames = ProductUI.NAME_PRODUCT_LABEL.resolveAllFor(actor).stream().map(WebElementFacade::getText).collect(Collectors.toList());
            List<Double> listPrice = ProductUI.PRICE_PRODUCT_LABEL.resolveAllFor(actor).stream().map(WebElementFacade::getText)
                    .map(s -> s.replace("$", ""))
                    .map(Double::parseDouble).collect(Collectors.toList());
            switch (order) {
                case "Name (A to Z)":
                    return isOrderedByNameAz(listNames);
                case "Name (Z to A)":
                    return isOrderedByNameZa(listNames);
                case "Price (low to high)":

                    return isOrderedByPriceLowHigh(listPrice);
                case "Price (high to low)":

                    return isOrderedByPriceHighLow(listPrice);
                default:
                    return false;
            }
        };
    }

    public static Question<Boolean> isTheValueCorrect(String order){
        return actor -> actor.asksFor(SelectedVisibleTextValue.of(SELECT_FILTER)).equals(order);
    }
        private static boolean isOrderedByNameAz(List<String> listNames) {
            List<String> sortedNames = new ArrayList<>(listNames);
            Collections.sort(sortedNames, String.CASE_INSENSITIVE_ORDER);
            return listNames.equals(sortedNames);
        }

        private static boolean isOrderedByNameZa(List<String> listNames) {
            List<String> sortedNames = new ArrayList<>(listNames);
            Collections.sort(sortedNames, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
            return listNames.equals(sortedNames);
        }

        private static boolean isOrderedByPriceLowHigh(List<Double> listPrice) {
            List<Double> sortedPrices = new ArrayList<>(listPrice);
            Collections.sort(sortedPrices);
            return listPrice.equals(sortedPrices);
        }

        private static boolean isOrderedByPriceHighLow(List<Double> listPrice) {
            List<Double> sortedPrices = new ArrayList<>(listPrice);
            Collections.sort(sortedPrices, Collections.reverseOrder());
            return listPrice.equals(sortedPrices);
        }
}
