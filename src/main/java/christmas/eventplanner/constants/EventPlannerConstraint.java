package christmas.eventplanner.constants;

public enum EventPlannerConstraint {
    MIN_DATE(1),
    MAX_DATE(31);

    private final int value;

    EventPlannerConstraint(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
