package util;

public class InputValidator {
    private static final String NEW_LINE = "\n";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String INVALID_INPUT_MESSAGE = "선택할 수 없는 기능입니다.";
    private static final String RETRY_MESSAGE = " 다시 시도해 주세요";
    private static final String MAIN_SCREEN_INPUT_FORMAT = "[123]";

    public static void validateModeInput(String input) {
        if (!input.matches(MAIN_SCREEN_INPUT_FORMAT)) {
            throw new IllegalArgumentException(NEW_LINE + ERROR_MESSAGE + INVALID_INPUT_MESSAGE + RETRY_MESSAGE);
        }
    }
}
