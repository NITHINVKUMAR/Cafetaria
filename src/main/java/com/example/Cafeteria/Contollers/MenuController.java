package com.example.Cafeteria.Contollers;

import com.example.Cafeteria.Dto.CreateMenuRequestDto;
import com.example.Cafeteria.Schema.Menus;
import com.example.Cafeteria.Services.MenuService;
import com.example.Cafeteria.Utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/menus")
public class MenuController {
    private final MenuService menuService;

    @PostMapping
    public ResponseEntity<ApiResponse<Menus>> createMenu(@RequestBody CreateMenuRequestDto requestDto){
        Menus menus = menuService.createMenus(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(menus,"Menu Created Successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Menus>>> getAllMenus(){
        List<Menus> menus = menuService.getAllMenus();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(menus,"All Menus Fetched Successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Menus>> getMenusById(@PathVariable Long id){
        Menus menu = menuService.getMenusById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(menu,"Menu Fetched successfully"));
    }


    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<ApiResponse<List<Menus>>> getMenuByRestaurantId(@PathVariable Long restaurantId){
        List<Menus> menus = menuService.getMenuByRestaurantId(restaurantId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(menus,"Menus Fetched Successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Menus>> updateMenuById(@PathVariable Long id,@RequestBody CreateMenuRequestDto requestDto){
        Menus menu = menuService.updateMenuById(id,requestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(menu,"Menu Updated Successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteMenusById(@PathVariable Long id){
        menuService.deleteMenusById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(null,"Menu Deleted Successfully"));
    }

    @GetMapping("date/{date}")
    public ResponseEntity<ApiResponse<List<Menus>>> getMenusByDate(@PathVariable LocalDate date){
        List<Menus> menus = menuService.getMenusByDate(date);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(menus,"Menus Fetched Successfully"));
    }

    @GetMapping("/restaurant/{restaurantId}/date/{date}")
    public ResponseEntity<ApiResponse<List<Menus>>> getMenusByRestaurantAndDate(@PathVariable Long restaurantId,@PathVariable LocalDate date){
        List<Menus> menus = menuService.getMenusByRestaurantAndDate(restaurantId,date);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(menus,"Menus Fetched Successfully"));
    }
}