package com.example.Cafeteria.Schema;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "menus")
public class Menus extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id",nullable = false)
    private Restaurant restaurant;

    @Column(name = "menu_date",nullable = false)
    private LocalDate date;

    @Column(name = "meal_type",nullable = false)
    private MealType mealType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "menu_item_mapping",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private List<MenuItem> menuItems;
}
