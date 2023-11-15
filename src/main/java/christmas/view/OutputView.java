package christmas.view;

import static christmas.view.constants.OutputMessage.BENEFIT_DETAIL;
import static christmas.view.constants.OutputMessage.DECEMBER_EVENT_BADGE;
import static christmas.view.constants.OutputMessage.EVENT_BENEFITS_PREVIEW;
import static christmas.view.constants.OutputMessage.GIFT_MENU;
import static christmas.view.constants.OutputMessage.HELLO;
import static christmas.view.constants.OutputMessage.ASK_ORDER_MENU;
import static christmas.view.constants.OutputMessage.ASK_VISIT_DATE;
import static christmas.view.constants.OutputMessage.ORDER_MENU;
import static christmas.view.constants.OutputMessage.SATISFIED_CASE;
import static christmas.view.constants.OutputMessage.TOTAL_BENEFIT_PRICE;
import static christmas.view.constants.OutputMessage.TOTAL_PRICE_AFTER_DISCOUNT;
import static christmas.view.constants.OutputMessage.TOTAL_PRICE_BEFORE_DISCOUNT;
import static christmas.view.constants.OutputMessage.UNSATISFIED_CASE;

import java.util.List;


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

    public static void printEventBenefitsPreviewMessage(int date) {
        System.out.printf(EVENT_BENEFITS_PREVIEW.getMessage(), date);
    }

    public static void printOrderedMenu(List<String> responses){
        System.out.println(ORDER_MENU.getMessage());
        responses.forEach(System.out::println);
    }

    public static void printTotalPriceBeforeDiscount(int price){
        System.out.printf(TOTAL_PRICE_BEFORE_DISCOUNT.getMessage(),price);
    }

    public static void printGiftMenu(boolean isSatisfied){
        System.out.println(GIFT_MENU.getMessage());
        if (isSatisfied) {
            System.out.println(SATISFIED_CASE.getMessage());
            return;
        }
        System.out.println(UNSATISFIED_CASE.getMessage());
    }

    public static void printBenefitDetail() {
        System.out.println(BENEFIT_DETAIL.getMessage());
    }

    public static void printTotalBenefitPrice(int price){
        System.out.printf(TOTAL_BENEFIT_PRICE.getMessage(),price);
    }

    public static void printTotalPriceAfterDiscount(int price){
        System.out.printf(TOTAL_PRICE_AFTER_DISCOUNT.getMessage(),price);
    }

    public static void printDecemberEventBadge(){
        System.out.println(DECEMBER_EVENT_BADGE.getMessage());
    }
}