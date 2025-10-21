package com.asupranovich.expense.tracker.persistence.mapper;

import com.asupranovich.expense.tracker.domain.model.Expense;
import com.asupranovich.expense.tracker.persistence.entity.ExpenseEntity;
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

}
