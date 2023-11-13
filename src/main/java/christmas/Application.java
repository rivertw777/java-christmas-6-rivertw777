package christmas;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.EventPlannerController;
import christmas.eventplanner.EventPlannerService;
import christmas.view.EventPlannerView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        EventPlannerService service = new EventPlannerService();
        EventPlannerView view = new EventPlannerView();
        EventPlannerController controller = new EventPlannerController(service, view);
        controller.run();
        Console.close();
    }
}
