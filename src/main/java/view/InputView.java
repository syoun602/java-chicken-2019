package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SELECT_MODE = "## 원하는 기능을 선택하세요.";

    public static String inputSelectMode() {
        System.out.println(SELECT_MODE);
        return scanner.nextLine();
    }
    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }
}
