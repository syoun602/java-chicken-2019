package domain;

public class Order {
    private Table table;
    private Menu menu;
    private int quantity;

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
