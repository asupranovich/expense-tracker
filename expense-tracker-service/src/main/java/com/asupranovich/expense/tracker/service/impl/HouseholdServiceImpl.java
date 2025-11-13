package com.asupranovich.expense.tracker.service.impl;

import com.asupranovich.expense.tracker.domain.exception.RecordNotFoundException;
import com.asupranovich.expense.tracker.domain.model.Household;
import com.asupranovich.expense.tracker.domain.service.HouseholdService;
import com.asupranovich.expense.tracker.domain.service.persistence.HouseholdPersistenceService;
import com.asupranovich.expense.tracker.service.security.CurrentPersonDetailsProvider;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HouseholdServiceImpl implements HouseholdService {

    private final CurrentPersonDetailsProvider personDetailsProvider;

    private final HouseholdPersistenceService householdPersistenceService;

    @Override
    public Household getCurrentHousehold() {
        Long householdId = personDetailsProvider.getCurrentHouseholdId();
        return householdPersistenceService.findById(householdId)
            .orElseThrow(() -> new RecordNotFoundException("Household was not found"));
    }

    @Override
    public void enableCategory(@NonNull Long categoryId) {
        Long householdId = personDetailsProvider.getCurrentHouseholdId();
        householdPersistenceService.enableCategory(householdId, categoryId);
    }

    @Override
    public void disableCategory(@NonNull Long categoryId) {
        Long householdId = personDetailsProvider.getCurrentHouseholdId();
        householdPersistenceService.disableCategory(householdId, categoryId);
    }
}
