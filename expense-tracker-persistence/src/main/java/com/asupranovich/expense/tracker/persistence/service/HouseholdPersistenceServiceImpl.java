package com.asupranovich.expense.tracker.persistence.service;

import com.asupranovich.expense.tracker.domain.model.Household;
import com.asupranovich.expense.tracker.domain.service.persistence.HouseholdPersistenceService;
import com.asupranovich.expense.tracker.persistence.mapper.HouseholdMapper;
import com.asupranovich.expense.tracker.persistence.repository.HouseholdRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HouseholdPersistenceServiceImpl implements HouseholdPersistenceService {

    private final HouseholdMapper householdMapper;

    private final HouseholdRepository householdRepository;

    @Override
    public Optional<Household> findById(Long householdId) {
        return householdRepository.findById(householdId)
            .map(householdMapper::toDomain);
    }
}
