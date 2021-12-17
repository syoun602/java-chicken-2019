package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderRepository {
    private static final List<Order> orders = new ArrayList<>();

    public static void saveOrder(Table table, Menu menu, int quantity) {
        Order order = new Order(table, menu, quantity);
        orders.add(order);
    }

    public static List<Order> getOrders() {
        return orders;
    }

    public static void deleteOrder(Table table) {
        orders.removeIf(order -> order.getTable().equals(table));
    }

    public static Order findByTableAndMenu(Table table, Menu menu) {
        return orders.stream()
                .filter(order -> order.getTable().equals(table))
                .filter(order -> order.getMenu().equals(menu))
                .findAny()
                .orElse(null);
    }

    public static void updateOrder(Order order, int quantity) {
        order.addQuantity(quantity);
    }

    public static List<Order> getOrdersByTable(Table table) {
        return orders.stream()
                .filter(order -> order.getTable().equals(table))
                .collect(Collectors.toList());
    }
}
