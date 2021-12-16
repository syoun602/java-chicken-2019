package service;

import domain.Table;
import domain.TableRepository;

public class PaymentService {
    private static final String NO_REMAINING_ORDER = "주문내역이 존재하지 않습니다.";
    private static PaymentService instance;

    public static PaymentService getInstance() {
        if (instance == null) {
            instance = new PaymentService();
        }
        return instance;
    }

    public void payTable(int tableNumber) {
        Table table = TableRepository.findByNumber(tableNumber);
        checkIsPayed(table);

    }

    private void checkIsPayed(Table table) {
        if (TableRepository.checkIsPayed(table)) {
            throw new IllegalArgumentException(NO_REMAINING_ORDER);
        }
    }
}
