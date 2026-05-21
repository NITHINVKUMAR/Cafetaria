package com.example.Cafeteria.Contollers;

import com.example.Cafeteria.Dto.CreateMenuItemRequestDto;
import com.example.Cafeteria.Schema.MenuItem;
import com.example.Cafeteria.Services.MenuItemService;
import com.example.Cafeteria.Utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Vector;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menu-items")
public class MenuItemController {
    private final MenuItemService menuItemService;
    @PostMapping
    public ResponseEntity<ApiResponse<MenuItem>> createMenuItem(@RequestBody CreateMenuItemRequestDto requestDto){
        MenuItem menuItem = menuItemService.createMenuItem(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(menuItem,"MenuItem Created Successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<MenuItem>>> getAllMenuItems(){
        List<MenuItem> menuItems = menuItemService.getAllMenuItems();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(menuItems,"Menu Items fetched successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<MenuItem>> getMenuItemById(@PathVariable Long id){
        MenuItem menuItems = menuItemService.getMenuItemById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(menuItems,"Menu Item fecthed successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<MenuItem>> updateMenuItem(@PathVariable Long id, @RequestBody CreateMenuItemRequestDto requestDto){
        MenuItem menuItem = menuItemService.updateMenuItem(id,requestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(menuItem,"Menu Item fecthed successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteMenuItemById(@PathVariable Long id){
        menuItemService.deleteMenuItemById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(null,"MenuItem Deleted Successfully"));
    }
}
