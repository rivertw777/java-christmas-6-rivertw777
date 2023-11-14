package christmas.eventplanner;

import christmas.eventplanner.constants.MenuInfo;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Menus {

    private final List<Menu> menus;

    private Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public static Menus create(Map<String, Integer> OrderedMenuInput) {
        List<Menu> menuList = OrderedMenuInput.entrySet().stream()
                .map(entry -> Menu.create(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return new Menus(menuList);
    }

    public List<Menu> getMenus() {
        return Collections.unmodifiableList(menus);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Menu menu : menus) {
            totalPrice += menu.getPrice();
        }
        return totalPrice;
    }

}
