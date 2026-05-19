package com.example.Cafeteria.Repositories;

import com.example.Cafeteria.Schema.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

}
