package christmas.utils.validator;

import static christmas.utils.constants.ErrorMessage.NOT_INTEGER;

import christmas.utils.exception.InputException;

public class InputValidator {

    private InputValidator(){
    }

    public static void checkIsNumber(String input){
        try{
            Integer.parseInt(input);
        } catch(NumberFormatException e){
            throw InputException.of(NOT_INTEGER);
        }
    }

}
