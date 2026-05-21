package com.example.Cafeteria.Dto;

import com.example.Cafeteria.Schema.MealType;
import com.example.Cafeteria.Schema.MenuItem;
import com.example.Cafeteria.Schema.Restaurant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class CreateMenuRequestDto {
    private Long restaurantId;

    private LocalDate date;

    private MealType mealType;

    private List<Long> menuItemIds;
}
