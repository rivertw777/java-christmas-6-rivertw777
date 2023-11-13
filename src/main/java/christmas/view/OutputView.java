package christmas.view;

import static christmas.view.constants.OutputMessage.ASK_VISIT_DATE;
import static christmas.view.constants.OutputMessage.HELLO_MESSAGE;

import christmas.view.constants.OutputMessage;

public class OutputView {
    public static void printOutputMessage(OutputMessage message) {
        System.out.print(message.getMessage());
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printHelloMessage(){
        printOutputMessage(HELLO_MESSAGE);
    }

    public static void printVisitDateAskMessage() {
        printOutputMessage(ASK_VISIT_DATE);
    }
}