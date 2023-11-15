package christmas.eventplanner;

import static christmas.eventplanner.constants.EventPlannerConstraint.CHRISTMAS;
import static christmas.eventplanner.constants.EventPlannerConstraint.TARGET_PRICE_FOR_GIFT;

import christmas.eventplanner.constants.MenuInfo;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class EventBenefit {
    private final int visitDate;
    private final Menus menus;

    private EventBenefit(int visitDate, Menus menus){
        this.visitDate = visitDate;
        this.menus = menus;
    }

    public static EventBenefit create(final VisitDate visitDate, final Menus menus) {
        return new EventBenefit(visitDate.getDate(), menus);
    }

    // 크리스마스 디데이 할인 금액 반환
    public int getRemainingDayDiscountPrice(){
        if (isSatisfiedConditionWithRemainingDayDiscount()){
            return calculateRemainingDayDiscountPrice();
        }
        return 0;
    }

    // 크리스마스 디데이 할인이 적용되는지 반환
    public boolean isSatisfiedConditionWithRemainingDayDiscount() {
        return visitDate <= CHRISTMAS.getValue();
    }

    // 크리스마스 디데이 할인 금액 계산
    private int calculateRemainingDayDiscountPrice(){
        if(visitDate >= 1 && visitDate <= CHRISTMAS.getValue()){
            return 1000 + (visitDate-1)*100;
        }
        return 0;
    }

    // 방문 날짜가 주말인지 할인인지에 따라 할인 금액 반환
    public int getVisitDateDiscountPrice(){
        if(isWeekend()){
            return getWeekendDiscountPrice();
        }
        return getWeekdayDiscountPrice();
    }

    // 주말인지 아닌지 반환
    private boolean isWeekend(){
        LocalDate date = LocalDate.of(2023, 12, visitDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    // 평일 할인 금액 반환
    private int getWeekdayDiscountPrice() {
        return menus.getTotalDessertPrice();
    }

    // 주말 할인 금액 반환
    private int getWeekendDiscountPrice() {
        return menus.getTotalMainPrice();
    }

    // 특별 할인 적용 금액 반환
    public int getSpecialDayDiscountPrice(){
        if(isSpecialDay()){
            return 1000;
        }
        return 0;
    }

    // 특별 할인이 가능한지 반환
    private boolean isSpecialDay(){
        LocalDate date = LocalDate.of(2023, 12, visitDate);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SUNDAY || visitDate == CHRISTMAS.getValue();
    }

    // 증정 이벤트 혜택 금액 반환
    public int getGiftEventBenefitPrice(){
        if (isSatisfiedConditionWithGiftEvent()){
            return calculateEventBenefitPrice();
        }
        return 0;
    }

    // 증정 이벤트를 만족하는지 반환
    public boolean isSatisfiedConditionWithGiftEvent() {
        return menus.getTotalPrice() >= TARGET_PRICE_FOR_GIFT.getValue();
    }

    // 증정 이벤트 혜택 금액 계산
    private int calculateEventBenefitPrice() {
        return Arrays.stream(MenuInfo.values())
                .filter(menu -> menu.getName().equals(MenuInfo.CHAMPAGNE.getName()))
                .findFirst()
                .map(MenuInfo::getPrice)
                .orElse(0);
    }

}
