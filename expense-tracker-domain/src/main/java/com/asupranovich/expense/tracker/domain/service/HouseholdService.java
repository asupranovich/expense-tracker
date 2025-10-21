package com.asupranovich.expense.tracker.domain.service;

import com.asupranovich.expense.tracker.domain.model.Household;
import java.util.Optional;

public interface HouseholdService {

    Optional<Household> findById(Long householdId);

}
