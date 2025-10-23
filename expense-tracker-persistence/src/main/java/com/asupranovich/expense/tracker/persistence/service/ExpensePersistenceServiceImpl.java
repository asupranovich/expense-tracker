package com.asupranovich.expense.tracker.persistence.service;

import com.asupranovich.expense.tracker.domain.model.Expense;
import com.asupranovich.expense.tracker.domain.service.persistence.ExpensePersistenceService;
import com.asupranovich.expense.tracker.persistence.entity.ExpenseEntity;
import com.asupranovich.expense.tracker.persistence.mapper.ExpenseMapper;
import com.asupranovich.expense.tracker.persistence.repository.ExpenseRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class ExpensePersistenceServiceImpl implements ExpensePersistenceService {

    private final ExpenseMapper expenseMapper;

    private final ExpenseRepository expenseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Expense> getExpenses(Long householdId, LocalDate fromDate, LocalDate toDate) {
        return expenseRepository.findByHouseholdIdAndPayDateBetweenOrderByPayDateDesc(householdId, fromDate, toDate).stream()
            .map(expenseMapper::toDomain)
            .toList();
    }

    @Override
    @Transactional
    public Expense add(Expense expense) {
        ExpenseEntity expenseEntity = expenseMapper.toEntity(expense);
        ExpenseEntity savedExpenseEntity = expenseRepository.save(expenseEntity);
        return expenseMapper.toDomain(savedExpenseEntity);
    }
}
