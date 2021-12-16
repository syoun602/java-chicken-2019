package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static Table findByNumber(int tableNumber) {
        return tables.stream()
                .filter(table -> table.getNumber() == tableNumber)
                .findAny()
                .orElse(null);
    }

    public static void updateIsPayed(Table table) {
        if (table.getIsPayed()) {
            table.toggleIsPayed();
        }
    }

    public static boolean checkIsPayed(Table table) {
        return table.getIsPayed();
    }
}
