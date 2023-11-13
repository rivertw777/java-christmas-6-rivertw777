package christmas.view.constants;

public enum OutputMessage {
    HELLO_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n"),
    ASK_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n");

    private final String message;

    OutputMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
