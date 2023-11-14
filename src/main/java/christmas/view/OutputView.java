package christmas.view;

import static christmas.view.constants.OutputMessage.EVENT_BENEFITS_PREVIEW;
import static christmas.view.constants.OutputMessage.GIFT_MENU;
import static christmas.view.constants.OutputMessage.HELLO;
import static christmas.view.constants.OutputMessage.ASK_ORDER_MENU;
import static christmas.view.constants.OutputMessage.ASK_VISIT_DATE;
import static christmas.view.constants.OutputMessage.ORDER_MENU;
import static christmas.view.constants.OutputMessage.SATISFIED_CASE;
import static christmas.view.constants.OutputMessage.TOTAL_PRICE_BEFORE_DISCOUNT;
import static christmas.view.constants.OutputMessage.UNSATISFIED_CASE;


public class OutputView {

    private OutputView(){}

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printHelloMessage(){
        System.out.println(HELLO.getMessage());
    }

    public static void printVisitDateAskMessage() {
        System.out.println(ASK_VISIT_DATE.getMessage());
    }

    public static void printOrderMenuAskMessage() {
        System.out.println(ASK_ORDER_MENU.getMessage());
    }

    public static void printEventBenefitsPreviewMessage() {
        System.out.println(EVENT_BENEFITS_PREVIEW.getMessage());
    }

    public static void printOrderedMenu(){
        System.out.println(ORDER_MENU.getMessage());
    }

    public static void printTotalPriceBeforeDiscount(int price){
        System.out.println(TOTAL_PRICE_BEFORE_DISCOUNT.getMessage());
        System.out.printf("%d원", price);
    }

    public static void printGiftMenu(boolean isSatisfied){
        System.out.println(GIFT_MENU.getMessage());
        if (isSatisfied)
            System.out.println(SATISFIED_CASE.getMessage());
        else
            System.out.println(UNSATISFIED_CASE.getMessage());
    }

}