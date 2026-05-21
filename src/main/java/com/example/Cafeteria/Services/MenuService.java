package com.example.Cafeteria.Services;

import com.example.Cafeteria.Dto.CreateMenuRequestDto;
import com.example.Cafeteria.Repositories.MenuItemRepository;
import com.example.Cafeteria.Repositories.MenusRepository;
import com.example.Cafeteria.Repositories.RestaurantRepository;
import com.example.Cafeteria.Schema.MenuItem;
import com.example.Cafeteria.Schema.Menus;
import com.example.Cafeteria.Schema.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenusRepository menusRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;
    public Menus createMenus(CreateMenuRequestDto requestDto){
        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant Id not Found"));
        if(menusRepository.existsByRestaurantIdAndDateAndMealType(requestDto.getRestaurantId(), requestDto.getDate(), requestDto.getMealType())){
            throw new RuntimeException("Menu already exists for this restaurant, date and meal type");
        }
        List<MenuItem> menuItems = menuItemRepository.findAllById(requestDto.getMenuItemIds());
        if(menuItems.size() != requestDto.getMenuItemIds().size()){
            throw new RuntimeException("Some menu Items Not Found");
        }
        Menus menus = Menus.builder().restaurant(restaurant).date(requestDto.getDate()).mealType(requestDto.getMealType())
                .menuItems(menuItems).build();
        return menusRepository.save(menus);
    }

    public List<Menus> getAllMenus(){
        return menusRepository.findAllMenusWithRelations();
    }

    public Menus getMenusById(Long id){
        return menusRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Menu With Id Not found"));
    }

    public List<Menus> getMenuByRestaurantId(Long id){
        return menusRepository.findByRestaurantId(id);
    }

    public Menus updateMenuById(Long id,CreateMenuRequestDto requestDto){
        Menus menus = menusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu with ID not found to update"));

        Restaurant restaurant = restaurantRepository
                .findById(requestDto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        List<MenuItem> menuItems =
                menuItemRepository.findAllById(requestDto.getMenuItemIds());

        if(menuItems.size() != requestDto.getMenuItemIds().size()){
            throw new RuntimeException("Some menu items not found");
        }

        menus.setRestaurant(restaurant);
        menus.setDate(requestDto.getDate());
        menus.setMealType(requestDto.getMealType());
        menus.setMenuItems(menuItems);

        return menusRepository.save(menus);
    }

    public void deleteMenusById(Long id){
        menusRepository.deleteById(id);
    }

    public List<Menus> getMenusByDate(LocalDate MenuDate){
        return menusRepository.findAllByDateWithRelations(MenuDate);
    }

    public List<Menus>getMenusByRestaurantAndDate(Long restaurantId,LocalDate date){
        return menusRepository.findAllByRestaurantAndDateWithRelations(restaurantId,date);
    }
}
