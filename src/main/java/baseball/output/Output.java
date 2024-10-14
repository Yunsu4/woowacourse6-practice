package baseball.output;


public class Output {
    private final static String BALL = "볼";
    private final static String STRIKE = "스트라이크";
    private final static int MAX_NUMBER_SIZE = 3;


    public static void printBallandStrike(int ball, int strike) {
        printBall(ball);
        System.out.print(" ");
        printStrike(strike);
    }

    private static void printBall(int ball) {
        if (ball > 0)
            System.out.print(ball + BALL);
    }

    public static void printStrike(int strike) {
        if (strike > 0)
            System.out.println(strike + STRIKE);
    }


    public static void printSuccess(int strike) {
        if (strike == MAX_NUMBER_SIZE) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

}
