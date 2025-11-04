package com.asupranovich.expense.tracker.persistence.repository;

import com.asupranovich.expense.tracker.persistence.entity.ExpenseEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Long> {

    @Query("SELECT e FROM ExpenseEntity e WHERE e.householdId = ?1 AND e.payDate BETWEEN ?2 AND ?3 ORDER BY e.payDate DESC")
    List<ExpenseEntity> findByHouseholdIdAndPayDateBetween(Long householdId, LocalDate from, LocalDate to);

}
