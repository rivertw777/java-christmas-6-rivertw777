package christmas.eventplanner.dto;

import static christmas.eventplanner.constants.BenefitDetailMessage.CHRISTMAS_REMAINING_DAY_DISCOUNT;
import static christmas.eventplanner.constants.BenefitDetailMessage.GIFT_EVENT;
import static christmas.eventplanner.constants.BenefitDetailMessage.SPECIAL_DISCOUNT;
import static christmas.eventplanner.constants.BenefitDetailMessage.WEEKDAY_DISCOUNT;
import static christmas.eventplanner.constants.BenefitDetailMessage.WEEKEND_DISCOUNT;
import static christmas.eventplanner.constants.EventPlannerConstraint.NO_DISCOUNT;

import christmas.eventplanner.EventBenefit;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public record BenefitDetailDto(EventBenefit eventBenefit) {
    private static final NumberFormat numberFormat = NumberFormat.getInstance();
    public List<String> getResponses(){
        List<String> responses = new ArrayList<>();

        addMessageIfNotNull(responses, RemainingDayDiscountMessage());
        addMessageIfNotNull(responses, VisitDateDiscountMessage());
        addMessageIfNotNull(responses, SpecialDayDiscountMessage());
        addMessageIfNotNull(responses, GiftEventMessage());

        return responses;
    }

    private void addMessageIfNotNull(List<String> responses, String message) {
        if (message != null) {
            responses.add(message);
        }
    }

    private String RemainingDayDiscountMessage() {
        int price = eventBenefit.getRemainingDayDiscountPrice();
        if (price!= NO_DISCOUNT.getValue()) {
            String FormattedPrice = numberFormat.format(price);
            return String.format(CHRISTMAS_REMAINING_DAY_DISCOUNT.getMessage(), FormattedPrice);
        }
        return null;
    }

    private String VisitDateDiscountMessage() {
        int price = eventBenefit.getVisitDateDiscountPrice();
        if (price!= NO_DISCOUNT.getValue()) {
            String FormattedPrice = numberFormat.format(price);
            return weekendOrWeekdayMessage(FormattedPrice);
        }
        return null;
    }

    private String weekendOrWeekdayMessage(String FormattedPrice) {
        if (eventBenefit.isWeekend()){
            return String.format(WEEKEND_DISCOUNT.getMessage(), FormattedPrice);
        }
        return String.format(WEEKDAY_DISCOUNT.getMessage(), FormattedPrice);
    }

    private String SpecialDayDiscountMessage() {
        int price = eventBenefit().getSpecialDayDiscountPrice();
        if (price!=NO_DISCOUNT.getValue()) {
            String FormattedPrice = numberFormat.format(price);
            return String.format(SPECIAL_DISCOUNT.getMessage(), FormattedPrice);
        }
        return null;
    }

    private String GiftEventMessage() {
        int price = eventBenefit().getGiftEventBenefitPrice();
        if (price!=NO_DISCOUNT.getValue()) {
            String FormattedPrice = numberFormat.format(price);
            return String.format(GIFT_EVENT.getMessage(), FormattedPrice);
        }
        return null;
    }

}
