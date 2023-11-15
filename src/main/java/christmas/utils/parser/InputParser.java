package christmas.utils.parser;

import static christmas.utils.constants.ErrorMessage.INVALID_DATE;
import static christmas.utils.constants.ErrorMessage.INVALID_ORDER;
import static christmas.utils.validator.InputValidator.checkIsNumber;
import static christmas.utils.validator.InputValidator.checkIsOverMinimumOrderCount;
import static christmas.utils.validator.InputValidator.checkIsValidMenuFormat;

import christmas.utils.exception.InputException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InputParser {
    private InputParser(){}

    // 정수 변환
    public static int toInteger(String input){
        try {
            checkIsNumber(input);
        } catch( InputException e){
            throw InputException.of(INVALID_DATE);
        }
        return Integer.parseInt(input);
    }

    // 문자열을 ","로 분리 후 Map에 메뉴 정보 삽입
    public static Map<String, Integer> toMenus(String input) {
        checkIsValidMenuFormat(input);
        return Arrays.stream(input.split(","))
                .map(InputParser::parseMenuInfo)
                .collect(HashMap::new, InputParser::addToMap, HashMap::putAll);
    }

    // 문자열을 "-" 으로 분리
    public static String[] parseMenuInfo(String menuString) {
        return menuString.split("-");
    }

    // Map에 메뉴의 이름과 개수 삽입
    public static void addToMap(Map<String, Integer> map, String[] menuInfo) {
        String name = menuInfo[0];

        try {
            checkIsNumber(menuInfo[1]);
        } catch( InputException e ){
            throw InputException.of(INVALID_ORDER);
        }

        int count = Integer.parseInt(menuInfo[1]);
        checkIsOverMinimumOrderCount(count);
        map.put(name, count);
    }

}
