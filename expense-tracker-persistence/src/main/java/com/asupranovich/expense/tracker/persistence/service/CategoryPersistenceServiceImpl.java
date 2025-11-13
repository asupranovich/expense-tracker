package com.asupranovich.expense.tracker.persistence.service;

import com.asupranovich.expense.tracker.domain.exception.ActionNotAllowedException;
import com.asupranovich.expense.tracker.domain.exception.RecordNotFoundException;
import com.asupranovich.expense.tracker.domain.model.Category;
import com.asupranovich.expense.tracker.domain.service.persistence.CategoryPersistenceService;
import com.asupranovich.expense.tracker.persistence.entity.CategoryEntity;
import com.asupranovich.expense.tracker.persistence.mapper.CategoryMapper;
import com.asupranovich.expense.tracker.persistence.repository.CategoryRepository;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class CategoryPersistenceServiceImpl implements CategoryPersistenceService {

    private final CategoryMapper categoryMapper;

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Category> getByHouseholdId(@NonNull Long householdId) {
        List<CategoryEntity> householdCategories = categoryRepository.findByHouseholdIdEqualsOrHouseholdIdIsNull(householdId);
        return householdCategories.stream()
            .map(categoryMapper::toDomain)
            .toList();
    }

    @Override
    @Transactional
    public Category add(@NonNull Long householdId, @NonNull Category category) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(category);
        categoryEntity.setHouseholdId(householdId);
        CategoryEntity savedCategoryEntity = categoryRepository.save(categoryEntity);
        return categoryMapper.toDomain(savedCategoryEntity);
    }

    @Override
    @Transactional
    public Category edit(@NonNull Long householdId, @NonNull Category category) {
        CategoryEntity categoryEntity = getById(category.getId());
        assertSameHousehold(householdId, categoryEntity);

        categoryEntity.setName(category.getName());
        CategoryEntity savedCategoryEntity = categoryRepository.save(categoryEntity);
        return categoryMapper.toDomain(savedCategoryEntity);
    }

    @Override
    @Transactional
    public void delete(@NonNull Long householdId, @NonNull Long id) {
        CategoryEntity categoryEntity = getById(id);
        assertSameHousehold(householdId, categoryEntity);

        categoryEntity.setDeleted(true); // soft deleting, because references may exist
        categoryRepository.save(categoryEntity);
    }

    private CategoryEntity getById(Long id) {
        return categoryRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException("Category was not found"));
    }

    private void assertSameHousehold(Long householdId, CategoryEntity categoryEntity) {
        if (!householdId.equals(categoryEntity.getHouseholdId())) {
            throw new ActionNotAllowedException("Category editing is not allowed");
        }
    }
}
