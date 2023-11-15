package christmas.eventplanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {
    private Menu menu1;
    private Menu menu2;

    @BeforeEach
    void setUp(){
        menu1 = Menu.create("초코케이크",3);
        menu2 = Menu.create("바비큐립",3);
    }

    @DisplayName("메뉴의 총 가격을 구하는지")
    @Test
    void getPrice() {
        assertThat(menu1.getPrice()).isEqualTo(45000);
    }

    @DisplayName("디저트 메뉴의 할인이 적용되는지")
    @Test
    void getDessertPrice() {
        assertThat(menu1.getDessertDiscountPrice()).isEqualTo(6069);
    }

    @DisplayName("디저트 메뉴의 할인이 적용되는지")
    @Test
    void getDessertPrice2() {
        assertThat(menu2.getDessertDiscountPrice()).isEqualTo(0);
    }

    @DisplayName("메인 메뉴의 할인이 적용되는지")
    @Test
    void getMainPrice() {
        assertThat(menu2.getMainDiscountPrice()).isEqualTo(6069);
    }

    @DisplayName("메인 메뉴의 할인이 적용되는지")
    @Test
    void getMainPrice2() {
        assertThat(menu1.getMainDiscountPrice()).isEqualTo(0);
    }
}