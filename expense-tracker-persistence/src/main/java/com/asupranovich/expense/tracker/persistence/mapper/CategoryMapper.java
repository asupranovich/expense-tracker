package com.asupranovich.expense.tracker.persistence.mapper;

import com.asupranovich.expense.tracker.domain.model.Category;
import com.asupranovich.expense.tracker.persistence.entity.CategoryEntity;

public class CategoryMapper {

    public Category toDomain(CategoryEntity entity) {
        return Category.builder()
            .id(entity.getId())
            .name(entity.getName())
            .isDefault(entity.getHouseholdId() == null)
            .build();
    }

    public CategoryEntity toEntity(Category category) {
        return CategoryEntity.builder()
            .id(category.getId())
            .name(category.getName())
            .build();
    }

}
