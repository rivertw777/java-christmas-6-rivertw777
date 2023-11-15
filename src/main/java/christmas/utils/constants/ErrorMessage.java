package christmas.utils.constants;

public enum ErrorMessage {

    ERROR_PREFIX("[ERROR] "),

    // 입력값 에러
    NOT_INTEGER("입력값이 숫자가 아닙니다. 다시 입력해 주세요."),
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_MENU_FORMAT("메뉴 형식이 잘못되었습니다. 다시 입력해 주세요."),

    // 방문 날짜 에러
    OUT_OF_RANGE_DATE("법위 밖의 날짜입니다. 다시 예약해 주세요."),

    // 메뉴 주문 에러
    NO_SUCH_MENU("메뉴판에 없는 메뉴를 주문하였습니다. 다시 주문해 주세요."),
    HAS_DUPLICATE("중복 메뉴를 주문하였습니다. 다시 주문해 주세요."),
    HAS_ONLY_BEVERAGE("음료만 주문하였습니다. 다시 주문해 주세요."),
    HAS_EXCESS_ORDER_COUNT("주문 개수가 20개를 초과하였습니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
