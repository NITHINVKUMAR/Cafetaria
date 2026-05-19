package com.example.Cafeteria.Schema;

import jakarta.persistence.CheckConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "menu_items")
@SQLDelete(sql = "UPDATE menu_items SET deleted_at = CURRENT_TIMESTAMP WHERE id = ? ")
@SQLRestriction("deleted_at is NULL")
public class MenuItem extends BaseEntity{
    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price",columnDefinition = "INTEGER CHECK (price >= 0)")
    private double price;

    @Column(name = "vegetarian")
    private boolean vegetarian;

    @Column(name = "category",nullable = false)
    private ItemCategory category;
}
