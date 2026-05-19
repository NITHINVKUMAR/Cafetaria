package com.example.Cafeteria.Services;

import com.example.Cafeteria.Dto.CreateRestaurantRequestDto;
import com.example.Cafeteria.Repositories.RestaurantRepository;
import com.example.Cafeteria.Schema.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(CreateRestaurantRequestDto requestDto){
        Restaurant newRestaurant = Restaurant.builder().name(requestDto.getName()).location(requestDto.getLocation()).build();
        return restaurantRepository.save(newRestaurant);
    }

    public List<Restaurant>getAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public Restaurant getProductById(Long id){
        return restaurantRepository.findById(id).orElseThrow(() ->new RuntimeException("Product with "+ id +"Not found"));
    }

    public void deleteProduct(Long id){
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found to delete"));
        restaurantRepository.deleteById(id);
    }

    public Restaurant updateRestaurant(Long id,CreateRestaurantRequestDto requestDto){
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(()-> new RuntimeException("Product Not found to delete"));
        restaurant.setName(requestDto.getName());
        restaurant.setLocation(requestDto.getLocation());
        return restaurantRepository.save(restaurant);
    }
}
