package christmas.eventplanner;

import static christmas.eventplanner.constants.EventPlannerConstraint.MAX_DATE;
import static christmas.eventplanner.constants.EventPlannerConstraint.MIN_DATE;
import static christmas.utils.constants.ErrorMessage.OUT_OF_RANGE_DATE;

import christmas.utils.exception.EventPlannerException;

public class VisitDate {
    private final int date;

    private VisitDate(int date) {
        this.date = date;
    }

    public static VisitDate create(final int date) {
        checkRange(date);
        return new VisitDate(date);
    }

    // 날짜 범위 검증
    private static void checkRange(int date) {
        if (date < MIN_DATE.getValue() || date > MAX_DATE.getValue()) {
            throw EventPlannerException.of(OUT_OF_RANGE_DATE);
        }
    }

    public int getDate() {
        return date;
    }
}
