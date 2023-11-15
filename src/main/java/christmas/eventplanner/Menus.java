package christmas.eventplanner;

import static christmas.eventplanner.constants.EventPlannerConstraint.MAXIMUM_ORDER_QUANTITY;
import static christmas.eventplanner.constants.EventPlannerConstraint.MINIMUM_ORDER_PRICE_FOR_BENEFIT;
import static christmas.utils.constants.ErrorMessage.HAS_DUPLICATE;
import static christmas.utils.constants.ErrorMessage.HAS_EXCESS_ORDER_COUNT;

import christmas.utils.exception.EventPlannerException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Menus {

    private final List<Menu> menus;

    private Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public static Menus create(final List<Menu> rawMenus) {

        checkOrderCountWithinLimit(rawMenus);
        checkHasNoDuplicate(rawMenus);

        return new Menus(rawMenus);
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

    // 총 주문 개수가 20개 이하인지 확인
    public static void checkOrderCountWithinLimit(List<Menu> rawMenus) {
        int totalOrderCount = rawMenus.stream()
                .mapToInt(Menu::getQuantity)
                .sum();

        if (totalOrderCount > MAXIMUM_ORDER_QUANTITY.getValue()) {
            throw EventPlannerException.of(HAS_EXCESS_ORDER_COUNT);
        }
    }


    // 메뉴 컬렉션에 메뉴의 중복이 없는지 확인
    public static void checkHasNoDuplicate(List<Menu> rawMenus) {
        Set<String> menuNames = new HashSet<>();

        for (Menu menu : rawMenus) {
            String name = menu.getName();
            if (menuNames.contains(name)) {
                throw EventPlannerException.of(HAS_DUPLICATE);
            }
            menuNames.add(name);
        }
    }

}
