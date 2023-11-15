package christmas.controller;

import christmas.eventplanner.EventBenefit;
import christmas.eventplanner.EventPlannerService;
import christmas.eventplanner.Menus;
import christmas.eventplanner.VisitDate;
import christmas.eventplanner.dto.BenefitDetailDto;
import christmas.eventplanner.dto.OrderedMenusDto;
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

        // 이벤트 혜택 계산 및 저장
        EventBenefit eventBenefit = calculateEventBenefit();
        service.saveEventBenefit(eventBenefit);

        // 이벤트 혜택 미리보기
        previewEventBenefit();
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

    private EventBenefit calculateEventBenefit(){
        return EventBenefit.create(service.findVisitDate(), service.findMenus());
    }

    private void previewEventBenefit() {
        printEventBenefitsPreviewMessage();
        printOrderedMenu();
        printTotalPriceBeforeDiscount();
        printGiftMenu();
        printBenefitDetail();
        printTotalBenefitPrice();
        printTotalPriceAfterDiscount();
        printDecemberEventBadge();
    }

    // 이벤트 프리뷰 메시지 출력
    private void printEventBenefitsPreviewMessage() {
        view.printEventBenefitsPreviewMessage(service.getVisitDate());
    }

    // 주문 메뉴 출력
    private void printOrderedMenu() {
        OrderedMenusDto orderedMenusDto = new OrderedMenusDto(service.findMenus());
        view.printOrderedMenu(orderedMenusDto.getResponses());
    }

    // 할인 전 총주문 금액 출력
    private void printTotalPriceBeforeDiscount() {
        view.printTotalPriceBeforeDiscount(service.getTotalPriceBeforeDiscount());
    }

    // 증정 메뉴 출력
    private void printGiftMenu() {
        view.printGiftMenu(service.isSatisfiedConditionWithGiftEvent());
    }

    // 혜택 내역 출력
    private void printBenefitDetail() {
        BenefitDetailDto benefitDetailDto = new BenefitDetailDto(service.findEventBenefit());
        view.printBenefitDetail(benefitDetailDto.getResponses());
    }

    // 총혜택 금액 출력
    private void printTotalBenefitPrice() {
        view.printTotalBenefitPrice(service.getTotalBenefitPrice());
    }

    // 할인 후 예상 결제 금액 출력
    private void printTotalPriceAfterDiscount() {
        view.printTotalPriceAfterDiscount(service.getTotalPriceAfterDiscount());
    }

    // 12월 이벤트 배지 출력
    private void printDecemberEventBadge() {
        view.printDecemberEventBadge(service.getTotalBenefitPrice());
    }

}
