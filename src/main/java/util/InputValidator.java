package util;

import domain.Menu;
import repository.MenuRepository;
import domain.Table;

import java.util.List;

public class InputValidator {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String INVALID_INPUT_MESSAGE = "선택할 수 없는 기능입니다.";
    private static final String RETRY_MESSAGE = " 다시 시도해 주세요";
    private static final String MAIN_SCREEN_INPUT_FORMAT = "[123]";
    private static final String INVALID_TABLE_NUMBER = "존재하지 않는 테이블입니다.";
    private static final String INVALID_MENU_NUMBER = "존재하지 않는 메뉴입니다.";
    private static final String NOT_A_NUMBER_MESSAGE = "숫자만 입력해주세요.";
    private static final String PAY_MODE_FORMAT = "[12]";

    public static void validateModeInput(String input) {
        if (!input.matches(MAIN_SCREEN_INPUT_FORMAT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_MESSAGE + RETRY_MESSAGE);
        }
    }

    public static void validateTableNumber(List<Table> tables, String input) {
        isNumber(input);
        tables.stream()
                .filter(table -> table.toString().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE + INVALID_TABLE_NUMBER + RETRY_MESSAGE));
    }

    public static void validateMenuNumber(List<Menu> menus, String input) {
        isNumber(input);
        menus.stream()
                .map(MenuRepository::getNumber)
                .filter(menu -> menu == Integer.parseInt(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE + INVALID_MENU_NUMBER + RETRY_MESSAGE));
    }

    public static void validateQuantity(String input) {
        isNumber(input);
    }

    private static void isNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_A_NUMBER_MESSAGE + RETRY_MESSAGE);
        }
    }

    public static void validatePayModeInput(String input) {
        if (!input.matches(PAY_MODE_FORMAT)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INVALID_INPUT_MESSAGE);
        }
    }
}
