package christmas.eventplanner;

import christmas.eventplanner.constants.MenuInfo;
import java.util.Arrays;

public class Menu {
    private final String name;
    private final int quantity;

    private Menu(String name, int quantity){
        this.name=name;
        this.quantity=quantity;
    }

    public static Menu create(String name, int quantity) {
        return new Menu(name, quantity);
    }

    public String getName(){
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return Arrays.stream(MenuInfo.values())
                .filter(menuInfo -> name.equals(menuInfo.getName()))
                .mapToInt(menuInfo -> menuInfo.getPrice() * quantity)
                .sum();
    }

}
