package christmas.eventplanner.constants;

public enum BenefitDetailMessage {

    CHRISTMAS_REMAINING_DAY_DISCOUNT("크리스마스 디데이 할인: -%s원"),
    WEEKDAY_DISCOUNT("평일 할인: -%s원"),
    WEEKEND_DISCOUNT("주말 할인: -%s원"),
    SPECIAL_DISCOUNT("특별 할인: -%s원"),
    GIFT_EVENT("증정 이벤트: -%s원");

    private final String message;

    BenefitDetailMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
