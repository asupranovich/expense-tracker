package com.asupranovich.expense.tracker.domain.service;

import com.asupranovich.expense.tracker.domain.model.Category;
import java.util.List;

public interface CategoryService {

    Category add(Category category);

    Category edit(Category category);

    void delete(Long id);

    List<Category> getAvailable();
}
