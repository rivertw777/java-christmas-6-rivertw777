package christmas.controller;

import christmas.eventplanner.EventPlannerService;
import christmas.eventplanner.Menus;
import christmas.eventplanner.VisitDate;
import christmas.utils.exception.EventPlannerException;
import christmas.utils.exception.InputException;
import christmas.utils.parser.InputParser;
import christmas.view.EventPlannerView;
import java.util.Map;

public class EventPlannerController {
    private final EventPlannerService service;
    private final EventPlannerView view;

    public EventPlannerController(EventPlannerService service, EventPlannerView view) {
        this.service = service;
        this.view = view;
    }

    public void run(){
        // 인사 메시지 출력
        view.printHelloMessage();

        // 방문 날짜 입력 및 저장
        VisitDate visitDate = bookVisitDate();
        service.saveVisitDate(visitDate);

        // 주문 메뉴 입력 및 저장
        Menus menus = orderMenu();
        service.saveMenus(menus);

        // 이벤트 혜택 미리보기
        previewEventBenefits();
    }

    private VisitDate bookVisitDate(){
        try {
            int date = InputParser.toInteger(view.inputVisitDate());
            return VisitDate.create(date);
        } catch (InputException | EventPlannerException e){
            view.printErrorMessage(e.getMessage());
            return bookVisitDate();
        }
    }

    private Menus orderMenu() {
        try {
            Map<String, Integer> OrderedMenuInput = InputParser.toMenus(view.inputOrderMenu());
            return Menus.create(OrderedMenuInput);
        } catch (InputException | EventPlannerException e) {
            view.printErrorMessage(e.getMessage());
            return orderMenu();
        }
    }

    private void previewEventBenefits(){
        view.printEventBenefitsPreviewMessage();
        view.printOrderedMenu();
        view.printTotalPriceBeforeDiscount(service.getTotalPriceBeforeDiscount());
    }

}
