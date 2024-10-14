package baseball.input.error;


public class InputErrorController extends IllegalArgumentException{

    public InputErrorController(String inputValue, InputError inputError){
        super(inputValue+ inputError.message);
    }
}
