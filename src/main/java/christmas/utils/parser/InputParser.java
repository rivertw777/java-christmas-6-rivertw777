package christmas.utils.parser;

import static christmas.utils.constants.ErrorMessage.INVALID_DATE;
import static christmas.utils.constants.ErrorMessage.INVALID_ORDER;
import static christmas.utils.validator.InputValidator.checkIsNumber;
import static christmas.utils.validator.InputValidator.checkIsOverMinimumOrderCount;
import static christmas.utils.validator.InputValidator.checkIsValidMenuFormat;

import christmas.eventplanner.Menu;
import christmas.utils.exception.InputException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    // 메뉴 리스트 변환
    public static List<Menu> toMenus(String input) {
        checkIsValidMenuFormat(input);
        return Arrays.stream(input.split(","))
                .map(InputParser::parseMenuInfo)
                .map(InputParser::createMenu)
                .collect(Collectors.toList());
    }

    // 메뉴 클래스 생성
    public static Menu createMenu(String[] menuInfo) {
        String name = menuInfo[0];

        try {
            checkIsNumber(menuInfo[1]);
        } catch (InputException e) {
            throw InputException.of(INVALID_ORDER);
        }

        int count = Integer.parseInt(menuInfo[1]);
        checkIsOverMinimumOrderCount(count);
        return Menu.create(name, count);
    }

    public static String[] parseMenuInfo(String menuString) {
        return menuString.split("-");
    }

}
