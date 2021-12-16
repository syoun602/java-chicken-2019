package service;

import domain.*;

import java.util.List;

public class PaymentService {
    private static final String NO_REMAINING_ORDER = "주문내역이 존재하지 않습니다.";
    private static final int DEFAULT_VALUE = 0;
    private static final String CASH = "2";
    private static PaymentService instance;

    public static PaymentService getInstance() {
        if (instance == null) {
            instance = new PaymentService();
        }
        return instance;
    }

    public Table checkPayment(int tableNumber) {
        Table table = TableRepository.findByNumber(tableNumber);
        if (TableRepository.checkIsPayed(table)) {
            throw new IllegalArgumentException(NO_REMAINING_ORDER);
        }
        return table;
    }

    public int makePayment(Table table, String payMode) {
        List<Order> orderList = OrderRepository.getOrders();
        int priceToPay = PaymentRepository.getTotalPrice(table, orderList) - calculateDiscount(table, orderList);
        PaymentRepository.updateIsPayed(table);

        if (payMode.equals(CASH)) {
            return (int) (priceToPay * 0.95);
        }
        return priceToPay;
    }

    private int calculateDiscount(Table table, List<Order> orderList) {
        return 10000 * (PaymentRepository.getTotalChickens(table, orderList) / 10);
    }
}
