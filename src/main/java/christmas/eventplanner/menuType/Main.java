package christmas.eventplanner.menuType;

public enum Main {
    T_BONE_STEAK("티본스테이크", 55000),
    BBQ_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000);

    private String name;
    private int price;

    Main(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
