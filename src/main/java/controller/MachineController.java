package controller;

import util.InputValidator;
import view.InputView;
import view.OutputView;

public class MachineController {
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
        if (input == 1) {
            return true;
        }
        if (input == 2) {
            return true;
        }
        return !(input == 3);
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
