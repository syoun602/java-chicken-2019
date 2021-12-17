package service;

import domain.*;
import repository.MenuRepository;
import repository.OrderRepository;
import repository.TableRepository;

import java.util.List;

public class OrderService {
    private static final int MAX_MENU_SIZE = 99;
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String INVALID_QUANTITY_MESSAGE = "한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개 이하입니다.";

    private static OrderService instance;

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public List<Menu> getMenus() {
        return MenuRepository.menus();
    }

    public void saveOrder(int tableNumber, int menuNumber, int quantity) {
        Table table = TableRepository.findByNumber(tableNumber);
        Menu menu = MenuRepository.findByNumber(menuNumber);
        Order order = OrderRepository.findByTableAndMenu(table, menu);
        checkQuantity(table, menu, quantity);
        if (order != null) {
            OrderRepository.updateOrder(order, quantity);
            return;
        }
        OrderRepository.saveOrder(table, menu, quantity);
        TableRepository.orderRegistered(table);
    }

    private void checkQuantity(Table table, Menu menu, int quantity) {
        int quantityByTableAndMenu = OrderRepository.findQuantityByTableAndMenu(table, menu);
        if (quantity + quantityByTableAndMenu > MAX_MENU_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_QUANTITY_MESSAGE);
        }
    }
}
