package com.asupranovich.expense.tracker.persistence.mapper;

import com.asupranovich.expense.tracker.domain.model.Expense;
import com.asupranovich.expense.tracker.persistence.entity.CategoryEntity;
import com.asupranovich.expense.tracker.persistence.entity.ExpenseEntity;
import com.asupranovich.expense.tracker.persistence.entity.PersonEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExpenseMapper {

    private final CategoryMapper categoryMapper;

    private final PersonMapper personMapper;

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
            .category(categoryMapper.toEntity(expense.getCategory()))
            .payer(personMapper.toEntity(expense.getPayer()))
            .description(expense.getDescription())
            .remark(expense.getRemark())
            .build();
    }
}
