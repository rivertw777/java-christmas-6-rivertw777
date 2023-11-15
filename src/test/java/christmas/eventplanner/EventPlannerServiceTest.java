package christmas.eventplanner;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class EventPlannerServiceTest {

    private EventPlannerService eventPlannerService;
    private Menus menus;

    @BeforeEach
    void setUp() {
        eventPlannerService = new EventPlannerService(new EventPlannerRepository());
        menus = Menus.create(List.of(
                Menu.create("초코케이크", 3),
                Menu.create("바비큐립", 3)
        ));
        eventPlannerService.saveMenus(menus);
    }

    @Test
    @DisplayName("할인 전 총 금액을 반환하는지")
    void getTotalPriceBeforeDiscount() {
        int actualTotalPrice = eventPlannerService.getTotalPriceBeforeDiscount();
        assertThat(actualTotalPrice).isEqualTo(207000);
    }

    @Test
    @DisplayName("증정 이벤트를 만족하는지 반환하는지")
    void isSatisfiedConditionWithGiftEvent() {
        EventBenefit eventBenefit = EventBenefit.create(VisitDate.create(10), menus);
        eventPlannerService.saveEventBenefit(eventBenefit);

        boolean actualSatisfiedCondition = eventPlannerService.isSatisfiedConditionWithGiftEvent();
        assertThat(actualSatisfiedCondition).isEqualTo(true);
    }

    @Test
    @DisplayName("총 혜택 금액을 반환하는지")
    void getTotalBenefitPrice() {
        EventBenefit eventBenefit = EventBenefit.create(VisitDate.create(10), menus);
        eventPlannerService.saveEventBenefit(eventBenefit);

        int actualBenefitPrice = eventPlannerService.getTotalBenefitPrice();
        assertThat(actualBenefitPrice).isEqualTo(33969);
    }

    @Test
    @DisplayName("할인 후 예상 결제 금액을 반환하는지")
    void getTotalPriceAfterDiscount() {
        EventBenefit eventBenefit = EventBenefit.create(VisitDate.create(10), menus);
        eventPlannerService.saveEventBenefit(eventBenefit);

        int actualTotalPrice = eventPlannerService.getTotalPriceAfterDiscount();
        assertThat(actualTotalPrice).isEqualTo(198031);
    }

}