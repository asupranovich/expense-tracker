package com.asupranovich.expense.tracker.persistence.mapper;

import com.asupranovich.expense.tracker.domain.model.Household;
import com.asupranovich.expense.tracker.persistence.entity.HouseholdEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HouseholdMapper {

    private final CategoryMapper categoryMapper;

    private final PersonMapper personMapper;

    public Household toDomain(HouseholdEntity entity) {
        return Household.builder()
            .id(entity.getId())
            .name(entity.getName())
            .categories(entity.getCategories().stream()
                .map(categoryMapper::toDomain)
                .toList())
            .members(entity.getMembers().stream()
                .map(personMapper::toDomain)
                .toList())
            .build();
    }

}
