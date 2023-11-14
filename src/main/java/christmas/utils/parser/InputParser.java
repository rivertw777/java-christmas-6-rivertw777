package christmas.utils.parser;

import static christmas.utils.validator.InputValidator.checkIsNumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InputParser {
    private InputParser(){}

    public static int toInteger(String input){
        checkIsNumber(input);
        return Integer.parseInt(input);
    }

    public static Map<String, Integer> toMenus(String input) {
        return Arrays.stream(input.split(","))
                .map(InputParser::parseMenuInfo)
                .collect(HashMap::new, InputParser::addToMap, HashMap::putAll);
    }

    public static String[] parseMenuInfo(String menuString) {
        return menuString.split("-");
    }

    public static void addToMap(Map<String, Integer> map, String[] menuInfo) {
        String name = menuInfo[0];
        int count = Integer.parseInt(menuInfo[1]);
        map.put(name, count);
    }

}
