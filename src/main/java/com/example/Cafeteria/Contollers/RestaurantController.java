package com.example.Cafeteria.Contollers;

import com.example.Cafeteria.Dto.CreateRestaurantRequestDto;
import com.example.Cafeteria.Schema.Restaurant;
import com.example.Cafeteria.Services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public Restaurant createRestaurant(@RequestBody CreateRestaurantRequestDto requestDto){
        return restaurantService.createRestaurant(requestDto);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getProductById(@PathVariable Long id){
        return restaurantService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        restaurantService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id,@RequestBody CreateRestaurantRequestDto requestDto){
        return restaurantService.updateRestaurant(id,requestDto);
    }

}
