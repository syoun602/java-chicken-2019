package controller;

import domain.Order;
import domain.Table;
import service.OrderService;
import service.PaymentService;
import service.TableService;
import util.InputValidator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PaymentController {
    private static PaymentController instance;
    private static PaymentService paymentService;
    private static TableService tableService;
    private static OrderService orderService;

    public static PaymentController getInstance() {
        if (instance == null) {
            instance = new PaymentController();
            paymentService = PaymentService.getInstance();
            tableService = TableService.getInstance();
            orderService = OrderService.getInstance();
        }
        return instance;
    }

    public void run() {
        int tableNumber = inputTable();
        try {
            Table table = tableService.getTable(tableNumber);
            initPayment(table);
            String payMode = InputView.inputPayMode();
            InputValidator.validatePayModeInput(payMode);
            int totalPayment = paymentService.makePayment(table, payMode);
            OutputView.printPayment(totalPayment);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
    }

    private void initPayment(Table table) {
        tableService.checkIsPayed(table);
        List<Order> tableOrders = orderService.getOrdersByTable(table);
        OutputView.printOrders(tableOrders);
        OutputView.printPaymentProcessingMessage(table);
    }

    private int inputTable() {
        return TableController.inputTableNumber();
    }
}
