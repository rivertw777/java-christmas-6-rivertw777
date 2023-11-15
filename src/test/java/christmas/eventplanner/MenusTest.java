package christmas.eventplanner;

import christmas.utils.exception.EventPlannerException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MenusTest {
    private Menus menus;

    @BeforeEach
    void setUp() {
        menus = Menus.create(List.of(Menu.create("초코케이크", 3),
                Menu.create("바비큐립", 3)));
    }

    @DisplayName("이벤트 혜택을 받을 수 있는지")
    @Test
    void canGetEventBenefit() {
        assertThat(menus.canGetEventBenefit()).isEqualTo(true);
    }

    @DisplayName("메뉴의 총 금액을 구하는지")
    @Test
    void getTotalPrice() {
        assertThat(menus.getTotalPrice()).isEqualTo(207000);
    }

    @DisplayName("디저트 메뉴의 총 할인 금액을 구하는지")
    @Test
    void getTotalDessertDiscountPrice() {
        assertThat(menus.getTotalDessertDiscountPrice()).isEqualTo(6069);
    }

    @DisplayName("메인 메뉴의 총 할인 금액을 구하는지")
    @Test
    void getTotalMainDiscountPrice() {
        assertThat(menus.getTotalMainDiscountPrice()).isEqualTo(6069);
    }

    @DisplayName("총 주문 개수가 제한을 초과하는 경우 예외가 발생하는지")
    @Test
    void checkOrderCountWithinLimit() {
        assertThatThrownBy(() -> Menus.checkOrderCountWithinLimit(List.of(
                Menu.create("초코케이크", 3),
                Menu.create("바비큐립", 20)
        ))).isInstanceOf(EventPlannerException.class);
    }

    @DisplayName("메뉴에 중복된 항목이 있는 경우 예외가 발생하는지")
    @Test
    void checkHasNoDuplicate() {
        assertThatThrownBy(() -> Menus.checkHasNoDuplicate(List.of(
                Menu.create("초코케이크", 3),
                Menu.create("바비큐립", 3),
                Menu.create("초코케이크", 2)
        ))).isInstanceOf(EventPlannerException.class);
    }

}
