package christmas.view;

import static christmas.view.constants.OutputMessage.ASK_ORDER_MENU;
import static christmas.view.constants.OutputMessage.ASK_VISIT_DATE;
import static christmas.view.constants.OutputMessage.HELLO_MESSAGE;

public class OutputView {

    private OutputView(){}

    public static void printErrorMessage(String message) {
        System.out.print(message);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printHelloMessage(){
        System.out.print(HELLO_MESSAGE.getMessage());
    }

    public static void printVisitDateAskMessage() {
        System.out.print(ASK_VISIT_DATE.getMessage());
    }

    public static void printOrderMenuMessage() {
        System.out.print(ASK_ORDER_MENU.getMessage());
    }


}