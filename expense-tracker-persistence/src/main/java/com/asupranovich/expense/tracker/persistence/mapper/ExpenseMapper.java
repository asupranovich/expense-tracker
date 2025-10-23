package com.asupranovich.expense.tracker.persistence.mapper;

import com.asupranovich.expense.tracker.domain.model.Expense;
import com.asupranovich.expense.tracker.persistence.entity.CategoryEntity;
import com.asupranovich.expense.tracker.persistence.entity.ExpenseEntity;
import com.asupranovich.expense.tracker.persistence.entity.HouseholdEntity;
import com.asupranovich.expense.tracker.persistence.entity.PersonEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExpenseMapper {

    private final CategoryMapper categoryMapper;

    private final PersonMapper personMapper;

    private final HouseholdMapper householdMapper;

    public Expense toDomain(ExpenseEntity entity) {
        return Expense.builder()
            .id(entity.getId())
            .payDate(entity.getPayDate())
            .amount(entity.getAmount())
            .category(categoryMapper.toDomain(entity.getCategory()))
            .payer(personMapper.toDomain(entity.getPayer()))
            .remark(entity.getRemark())
            .description(entity.getDescription())
            .build();
    }

    public ExpenseEntity toEntity(Expense expense) {
        return ExpenseEntity.builder()
            .id(expense.getId())
            .payDate(expense.getPayDate())
            .amount(expense.getAmount())
            .category(CategoryEntity.builder()
                .id(expense.getCategory().getId())
                .build())
            .payer(PersonEntity.builder()
                .id(expense.getPayer().getId())
                .build())
            .description(expense.getDescription())
            .remark(expense.getRemark())
            .household(HouseholdEntity.builder()
                .id(expense.getHousehold().getId())
                .build())
            .build();
    }
}
