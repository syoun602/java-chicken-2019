package controller;

import domain.Menu;
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
            orderService = OrderService.getInstance();
        }
        return instance;
    }

    public void run() {
        int tableNumber = inputTable();
        int menuNumber = inputMenus();
        int quantity = inputQuantity();
        saveMenuToTable(tableNumber, menuNumber, quantity);
    }

    private int inputTable() {
        return TableController.inputTableNumber();
    }

    private int inputMenus() {
        String input;
        List<Menu> menus = orderService.getMenus();
        OutputView.printMenus(menus);
        while (true) {
            try {
                input = InputView.inputMenuNumber();
                InputValidator.validateMenuNumber(menus, input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private int inputQuantity() {
        String input;
        while (true) {
            try {
                input = InputView.inputQuantity();
                InputValidator.validateQuantity(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void saveMenuToTable(int tableNumber, int menuNumber, int quantity) {
        try {
            orderService.saveOrder(tableNumber, menuNumber, quantity);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
    }
}
