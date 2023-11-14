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

    // 에러 메시지 출력
    public static void printErrorMessage(String message){
        outputView.printErrorMessage(message);
    }



}