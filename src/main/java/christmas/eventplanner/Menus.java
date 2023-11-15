package christmas.eventplanner;

import static christmas.eventplanner.constants.EventPlannerConstraint.MINIMUM_ORDER_PRICE_FOR_BENEFIT;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Menus {

    private final List<Menu> menus;

    private Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public static Menus create(final Map<String, Integer> OrderedMenuInput) {
        List<Menu> menuList = OrderedMenuInput.entrySet().stream()
                .map(entry -> Menu.create(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return new Menus(menuList);
    }

    public List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    public boolean canGetEventBenefit(){
        return getTotalPrice()>=MINIMUM_ORDER_PRICE_FOR_BENEFIT.getValue();
    }

    // 메뉴 컬렉션의 총 주문 금액 반환
    public int getTotalPrice() {
        return menus.stream()
                .mapToInt(Menu::getPrice)
                .sum();
    }

    // 메뉴 컬렉션의 총 디저트 할인 금액 반환
    public int getTotalDessertDiscountPrice() {
        return menus.stream()
                .mapToInt(Menu::getDessertDiscountPrice)
                .sum();
    }

    // 메뉴 컬렉션의 총 메인메뉴 할인 금액 반환
    public int getTotalMainDiscountPrice() {
        return menus.stream()
                .mapToInt(Menu::getMainDiscountPrice)
                .sum();
    }

}
