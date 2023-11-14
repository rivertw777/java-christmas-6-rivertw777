package christmas.eventplanner.dto;

import christmas.eventplanner.Menu;
import christmas.eventplanner.Menus;
import java.util.List;
import java.util.stream.Collectors;

public record OrderedMenusDto(Menus menus) {
    public List<String> getResponses(){
        return menus.getMenus().stream()
                .map(this::getResponse)
                .collect(Collectors.toList());
    }

    private String getResponse(Menu menu){
        return String.format("%s %d", menu.getName(), menu.getQuantity());
    }
}