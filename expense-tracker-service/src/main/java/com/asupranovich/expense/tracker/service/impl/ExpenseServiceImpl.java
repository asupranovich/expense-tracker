package com.asupranovich.expense.tracker.service.impl;

import com.asupranovich.expense.tracker.domain.model.Expense;
import com.asupranovich.expense.tracker.domain.service.ExpenseService;
import com.asupranovich.expense.tracker.domain.service.persistence.ExpensePersistenceService;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpensePersistenceService expensePersistenceService;

    @Override
    public List<Expense> getAll() {
        return expensePersistenceService.getAll();
    }
}
