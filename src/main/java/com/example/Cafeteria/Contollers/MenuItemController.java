package com.example.Cafeteria.Contollers;

import com.example.Cafeteria.Dto.CreateMenuItemRequestDto;
import com.example.Cafeteria.Schema.MenuItem;
import com.example.Cafeteria.Services.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menu-items")
public class MenuItemController {
    private final MenuItemService menuItemService;
    @PostMapping
    public MenuItem createMenuItem(@RequestBody CreateMenuItemRequestDto requestDto){
        return menuItemService.createMenuItem(requestDto);
    }

    @GetMapping
    public List<MenuItem>getAllMenuItems(){
        return menuItemService.getAllMenuItems();
    }

    @GetMapping("/{id}")
    public MenuItem getMenuItemById(@PathVariable Long id){
        return menuItemService.getMenuItemById(id);
    }

    @PutMapping("/{id}")
    public MenuItem updateMenuItem(@PathVariable Long id,@RequestBody CreateMenuItemRequestDto requestDto){
        return menuItemService.updateMenuItem(id,requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMenuItemById(@PathVariable Long id){
        menuItemService.deleteMenuItemById(id);
    }
}
