package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SELECT_MODE = "## 원하는 기능을 선택하세요.";
    private static final String NEW_LINE = "\n";
    private static final String SELECT_PAY_MODE = "## 신용 카드는 1번, 현금은 2번";

    public static String inputSelectMode() {
        System.out.println(SELECT_MODE);
        return scanner.nextLine();
    }
    public static String inputTableNumber() {
        System.out.println(NEW_LINE + "## 주문할 테이블을 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputMenuNumber() {
        System.out.println(NEW_LINE + "## 등록할 메뉴를 선택하세요.");
        return scanner.nextLine();
    }

    public static String inputQuantity() {
        System.out.println(NEW_LINE + "## 메뉴의 수량을 입력하세요.");
        return scanner.nextLine();
    }

    public static String inputPayMode() {
        System.out.println(SELECT_PAY_MODE);
        return scanner.nextLine();
    }
}
