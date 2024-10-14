package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerGenerateNumber {
    private final static int MAX_NUMBER_SIZE = 3;
    private final static int MIN_RANGE_NUM = 1;
    private final static int MAX_RANGE_NUM = 9;


    public static List<Integer> computerGenerateNumber(){
        List<Integer> answer = new ArrayList<>();
        while(answer.size()< MAX_NUMBER_SIZE){
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE_NUM, MAX_RANGE_NUM);
            if(!answer.contains(randomNumber)){
                answer.add(randomNumber);
            }
        }
        return answer;
    }
}
