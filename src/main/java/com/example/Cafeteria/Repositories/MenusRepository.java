package com.example.Cafeteria.Repositories;

import com.example.Cafeteria.Schema.MealType;
import com.example.Cafeteria.Schema.Menus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface MenusRepository extends JpaRepository<Menus,Long> {

    @Query("""
           SELECT DISTINCT m
           FROM Menus m
           LEFT JOIN FETCH m.restaurant
           LEFT JOIN FETCH m.menuItems
           """)
    List<Menus> findAllMenusWithRelations();

    List<Menus> findByRestaurantId(Long restaurantId);

    @Query("""
       SELECT DISTINCT m
       FROM Menus m
       LEFT JOIN FETCH m.restaurant
       LEFT JOIN FETCH m.menuItems
       WHERE m.date = :date
       """)
    List<Menus> findAllByDateWithRelations(LocalDate date);

    @Query("""
       SELECT DISTINCT m
       FROM Menus m
       LEFT JOIN FETCH m.restaurant
       LEFT JOIN FETCH m.menuItems
       WHERE m.restaurant.id = :restaurantId
       AND m.date = :date
       """)
    List<Menus> findAllByRestaurantAndDateWithRelations(
            Long restaurantId,
            LocalDate date
    );

    boolean existsByRestaurantIdAndDateAndMealType(
            Long restaurantId,
            LocalDate date,
            MealType mealType
    );
}
