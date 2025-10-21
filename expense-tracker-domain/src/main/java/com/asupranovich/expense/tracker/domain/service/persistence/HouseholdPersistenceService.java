package com.asupranovich.expense.tracker.domain.service.persistence;

import com.asupranovich.expense.tracker.domain.model.Household;
import java.util.Optional;

public interface HouseholdPersistenceService {

    Optional<Household> findById(Long householdId);

}
