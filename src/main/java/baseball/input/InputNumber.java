package baseball.input;

import camp.nextstep.edu.missionutils.Console;
import baseball.input.error.InputError;
import baseball.input.error.InputErrorController;

import java.util.stream.Stream;

public class InputNumber {

    private final static int MAX_NUMBER_SIZE = 3;
    private final static String  RESTART = "1";
    private final static String  EXIT = "2";

    public String validEnteredNumber(){
        String enteredNumber = EnteredNumber();
        isInputValid(enteredNumber);
        return enteredNumber;
    }

    private String EnteredNumber(){ return Console.readLine(); }

    private void isInputValid(String inputNumber){
        if(inputNumber.length()!= MAX_NUMBER_SIZE){
            throw new InputErrorController(inputNumber, InputError.NEED_THREE_DIGIT);
        }
        if(!inputNumber.matches("[1-9]+")){
            throw new InputErrorController(inputNumber, InputError.MUST_BE_DIGIT);
        }
        if(inputNumber.length() != Stream.of(inputNumber.split("")).distinct().count()){
            throw new InputErrorController(inputNumber, InputError.NEED_NON_DUPLICATE_NUMBERS);
        }
    }

    public boolean reStart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputNumber = EnteredNumber();
        if(inputNumber.equals(RESTART)){
            return true;
        }else if(inputNumber.equals(EXIT)){
            return false;
        }else{
            throw new InputErrorController(inputNumber, InputError.NEED_INPUT_1_OR_2);
        }
    }
}
