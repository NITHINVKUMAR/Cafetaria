package com.example.Cafeteria.Dto;

import com.example.Cafeteria.Schema.ItemCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMenuItemRequestDto {
    private Long id;

    private String name;

    private String description;

    private double price;

    private boolean vegetarian;

    private ItemCategory category;
}
