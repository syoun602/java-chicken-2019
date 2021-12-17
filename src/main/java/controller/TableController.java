package controller;

import domain.Table;
import repository.TableRepository;
import util.InputValidator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class TableController {
    public static int inputTableNumber() {
        String input;
        List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        while (true) {
            try {
                input = InputView.inputTableNumber();
                InputValidator.validateTableNumber(tables, input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
