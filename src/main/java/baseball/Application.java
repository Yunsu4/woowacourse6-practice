package baseball;

import baseball.Game.Game;
import baseball.input.InputNumber;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputNumber inputNumber = new InputNumber();
        Game game = new Game(inputNumber);

        game.startGame();
    }
}

/*
public class Application {
    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 9;
    private final static int MAX_NUMBER_SIZE = 3;
    private final static String RESTART = "1";
    private final static String EXIT = "2";
    private final static String ERROR_MESSAGE = "잘못된 입력입니다.";


    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        do{
            List<Integer> answer = computerGenerateNumber();
            playGame(answer);
        } while(reStart());
    }

    private static List<Integer> computerGenerateNumber(){
        List<Integer> answer = new ArrayList<>();
        while(answer.size() < MAX_NUMBER_SIZE){
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            if(!answer.contains(randomNumber)){
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public static void playGame(List<Integer> answer){
        String inputNumber;
        do{
            System.out.println("숫자를 입력해주세요: ");
            inputNumber = Console.readLine();
            isInputValid(inputNumber);
        }while(!compareNumber(answer, inputNumber));
    }

    private static void isInputValid(String inputNumber){
        stringLengthAvailable(inputNumber);
        stringIsDigit(inputNumber);
    }

    private static boolean compareNumber(List<Integer> answer, String inputNumber){
        int[] inputNumberArray = returnInputNumberToArray(inputNumber);
        int strike = Strike(answer, inputNumberArray);
        int ball = Ball(answer, inputNumberArray);
        gameResult(strike, ball, answer);
        return strike == MAX_NUMBER_SIZE;
    }

    private static int[] returnInputNumberToArray(String inputNumber){
        int[] inputNumberArray = new int[inputNumber.length()];
        for(int i = 0; i<inputNumber.length(); i++){
            inputNumberArray[i] = inputNumber.charAt(i) -'0';
        }
        return inputNumberArray;
    }



    public static void stringLengthAvailable(String inputNumber){
        if (inputNumber.length() != MAX_NUMBER_SIZE){
            throw new IllegalArgumentException();
        }
    }

    public static void stringIsDigit(String inputNumber){
        for(int i=0; i<inputNumber.length();i++){
            if(inputNumber.charAt(i)<'0' || inputNumber.charAt(i)>'9'){
                throw new IllegalArgumentException();
            }
        }
    }

    private static int Strike(List<Integer> answer, int[] inputNumberArray){
        int strike = 0;
        for(int i=0; i< MAX_NUMBER_SIZE;i++){
            if(inputNumberArray[i]==answer.get(i)){
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

    private static void gameResult(int strike, int ball, List<Integer> answer){
        if(ball == 0 && strike ==0){
            System.out.println("낫싱");
        } else if (strike == MAX_NUMBER_SIZE){
            printStrike(strike);
            System.out.println();
            printSuccess(strike);
        } else{
            printBall(ball);
            System.out.print(" ");
            printStrike(strike);
            System.out.println();
        }
    }

    private static void printBall(int ball){
        if(ball>0)
            System.out.print(ball+"볼");
    }

    private static void printStrike(int strike){
        if(strike>0)
            System.out.print(strike+"스트라이크");
    }

    private static void printSuccess(int strike){
        if(strike == MAX_NUMBER_SIZE){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private static boolean reStart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        if(inputString.equals(RESTART)){
            return true;
        }else if(inputString.equals(EXIT)){
            return false;
        }else{
            throw new IllegalArgumentException("[reStart()]:"+ERROR_MESSAGE);
        }
    }

}
*/