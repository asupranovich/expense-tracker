package com.asupranovich.expense.tracker.persistence.repository;

import com.asupranovich.expense.tracker.domain.model.Household;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdRepository extends CrudRepository<Household, Long> {

}
