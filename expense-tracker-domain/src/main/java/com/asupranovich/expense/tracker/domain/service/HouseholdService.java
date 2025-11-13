package com.asupranovich.expense.tracker.domain.service;

import com.asupranovich.expense.tracker.domain.model.Household;

public interface HouseholdService {

    Household getCurrentHousehold();

    void enableCategory(Long categoryId);

    void disableCategory(Long categoryId);
}
