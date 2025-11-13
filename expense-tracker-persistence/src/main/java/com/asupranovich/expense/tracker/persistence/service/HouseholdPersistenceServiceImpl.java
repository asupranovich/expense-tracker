package com.asupranovich.expense.tracker.persistence.service;

import com.asupranovich.expense.tracker.domain.exception.RecordNotFoundException;
import com.asupranovich.expense.tracker.domain.model.Household;
import com.asupranovich.expense.tracker.domain.service.persistence.HouseholdPersistenceService;
import com.asupranovich.expense.tracker.persistence.entity.CategoryEntity;
import com.asupranovich.expense.tracker.persistence.entity.HouseholdEntity;
import com.asupranovich.expense.tracker.persistence.mapper.HouseholdMapper;
import com.asupranovich.expense.tracker.persistence.repository.CategoryRepository;
import com.asupranovich.expense.tracker.persistence.repository.HouseholdRepository;
import java.util.ArrayList;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class HouseholdPersistenceServiceImpl implements HouseholdPersistenceService {

    private final HouseholdMapper householdMapper;

    private final CategoryRepository categoryRepository;

    private final HouseholdRepository householdRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Household> findById(@NonNull Long householdId) {
        return householdRepository.findById(householdId)
            .map(householdMapper::toDomain);
    }

    @Override
    @Transactional
    public Household add(@NonNull Household household) {
        HouseholdEntity householdEntity = new HouseholdEntity();
        householdEntity.setName(household.getName());
        householdEntity.setCategories(categoryRepository.findByHouseholdIdIsNull());
        householdEntity.setMembers(new ArrayList<>());
        HouseholdEntity savedHouseholdEntity = householdRepository.save(householdEntity);
        return householdMapper.toDomain(savedHouseholdEntity);
    }

    @Override
    @Transactional
    public void enableCategory(@NonNull Long householdId, @NonNull Long categoryId) {
        HouseholdEntity householdEntity = householdRepository.findById(householdId)
            .orElseThrow(() -> new RecordNotFoundException("Household was not found"));
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new RecordNotFoundException("Category was not found"));
        householdEntity.getCategories().add(categoryEntity);
        householdRepository.save(householdEntity);
    }

    @Override
    @Transactional
    public void disableCategory(Long householdId, Long categoryId) {
        HouseholdEntity householdEntity = householdRepository.findById(householdId)
            .orElseThrow(() -> new RecordNotFoundException("Household was not found"));
        householdEntity.getCategories().removeIf(categoryEntity -> categoryEntity.getId().equals(categoryId));
        householdRepository.save(householdEntity);
    }

}
