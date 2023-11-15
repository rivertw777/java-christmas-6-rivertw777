package christmas.eventplanner;

import static christmas.eventplanner.constants.EventPlannerConstraint.*;

import christmas.eventplanner.constants.MenuInfo;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class EventBenefit {
    private final int visitDate;
    private final Menus menus;

    private EventBenefit(int visitDate, Menus menus) {
        this.visitDate = visitDate;
        this.menus = menus;
    }

    public static EventBenefit create(final VisitDate visitDate, final Menus menus) {
        return new EventBenefit(visitDate.getDate(), menus);
    }

    // 크리스마스 디데이 할인 금액 반환
    public int getRemainingDayDiscountPrice() {
        if (menus.canGetEventBenefit() && isSatisfiedConditionWithRemainingDayDiscount()) {
            return calculateRemainingDayDiscountPrice();
        }
        return NO_DISCOUNT.getValue();
    }

    // 크리스마스 디데이 할인을 받을 수 있는지
    public boolean isSatisfiedConditionWithRemainingDayDiscount() {
        return visitDate <= CHRISTMAS.getValue();
    }

    // 크리스마스 디데이 할인 금액 계산
    private int calculateRemainingDayDiscountPrice() {
        if (visitDate >= FIRST_DAY.getValue() && visitDate <= CHRISTMAS.getValue()) {
            return DEFAULT_DISCOUNT_PRICE.getValue() + (visitDate - 1) * DAILY_ADDITIONAL_AMOUNT.getValue();
        }
        return NO_DISCOUNT.getValue();
    }

    // 방문날짜에 받을 수 있는 할인 금액 반환
    public int getVisitDateDiscountPrice() {
        if (menus.canGetEventBenefit()) {
            if (isWeekend()) {
                return menus.getTotalMainDiscountPrice();
            }
            return menus.getTotalDessertDiscountPrice();
        }
        return NO_DISCOUNT.getValue();
    }

    // 주말인지
    public boolean isWeekend() {
        LocalDate date = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), visitDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    // 특별 할인 이벤트 할인 금액 반환
    public int getSpecialDayDiscountPrice() {
        if (menus.canGetEventBenefit() && isSpecialDay()) {
            return SPECIAL_DAY_DISCOUNT_PRICE.getValue();
        }
        return NO_DISCOUNT.getValue();
    }

    // 스페셜 데이(별)인지
    private boolean isSpecialDay() {
        LocalDate date = LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), visitDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SUNDAY || visitDate == CHRISTMAS.getValue();
    }

    // 증정 이벤트 혜택 금액 반환
    public int getGiftEventBenefitPrice() {
        if (menus.canGetEventBenefit() && isSatisfiedConditionWithGiftEvent()) {
            return calculateEventBenefitPrice();
        }
        return NO_DISCOUNT.getValue();
    }

    // 증정 이벤트 조건에 충족하는지
    public boolean isSatisfiedConditionWithGiftEvent() {
        return menus.getTotalPrice() >= TARGET_PRICE_FOR_GIFT.getValue();
    }

    // 샴페인 1개의 가격 반환
    private int calculateEventBenefitPrice() {
        return Arrays.stream(MenuInfo.values())
                .filter(menu -> menu.getName().equals(MenuInfo.CHAMPAGNE.getName()))
                .findFirst()
                .map(MenuInfo::getPrice)
                .orElse(NO_DISCOUNT.getValue());
    }
}
