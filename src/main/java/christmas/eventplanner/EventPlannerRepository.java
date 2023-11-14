package christmas.eventplanner;

public class EventPlannerRepository {
    private VisitDate visitDate;
    private Menus menus;

    public void saveVisitDate(final VisitDate visitDate) {
        this.visitDate = visitDate;
    }

    public VisitDate findVisitDate(){
        return visitDate;
    }

    public void saveMenus(final Menus menus) {
        this.menus = menus;
    }

    public Menus findMenus(){
        return menus;
    }
}
