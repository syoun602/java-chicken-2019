package service;

import domain.*;
import repository.OrderRepository;
import repository.PaymentRepository;
import repository.TableRepository;

import java.util.List;

public class PaymentService {
    private static final String CASH = "2";
    private static final double CASH_DISCOUNT = 0.95;
    private static final int DISCOUNT_PRICE = 10000;
    private static final int DISCOUNT_QUANTITY = 10;
    private static PaymentService instance;

    public static PaymentService getInstance() {
        if (instance == null) {
            instance = new PaymentService();
        }
        return instance;
    }

    public int makePayment(Table table, String payMode) {
        List<Order> orderList = OrderRepository.getOrders();
        int priceToPay = PaymentRepository.getTotalPrice(table, orderList) - calculateDiscount(table, orderList);
        TableRepository.orderPayed(table);
        OrderRepository.deleteOrder(table);

        if (payMode.equals(CASH)) {
            return (int) (priceToPay * CASH_DISCOUNT);
        }
        return priceToPay;
    }

    private int calculateDiscount(Table table, List<Order> orderList) {
        return DISCOUNT_PRICE * (PaymentRepository.getTotalChickens(table, orderList) / DISCOUNT_QUANTITY);
    }
}
