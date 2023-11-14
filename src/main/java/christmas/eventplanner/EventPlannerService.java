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

    public int getTotalPriceBeforeDiscount(){
        return findMenus().getTotalPrice();
    }

    public boolean isTotalPriceSatisfied() {
        return findMenus().getTotalPrice() >= TARGET_PRICE_FOR_GIFT.getValue();
    }

}
