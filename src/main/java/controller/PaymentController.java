package controller;

import domain.Order;
import domain.Table;
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

    public static PaymentController getInstance() {
        if (instance == null) {
            instance = new PaymentController();
            paymentService = PaymentService.getInstance();
            tableService = TableService.getInstance();
        }
        return instance;
    }

    public void run() {
        int tableNumber = inputTable();
        try {
            Table table = initPayment(tableNumber);
            String payMode = InputView.inputPayMode();
            InputValidator.validatePayModeInput(payMode);
            int totalPayment = paymentService.makePayment(table, payMode);
            OutputView.printPayment(totalPayment);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
    }

    private Table initPayment(int tableNumber) {
        Table table = tableService.getTable(tableNumber);
        tableService.checkIsPayed(table);
        List<Order> tableOrders = paymentService.getOrdersByTable(table);
        OutputView.printOrders(tableOrders);
        OutputView.printPaymentProcessingMessage(tableNumber);
        return table;
    }

    private int inputTable() {
        return TableController.inputTableNumber();
    }
}
