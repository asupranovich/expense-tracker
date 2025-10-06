package com.asupranovich.expense.tracker.domain.service.persistence;

import com.asupranovich.expense.tracker.domain.model.Category;
import java.util.List;

public interface CategoryPersistenceService {

    List<Category> getAll();

}
