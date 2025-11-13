package com.asupranovich.expense.tracker.domain.service.persistence;

import com.asupranovich.expense.tracker.domain.model.Category;
import java.util.List;

public interface CategoryPersistenceService {

    List<Category> getByHouseholdId(Long householdId);

    Category add(Long householdId, Category category);

    Category edit(Long householdId, Category category);

    void delete(Long householdId, Long id);

}
