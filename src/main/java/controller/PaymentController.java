package controller;

import service.PaymentService;
import view.OutputView;

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
            paymentService.payTable(tableNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
    }

    private int inputTable() {
        return TableController.inputTableNumber();
    }
}
