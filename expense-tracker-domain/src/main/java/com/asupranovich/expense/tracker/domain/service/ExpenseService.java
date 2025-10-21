package com.asupranovich.expense.tracker.domain.service;

import com.asupranovich.expense.tracker.domain.model.Expense;
import java.util.List;

public interface ExpenseService {

    List<Expense> getAll();

}
