package com.example.Cafeteria.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class CreateRestaurantRequestDto {
    private Long id;
    private String name;
    private String location;
}
