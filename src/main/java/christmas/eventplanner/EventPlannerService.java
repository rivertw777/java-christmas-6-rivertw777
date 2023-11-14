package christmas.eventplanner;

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

}
