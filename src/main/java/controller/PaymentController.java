package controller;

import domain.Table;
import service.PaymentService;
import util.InputValidator;
import view.InputView;
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
            Table table = paymentService.checkPayment(tableNumber);
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
