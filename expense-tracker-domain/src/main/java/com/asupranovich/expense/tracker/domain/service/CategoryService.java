package com.asupranovich.expense.tracker.domain.service;

import com.asupranovich.expense.tracker.domain.model.Category;
import java.util.List;

public interface CategoryService {

    List<Category> getDefaultCategories();

}
