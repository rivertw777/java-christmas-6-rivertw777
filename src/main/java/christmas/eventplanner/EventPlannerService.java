package christmas.eventplanner;

import static christmas.eventplanner.constants.EventPlannerConstraint.TARGET_PRICE_FOR_GIFT;

public class EventPlannerService {
    private final EventPlannerRepository eventPlannerRepository;

    public EventPlannerService(EventPlannerRepository eventPlannerRepository){
        this.eventPlannerRepository = eventPlannerRepository;
    }

    public void saveVisitDate(final VisitDate visitDate) {
        eventPlannerRepository.saveVisitDate(visitDate);
    }

    public VisitDate findVisitDate(){
        return eventPlannerRepository.findVisitDate();
    }

    public void saveMenus(final Menus menus) {
        eventPlannerRepository.saveMenus(menus);
    }

    public Menus findMenus(){
        return eventPlannerRepository.findMenus();
    }

    // 비즈니스 로직
    // 방문 날짜 반환
    public int getVisitDate() {
        return findVisitDate().getDate();
    }

    // 할인 전 총 금액 반환
    public int getTotalPriceBeforeDiscount(){
        return findMenus().getTotalPrice();
    }

    // 증정 이벤트를 만족하는지 반환
    public boolean isTotalPriceSatisfied() {
        return findMenus().getTotalPrice() >= TARGET_PRICE_FOR_GIFT.getValue();
    }


}
