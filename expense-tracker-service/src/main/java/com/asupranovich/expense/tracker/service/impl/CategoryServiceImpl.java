package com.asupranovich.expense.tracker.service.impl;

import com.asupranovich.expense.tracker.domain.model.Category;
import com.asupranovich.expense.tracker.domain.service.CategoryService;
import com.asupranovich.expense.tracker.domain.service.persistence.CategoryPersistenceService;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryPersistenceService categoryPersistenceService;

    @Override
    public List<Category> getDefaultCategories() {
        return categoryPersistenceService.getAll();
    }
}
