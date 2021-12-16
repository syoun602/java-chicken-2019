package controller;

import domain.Table;
import service.OrderService;
import util.InputValidator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OrderController {
    private static OrderController instance;
    private static OrderService orderService;

    public static OrderController getInstance() {
        if (instance == null) {
            instance = new OrderController();
            orderService = new OrderService();
        }
        return instance;
    }

    public void run() {
        int tableNumber = inputTable();
        //inputMenus();
    }

    private int inputTable() {
        String input;
        List<Table> tables = orderService.getTables();
        while (true) {
            try {
                OutputView.printTables(tables);
                input = InputView.inputTableNumber();
                InputValidator.validateTableNumber(tables, input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
