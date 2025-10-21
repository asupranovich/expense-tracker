package com.asupranovich.expense.tracker.persistence.service;

import com.asupranovich.expense.tracker.domain.model.Expense;
import com.asupranovich.expense.tracker.domain.service.persistence.ExpensePersistenceService;
import com.asupranovich.expense.tracker.persistence.entity.ExpenseEntity;
import com.asupranovich.expense.tracker.persistence.mapper.ExpenseMapper;
import com.asupranovich.expense.tracker.persistence.repository.ExpenseRepository;
import java.util.List;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExpensePersistenceServiceImpl implements ExpensePersistenceService {

    private final ExpenseMapper expenseMapper;

    private final ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAll() {
        Iterable<ExpenseEntity> expenseEntities = expenseRepository.findAll();
        return StreamSupport.stream(expenseEntities.spliterator(), false)
            .map(expenseMapper::toDomain)
            .toList();
    }
}
