package controller;

import util.InputValidator;
import view.InputView;
import view.OutputView;

public class MachineController {
    private static final int ORDER_MODE = 1;
    private static final int PAYMENT_MODE = 2;
    private static final int EXIT_MODE = 3;

    private static MachineController instance;

    public static MachineController getInstance() {
        if (instance == null) {
            instance = new MachineController();
        }
        return instance;
    }

    public void run() {
        int input;
        do {
            OutputView.printMainScreen();
            input = mainScreenInput();
        } while (processInput(input));
    }

    private boolean processInput(int input) {
        if (input == ORDER_MODE) {
            OrderController.getInstance().run();
        }
        if (input == PAYMENT_MODE) {
            PaymentController.getInstance().run();
        }
        return !(input == EXIT_MODE);
    }

    private int mainScreenInput() {
        while (true) {
            try {
                String input = InputView.inputSelectMode();
                InputValidator.validateModeInput(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
