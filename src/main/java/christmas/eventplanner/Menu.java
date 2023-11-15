package christmas.eventplanner;

import static christmas.eventplanner.constants.EventPlannerConstraint.THIS_YEAR;

import christmas.eventplanner.constants.MenuInfo;
import java.util.Arrays;

public class Menu {
    private final String name;
    private final int quantity;

    private Menu(String name, int quantity){
        this.name=name;
        this.quantity=quantity;
    }

    public static Menu create(final String name, final int quantity) {
        return new Menu(name, quantity);
    }

    public String getName(){
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    // 메뉴 클래스의 주문 금액 반환
    public int getPrice() {
        return Arrays.stream(MenuInfo.values())
                .filter(menuInfo -> name.equals(menuInfo.getName()))
                .mapToInt(menuInfo -> menuInfo.getPrice() * quantity)
                .sum();
    }

    // 메뉴 클래스의 디저트 할인 금액 반환
    public int getDessertDiscountPrice() {
        return Arrays.stream(MenuInfo.values())
                .filter(menuInfo -> menuInfo.getName().equals(name) && menuInfo.getType().equals("Dessert"))
                .mapToInt(menuInfo -> THIS_YEAR.getValue() * quantity)
                .sum();
    }

    // 메뉴 클래스의 메인메뉴 할인 금액 반환
    public int getMainDiscountPrice() {
        return Arrays.stream(MenuInfo.values())
                .filter(menuInfo -> menuInfo.getName().equals(name) && menuInfo.getType().equals("Main"))
                .mapToInt(menuInfo -> THIS_YEAR.getValue() * quantity)
                .sum();
    }

}
