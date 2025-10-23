package com.asupranovich.expense.tracker.domain.service;

import com.asupranovich.expense.tracker.domain.model.Expense;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {

    List<Expense> getMonthExpenses(Long householdId, LocalDate date);

    Expense add(Expense expense);

}
