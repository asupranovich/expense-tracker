package com.asupranovich.expense.tracker.service.impl;

import com.asupranovich.expense.tracker.domain.model.Category;
import com.asupranovich.expense.tracker.domain.service.CategoryService;
import com.asupranovich.expense.tracker.domain.service.persistence.CategoryPersistenceService;
import com.asupranovich.expense.tracker.service.security.CurrentPersonDetailsProvider;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CurrentPersonDetailsProvider personDetailsProvider;

    private final CategoryPersistenceService categoryPersistenceService;

    @Override
    public Category add(Category category) {
        Long currentHouseholdId = personDetailsProvider.getCurrentHouseholdId();
        return categoryPersistenceService.add(currentHouseholdId, category);
    }

    @Override
    public Category edit(Category category) {
        Long currentHouseholdId = personDetailsProvider.getCurrentHouseholdId();
        return categoryPersistenceService.edit(currentHouseholdId, category);
    }

    @Override
    public void delete(Long id) {
        Long currentHouseholdId = personDetailsProvider.getCurrentHouseholdId();
        categoryPersistenceService.delete(currentHouseholdId, id);
    }

    @Override
    public List<Category> getAvailable() {
        return categoryPersistenceService.getByHouseholdId(personDetailsProvider.getCurrentHouseholdId());
    }
}
