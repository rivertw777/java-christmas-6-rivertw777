package christmas.eventplanner;

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

    public int getTotalPrice() {
        return menus.stream()
                .mapToInt(Menu::getPrice)
                .sum();
    }

    public int getTotalDessertPrice() {
        return menus.stream()
                .mapToInt(Menu::getDessertDiscountPrice)
                .sum();
    }

    public int getTotalMainPrice() {
        return menus.stream()
                .mapToInt(Menu::getMainDiscountPrice)
                .sum();
    }

}
