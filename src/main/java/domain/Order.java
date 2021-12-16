package domain;

public class Order {
    private final Table table;
    private final Menu menu;
    private final int quantity;

    public Order(Table table, Menu menu, int quantity) {
        this.table = table;
        this.menu = menu;
        this.quantity = quantity;
    }

    public Table getTable() {
        return table;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
