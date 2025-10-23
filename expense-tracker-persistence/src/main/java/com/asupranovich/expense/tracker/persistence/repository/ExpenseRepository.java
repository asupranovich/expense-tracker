package com.asupranovich.expense.tracker.persistence.repository;

import com.asupranovich.expense.tracker.persistence.entity.ExpenseEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Long> {

    List<ExpenseEntity> findByHouseholdIdAndPayDateBetweenOrderByPayDateDesc(Long householdId, LocalDate from, LocalDate to);

}
