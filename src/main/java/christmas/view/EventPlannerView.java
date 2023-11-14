package christmas.view;

public class EventPlannerView {
    private static InputView inputView;
    private static OutputView outputView;

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
    public static void printEventBenefitsPreviewMessage(){
        outputView.printEventBenefitsPreviewMessage();
        outputView.printNewLine();
    }

    // 주문 메뉴 출력
    public static void printOrderedMenu(){
        outputView.printOrderedMenu();
        outputView.printNewLine();
    }

    // 할인 전 총 주문 금액 출력
    public static void printTotalPriceBeforeDiscount(int price){
        outputView.printTotalPriceBeforeDiscount(price);
        outputView.printNewLine();
        outputView.printNewLine();
    }

    // 증정 메뉴 출력
    public static void printGiftMenu(boolean isSatisfied){
        outputView.printGiftMenu(isSatisfied);
    }

    // 에러 메시지 출력
    public static void printErrorMessage(String message){
        outputView.printErrorMessage(message);
    }



}