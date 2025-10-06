package com.asupranovich.expense.tracker.persistence.repository;

import com.asupranovich.expense.tracker.persistence.entity.ExpenseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Long> {

}
