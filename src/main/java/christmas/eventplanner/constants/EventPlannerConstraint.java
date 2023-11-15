package christmas.eventplanner.constants;

public enum EventPlannerConstraint {
    MIN_DATE(1),
    MAX_DATE(31),
    MINIMUM_ORDER_PRICE_FOR_BENEFIT(10000),
    TARGET_PRICE_FOR_GIFT(120000),
    THIS_YEAR(2023),
    THIS_MONTH(12),
    FIRST_DAY(1),
    CHRISTMAS(25),
    SPECIAL_DAY_DISCOUNT_PRICE(1000),
    NO_DISCOUNT(0),
    DEFAULT_DISCOUNT_PRICE(1000),
    DAILY_ADDITIONAL_AMOUNT(100);

    private final int value;

    EventPlannerConstraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
