package com.asupranovich.expense.tracker.service.impl;

import com.asupranovich.expense.tracker.domain.model.Expense;
import com.asupranovich.expense.tracker.domain.service.ExpenseService;
import com.asupranovich.expense.tracker.domain.service.persistence.ExpensePersistenceService;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpensePersistenceService expensePersistenceService;

    @Override
    public List<Expense> getMonthExpenses(@NonNull Long householdId, LocalDate date) {
        LocalDate fromDate = Optional.ofNullable(date)
            .orElseGet(LocalDate::now)
            .withDayOfMonth(1);
        LocalDate toDate = fromDate.plus(1, ChronoUnit.MONTHS)
            .minus(1, ChronoUnit.DAYS);
        return expensePersistenceService.getExpenses(householdId, fromDate, toDate);
    }

    @Override
    public Expense add(Expense expense) {
        return expensePersistenceService.add(expense);
    }
}
