package com.asupranovich.expense.tracker.service.impl;

import com.asupranovich.expense.tracker.domain.model.Household;
import com.asupranovich.expense.tracker.domain.service.HouseholdService;
import com.asupranovich.expense.tracker.domain.service.persistence.HouseholdPersistenceService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HouseholdServiceImpl implements HouseholdService {

    private final HouseholdPersistenceService householdPersistenceService;

    @Override
    public Optional<Household> findById(Long householdId) {
        return householdPersistenceService.findById(householdId);
    }
}
