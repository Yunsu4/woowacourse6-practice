package baseball.Game;

import baseball.input.InputNumber;

import java.util.List;

import static baseball.computer.ComputerGenerateNumber.computerGenerateNumber;
import static baseball.output.Output.*;

public class Game {

    private final static String  START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static int MAX_NUMBER_SIZE = 3;


    private final InputNumber inputNumber;

    public Game(InputNumber inputNumber){
        this.inputNumber = inputNumber;
    }




    public void startGame(){
        System.out.println(START_MESSAGE);
        do {
            List<Integer> answer = computerGenerateNumber();
            playGame(answer);
        }while(inputNumber.reStart());

    }

    private void playGame(List<Integer> answer) {
        String inputNumbers;
        do {
            System.out.println("숫자를 입력해주세요: ");
            inputNumbers = inputNumber.validEnteredNumber();
        } while (!compareNumber(answer, inputNumbers));
    }

    private static boolean compareNumber(List<Integer> answer, String inputNumbers){
        int[] inputNumberArray = returnInputNumberToArray(inputNumbers);
        int strike =  Strike(answer, inputNumberArray);
        int ball = Ball(answer, inputNumberArray);
        gameResult(strike, ball, answer);
        return strike == MAX_NUMBER_SIZE;

    }

    private static int[] returnInputNumberToArray(String inputNumbers) {
        int [] inputNumberArray = new int[inputNumbers.length()];
        for(int i=0;i<inputNumbers.length();i++){
            inputNumberArray[i] = inputNumbers.charAt(i)-'0';
        }
        return inputNumberArray;
    }

    private static void gameResult(int strike, int ball, List<Integer> answer) {
        if(ball == 0 && strike ==0){
            System.out.println("낫싱");
        }else if (strike == MAX_NUMBER_SIZE){
            printStrike(strike);
            printSuccess(strike);
        }else{
            printBallandStrike(ball,strike);
        }
    }



    private static int Strike(List<Integer> answer, int[] inputNumberArray){
        int strike = 0;
        for(int i=0;i<MAX_NUMBER_SIZE;i++){
            if(answer.get(i) == inputNumberArray[i]){
                strike++;
            }
        }
        return strike;
    }

    private static int Ball(List<Integer> answer, int[] inputNumberArray){
        int ball = 0;
        for(int i=0;i<MAX_NUMBER_SIZE;i++){
            if(answer.contains(inputNumberArray[i]) && !answer.get(i).equals(inputNumberArray[i])){
                ball++;
            }
        }
        return ball;
    }


}
