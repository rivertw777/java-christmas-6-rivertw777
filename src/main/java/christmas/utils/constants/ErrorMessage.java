package christmas.utils.constants;

public enum ErrorMessage {

    ERROR_PREFIX("[ERROR] "),

    // 입력값 에러
    NOT_INTEGER("입력값이 숫자가 아닙니다. 다시 입력해 주세요."),

    // 방문날짜 에러
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    // 주문메뉴 에러

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
