package com.example.Cafeteria.Services;

import com.example.Cafeteria.Dto.CreateMenuItemRequestDto;
import com.example.Cafeteria.Exceptions.ResourceNotFoundExceptions;
import com.example.Cafeteria.Repositories.MenuItemRepository;
import com.example.Cafeteria.Schema.MenuItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemService {
    private final MenuItemRepository menuItemRepository;

    public MenuItem createMenuItem(CreateMenuItemRequestDto requestDto) {
        MenuItem menuItem = MenuItem.builder().name(requestDto.getName()).price(requestDto.getPrice()).description(requestDto.getDescription())
                .category(requestDto.getCategory()).vegetarian(requestDto.isVegetarian()).build();
        return menuItemRepository.save(menuItem);
    }

    public List<MenuItem> getAllMenuItems() {
        List<MenuItem> menuItems = menuItemRepository.findAll();
        if(menuItems.isEmpty()){
            throw new ResourceNotFoundExceptions("Menu Items not found");
        }
        return menuItems;
    }

    public MenuItem getMenuItemById(Long id) {
        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Product with id" + id + "Not Found"));
        return menuItem;
    }

    public MenuItem updateMenuItem(Long id, CreateMenuItemRequestDto requestDto) {
        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Product with id " + id + "Not found"));
        menuItem.setName(requestDto.getName());
        menuItem.setDescription(requestDto.getDescription());
        menuItem.setPrice(requestDto.getPrice());
        menuItem.setVegetarian(requestDto.isVegetarian());
        menuItem.setCategory(requestDto.getCategory());
        return menuItemRepository.save(menuItem);
    }

    public void deleteMenuItemById(Long id) {
        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Product with id " + id + "Not found"));
        menuItemRepository.deleteById(id);
    }
}
