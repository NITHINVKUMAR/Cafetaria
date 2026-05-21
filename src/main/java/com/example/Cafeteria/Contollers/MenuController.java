package com.example.Cafeteria.Contollers;

import com.example.Cafeteria.Dto.CreateMenuRequestDto;
import com.example.Cafeteria.Schema.Menus;
import com.example.Cafeteria.Services.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menus")
public class MenuController {
    private final MenuService menuService;

    @PostMapping
    public Menus createMenu(@RequestBody CreateMenuRequestDto requestDto){
        return menuService.createMenus(requestDto);
    }

    @GetMapping
    public List<Menus> getAllMenus(){
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public Menus getMenusById(@PathVariable Long id){
        return menuService.getMenusById(id);
    }


    @GetMapping("/restaurant/{restaurantId}")
    public List<Menus> getMenuByRestaurantId(@PathVariable Long restaurantId){
        return menuService.getMenuByRestaurantId(restaurantId);
    }

    @PutMapping("/{id}")
    public Menus updateMenuById(@PathVariable Long id,@RequestBody CreateMenuRequestDto requestDto){
        return menuService.updateMenuById(id,requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMenusById(Long id){
        menuService.deleteMenusById(id);
    }

    @GetMapping("date/{date}")
    public List<Menus> getMenusByDate(@PathVariable LocalDate date){
        return menuService.getMenusByDate(date);
    }

    @GetMapping("/restaurant/{restaurantId}/date/{date}")
    public List<Menus> getMenusByRestaurantAndDate(@PathVariable Long restaurantId,@PathVariable LocalDate date){
        return menuService.getMenusByRestaurantAndDate(restaurantId,date);
    }
}
