package com.asupranovich.expense.tracker.domain.service.persistence;

import com.asupranovich.expense.tracker.domain.model.Household;
import java.util.Optional;

public interface HouseholdPersistenceService {

    Optional<Household> findById(Long householdId);

    Household add(Household household);

    void enableCategory(Long householdId, Long categoryId);

    void disableCategory(Long householdId, Long categoryId);

}
