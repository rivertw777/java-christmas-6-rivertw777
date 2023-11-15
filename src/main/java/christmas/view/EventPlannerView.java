package christmas.view;

import java.text.NumberFormat;
import java.util.List;

public class EventPlannerView {
    private static InputView inputView;
    private static OutputView outputView;
    private static final NumberFormat numberFormat = NumberFormat.getInstance();

    // 환영 메시지 출력
    public static void printHelloMessage(){
        outputView.printHelloMessage();
    }

    // 방문 날짜 입력
    public static String inputVisitDate(){
        outputView.printVisitDateAskMessage();
        return inputView.input();
    }

    // 주문 메뉴 입력
    public static String inputOrderMenu(){
        outputView.printOrderMenuAskMessage();
        return inputView.input();
    }

    // 이벤트 혜택 미리보기 메시지 출력
    public static void printEventBenefitsPreviewMessage(int date){
        outputView.printEventBenefitsPreviewMessage(date);
        outputView.printNewLine();
        outputView.printNewLine();
    }

    // 주문 메뉴 출력
    public static void printOrderedMenu(List<String> responses){
        outputView.printOrderedMenu(responses);
        outputView.printNewLine();
    }

    // 할인 전 총 주문 금액 출력
    public static void printTotalPriceBeforeDiscount(int price){
        String formattedPrice = numberFormat.format(price);
        outputView.printTotalPriceBeforeDiscount(formattedPrice);
        outputView.printNewLine();
        outputView.printNewLine();
    }

    // 증정 메뉴 출력
    public static void printGiftMenu(boolean isSatisfied){
        outputView.printGiftMenu(isSatisfied);
        outputView.printNewLine();
    }

    // 혜택 내역 출력
    public static void printBenefitDetail() {
        outputView.printBenefitDetail();
        outputView.printNewLine();
    }

    // 총 혜택 금액 출력
    public static void printTotalBenefitPrice(int price){
        String formattedPrice = numberFormat.format(price);
        outputView.printTotalBenefitPrice(formattedPrice);
        outputView.printNewLine();
        outputView.printNewLine();
    }

    // 할인 후 예상 결제 금액 출력
    public static void printTotalPriceAfterDiscount(int price){
        String formattedPrice = numberFormat.format(price);
        outputView.printTotalPriceAfterDiscount(formattedPrice);
        outputView.printNewLine();
        outputView.printNewLine();
    }

    // 12월 이벤트 배지 출력
    public static void printDecemberEventBadge(int price){
        outputView.printDecemberEventBadge(price);
        outputView.printNewLine();
    }

    // 에러 메시지 출력
    public static void printErrorMessage(String message){
        outputView.printErrorMessage(message);
    }

}