package christmas.eventplanner;

public class EventPlanner {
    private final VisitDate visitDate;
    private final Menus menus;

    private EventPlanner(VisitDate visitDate, Menus menus){
        this.visitDate = visitDate;
        this.menus = menus;
    }

    public static EventPlanner create(VisitDate visitDate, Menus menus) {

        return new EventPlanner(visitDate, menus);
    }

}
