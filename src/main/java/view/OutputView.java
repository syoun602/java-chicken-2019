package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String NOT_PAYED_BOTTOM_LINE = "└ ₩ ┘";
    private static final String NEW_LINE = "\n";
    private static final String HEADLINE = "## ";
    private static final String MAIN_PROMPT = "## 메인화면\n" + "1 - 주문등록\n" + "2 - 결제하기\n" + "3 - 프로그램 종료\n";
    private static final String PROCESSING_PAYMENT_MESSAGE = "번 테이블의 결제를 진행합니다.\n";
    private static final String AMOUNT_TO_PAY = "## 최종 결제할 금액\n";

    public static void printMainScreen() {
        System.out.println(NEW_LINE + MAIN_PROMPT);
    }

    public static void printTables(final List<Table> tables) {
        System.out.println(NEW_LINE + "## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLine(final List<Table> tables) {
        for (final Table table : tables) {
            if (!table.getIsPayed()) {
                System.out.print(NOT_PAYED_BOTTOM_LINE);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printPaymentProcessingMessage(int tableNumber) {
        System.out.println(HEADLINE + tableNumber + PROCESSING_PAYMENT_MESSAGE);
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(NEW_LINE + e.getMessage());
    }

    public static void printPayment(int totalPayment) {
        System.out.println(AMOUNT_TO_PAY + totalPayment);
    }
}
