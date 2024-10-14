package baseball.input.error;

public enum InputError{
    NEED_THREE_DIGIT("3자리 숫자가 필요합니다."),
    MUST_BE_DIGIT("1에서 9 사이의 숫자로만 이루어져야 합니다."),
    NEED_NON_DUPLICATE_NUMBERS("중복되는 숫자가 없어야 합니다."),
    NEED_INPUT_1_OR_2("1 혹은 2를 입력해야 합니다.");

    final String message;

    InputError(String message){ this.message = message;}


}


