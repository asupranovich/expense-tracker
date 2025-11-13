package com.asupranovich.expense.tracker.domain.service;

import com.asupranovich.expense.tracker.domain.model.Expense;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseService {

    List<Expense> getMonthExpenses(int month, int year);

    Expense add(Expense expense);

    Expense edit(Expense expense);

    void delete(Long id);
}
