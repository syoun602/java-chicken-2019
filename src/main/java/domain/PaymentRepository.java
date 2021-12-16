package domain;

import java.util.List;

import static domain.Category.CHICKEN;

public class PaymentRepository {
    public static int getTotalPrice(Table table, List<Order> orderList) {
        return orderList.stream()
                .filter(order -> order.getTable().equals(table))
                .mapToInt(order -> order.getMenu().getPrice() * order.getQuantity())
                .sum();
    }

    public static int getTotalChickens(Table table, List<Order> orderList) {
        return orderList.stream()
                .filter(order -> order.getTable().equals(table))
                .filter(order -> order.getMenu().getCategory().equals(CHICKEN))
                .mapToInt(Order::getQuantity)
                .sum();
    }
}
