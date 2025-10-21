package com.asupranovich.expense.tracker.persistence.service;

import com.asupranovich.expense.tracker.domain.model.Category;
import com.asupranovich.expense.tracker.domain.service.persistence.CategoryPersistenceService;
import com.asupranovich.expense.tracker.persistence.entity.CategoryEntity;
import com.asupranovich.expense.tracker.persistence.mapper.CategoryMapper;
import com.asupranovich.expense.tracker.persistence.repository.CategoryRepository;
import java.util.List;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryPersistenceServiceImpl implements CategoryPersistenceService {

    private final CategoryMapper categoryMapper;

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        Iterable<CategoryEntity> allCategoryEntities = categoryRepository.findAll();
        return StreamSupport.stream(allCategoryEntities.spliterator(), false)
            .map(categoryMapper::toDomain)
            .toList();
    }
}
