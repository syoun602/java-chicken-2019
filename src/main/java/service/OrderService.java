package service;

import domain.*;

import java.util.List;

public class OrderService {
    private static final int MAX_MENU_SIZE = 99;
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String INVALID_QUANTITY_MESSAGE = "한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개 이하입니다.";

    public List<Table> getTables() {
        return TableRepository.tables();
    }

    public List<Menu> getMenus() {
        return MenuRepository.menus();
    }

    public void saveOrder(int tableNumber, int menuNumber, int quantity) {
        checkQuantity(quantity);
        Table table = TableRepository.findByNumber(tableNumber);
        Menu menu = MenuRepository.findByNumber(menuNumber);
        OrderRepository.saveOrder(table, menu, quantity);
        TableRepository.updateIsPayed(table);
        System.out.println("상태 : " + tableNumber + " " + table.getIsPayed());
    }

    private void checkQuantity(int quantity) {
        if (quantity > MAX_MENU_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_QUANTITY_MESSAGE);
        }
    }
}
