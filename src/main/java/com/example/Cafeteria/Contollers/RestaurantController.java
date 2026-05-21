package com.example.Cafeteria.Contollers;

import com.example.Cafeteria.Dto.CreateRestaurantRequestDto;
import com.example.Cafeteria.Schema.Restaurant;
import com.example.Cafeteria.Services.RestaurantService;
import com.example.Cafeteria.Utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<ApiResponse<Restaurant>> createRestaurant(@RequestBody CreateRestaurantRequestDto requestDto){
        Restaurant restaurant = restaurantService.createRestaurant(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(restaurant,"Restaurant created successfully"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Restaurant>>> getAllRestaurants(){
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(restaurants,"Fetched all restaurants"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Restaurant>> getProductById(@PathVariable Long id){
        Restaurant restaurant = restaurantService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(restaurant,"Fetched restaurant"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id){
        restaurantService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(null,"Restaurant deleted successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Restaurant>> updateRestaurant(@PathVariable Long id,@RequestBody CreateRestaurantRequestDto requestDto){
        Restaurant restaurant = restaurantService.updateRestaurant(id,requestDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.success(restaurant,"Restaurant updated successfully"));
    }

}
