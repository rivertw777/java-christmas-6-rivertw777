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

    public void saveEventBenefit(final EventBenefit eventBenefit) {
        eventPlannerRepository.saveEventBenefit(eventBenefit);
    }

    public EventBenefit findEventBenefit(){
        return eventPlannerRepository.findEventBenefit();
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
    public boolean isSatisfiedConditionWithGiftEvent() {
        return findEventBenefit().isSatisfiedConditionWithGiftEvent();
    }

    // 총 혜택 금액 반환
    public int getTotalBenefitPrice(){
        EventBenefit eventBenefit = findEventBenefit();
        return eventBenefit.getRemainingDayDiscountPrice() + eventBenefit.getVisitDateDiscountPrice()+
                eventBenefit.getSpecialDayDiscountPrice() + eventBenefit.getGiftEventBenefitPrice();

    }

    // 할인 후 예상 결제 금액 반환
    public int getTotalPriceAfterDiscount(){
        return getTotalPriceBeforeDiscount() - getTotalBenefitPrice() + findEventBenefit().getGiftEventBenefitPrice();
    }

}
