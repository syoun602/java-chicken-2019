package controller;

import domain.Order;
import domain.Table;
import service.PaymentService;
import util.InputValidator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PaymentController {
    private static PaymentController instance;
    private static PaymentService paymentService;

    public static PaymentController getInstance() {
        if (instance == null) {
            instance = new PaymentController();
            paymentService = PaymentService.getInstance();
        }
        return instance;
    }

    public void run() {
        int tableNumber = inputTable();
        try {
            Table table = paymentService.checkPayment(tableNumber);
            List<Order> tableOrders = paymentService.getOrdersByTable(table);
            OutputView.printOrders(tableOrders);
            OutputView.printPaymentProcessingMessage(tableNumber);
            String payMode = InputView.inputPayMode();
            InputValidator.validatePayModeInput(payMode);
            int totalPayment = paymentService.makePayment(table, payMode);
            OutputView.printPayment(totalPayment);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
    }

    private int inputTable() {
        return TableController.inputTableNumber();
    }
}
