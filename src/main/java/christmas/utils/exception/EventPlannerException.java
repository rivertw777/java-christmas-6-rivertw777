package christmas.utils.exception;

import static christmas.utils.constants.ErrorMessage.ERROR_PREFIX;

import christmas.utils.constants.ErrorMessage;

public class EventPlannerException extends IllegalArgumentException {
    private EventPlannerException(String message){
        super(ERROR_PREFIX.getMessage()+message);
    }

    public static EventPlannerException of(ErrorMessage errorConstant){
        return new EventPlannerException(errorConstant.getMessage());
    }

}