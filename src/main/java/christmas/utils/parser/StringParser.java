package christmas.utils.parser;

import static christmas.utils.validator.InputValidator.checkIsNumber;

public class StringParser {
    private StringParser(){}

    public static int toInteger(String input){
        checkIsNumber(input);
        return Integer.parseInt(input);
    }

}
