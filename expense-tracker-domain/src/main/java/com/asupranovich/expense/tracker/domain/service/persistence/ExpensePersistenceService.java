package com.asupranovich.expense.tracker.domain.service.persistence;

import com.asupranovich.expense.tracker.domain.model.Expense;
import java.util.List;

public interface ExpensePersistenceService {

    List<Expense> getAll();

}
