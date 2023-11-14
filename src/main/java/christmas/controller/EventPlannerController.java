package christmas.controller;

import christmas.eventplanner.EventPlanner;
import christmas.eventplanner.EventPlannerService;
import christmas.eventplanner.Menu;
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
        view.printHelloMessage();
        VisitDate visitDate = bookVisitDate();
        Menus menus = orderMenu();
        for (Menu menu : menus.getMenus()) {
            System.out.println("메뉴명: " + menu.getName() + ", 수량: " + menu.getQuantity());
        }
        System.out.println(menus.getTotalPrice());
        EventPlanner eventPlanner = EventPlanner.create(visitDate, menus);

    }

    private VisitDate bookVisitDate(){
        try {
            int date = InputParser.toInteger(view.inputVisitDate());
            return VisitDate.create(date);
        } catch (InputException | EventPlannerException e){
            view.printErrorMessage(e.getMessage());
            bookVisitDate();
        }
        return null;
    }

    private Menus orderMenu() {
        try {
            Map<String, Integer> OrderedMenuInput = InputParser.toMenus(view.inputOrderMenu());
            return Menus.create(OrderedMenuInput);
        } catch (InputException | EventPlannerException e) {
            view.printErrorMessage(e.getMessage());
            orderMenu();
        }
        return null;
    }

}
