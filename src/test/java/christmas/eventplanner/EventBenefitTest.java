package christmas.eventplanner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBenefitTest {
    private EventBenefit eventBenefit;

    @BeforeEach
    void setUp() {
        Menus menus = Menus.create(List.of(
                Menu.create("초코케이크", 3),
                Menu.create("바비큐립", 3)
        ));
        eventBenefit = EventBenefit.create(VisitDate.create(10), menus);
    }

    @DisplayName("크리스마스 디데이 할인 금액을 반환하는지")
    @Test
    void getRemainingDayDiscountPrice() {
        assertThat(eventBenefit.getRemainingDayDiscountPrice()).isEqualTo(1900);
    }

    @DisplayName("크리스마스 디데이 할인 조건을 만족하는지")
    @Test
    void isSatisfiedConditionWithRemainingDayDiscount() {
        assertThat(eventBenefit.isSatisfiedConditionWithRemainingDayDiscount()).isTrue();
    }

    @DisplayName("방문날짜에 받을 수 있는 할인 금액을 반환하는지")
    @Test
    void getVisitDateDiscountPrice() {
        assertThat(eventBenefit.getVisitDateDiscountPrice()).isEqualTo(6069);
    }

    @DisplayName("주말인지 확인하는지")
    @Test
    void isWeekend() {
        assertThat(eventBenefit.isWeekend()).isFalse();
    }

    @DisplayName("특별 할인 이벤트 할인 금액을 반환하는지")
    @Test
    void getSpecialDayDiscountPrice() {
        assertThat(eventBenefit.getSpecialDayDiscountPrice()).isEqualTo(1000);
    }

    @DisplayName("증정 이벤트 혜택 금액을 반환하는지")
    @Test
    void getGiftEventBenefitPrice() {
        assertThat(eventBenefit.getGiftEventBenefitPrice()).isEqualTo(25000);
    }

    @DisplayName("증정 이벤트 조건을 만족하는지")
    @Test
    void isSatisfiedConditionWithGiftEvent() {
        assertThat(eventBenefit.isSatisfiedConditionWithGiftEvent()).isTrue();
    }
}