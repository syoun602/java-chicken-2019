package domain;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public static void saveOrder(Table table, Menu menu, int quantity) {
        Order order = new Order(table, menu, quantity);
        orders.add(order);
    }

    public static List<Order> getOrders() {
        return orders;
    }
}
