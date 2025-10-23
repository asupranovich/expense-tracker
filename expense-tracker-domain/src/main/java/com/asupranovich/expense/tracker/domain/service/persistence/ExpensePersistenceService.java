package com.asupranovich.expense.tracker.domain.service.persistence;

import com.asupranovich.expense.tracker.domain.model.Expense;
import java.time.LocalDate;
import java.util.List;

public interface ExpensePersistenceService {

    List<Expense> getExpenses(Long householdId, LocalDate fromDate, LocalDate toDate);

    Expense add(Expense expense);

}
