package christmas.utils.validator;

import static christmas.utils.constants.ErrorMessage.INVALID_MENU_FORMAT;
import static christmas.utils.constants.ErrorMessage.INVALID_ORDER;
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

    public static void checkIsOverMinimumOrderCount(int count){
        if(count<1){
            throw InputException.of(INVALID_ORDER);
        }
    }

    public static void checkIsValidMenuFormat(String input){
        if(!input.contains("-")){
            throw InputException.of(INVALID_MENU_FORMAT);
        }
    }

}
