package service;

import domain.Table;
import repository.TableRepository;

public class TableService {
    private static final String NO_REMAINING_ORDER = "주문내역이 존재하지 않습니다.";

    public static TableService instance;

    public static TableService getInstance() {
        if (instance == null) {
            instance = new TableService();
        }
        return instance;
    }

    public Table getTable(int tableNumber) {
        return TableRepository.findByNumber(tableNumber);
    }

    public void checkIsPayed(Table table) {
        if (TableRepository.isPayed(table)) {
            throw new IllegalArgumentException(NO_REMAINING_ORDER);
        }
    }
}
