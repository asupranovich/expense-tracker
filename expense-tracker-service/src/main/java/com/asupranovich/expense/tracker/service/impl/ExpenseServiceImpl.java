package com.asupranovich.expense.tracker.service.impl;

import com.asupranovich.expense.tracker.domain.model.Expense;
import com.asupranovich.expense.tracker.domain.service.ExpenseService;
import com.asupranovich.expense.tracker.domain.service.persistence.ExpensePersistenceService;
import com.asupranovich.expense.tracker.service.security.CurrentPersonDetailsProvider;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final CurrentPersonDetailsProvider personDetailsProvider;

    private final ExpensePersistenceService expensePersistenceService;

    @Override
    public List<Expense> getMonthExpenses(LocalDate date) {
        Long householdId = personDetailsProvider.getCurrentHouseholdId();
        LocalDate fromDate = Optional.ofNullable(date)
            .orElseGet(LocalDate::now)
            .withDayOfMonth(1);
        LocalDate toDate = fromDate.plusMonths(1).minusDays(1);
        return expensePersistenceService.getExpenses(householdId, fromDate, toDate);
    }

    @Override
    public Expense add(@NonNull Expense expense) {
        Long householdId = personDetailsProvider.getCurrentHouseholdId();
        return expensePersistenceService.add(householdId, expense);
    }

    @Override
    public Expense edit(@NonNull Expense expense) {
        Long householdId = personDetailsProvider.getCurrentHouseholdId();
        return expensePersistenceService.edit(householdId, expense);
    }

    @Override
    public void delete(@NonNull Long id) {
        Long householdId = personDetailsProvider.getCurrentHouseholdId();
        expensePersistenceService.delete(householdId, id);
    }
}
