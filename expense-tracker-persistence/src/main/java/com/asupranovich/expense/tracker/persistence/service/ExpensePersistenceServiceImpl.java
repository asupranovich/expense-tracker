package com.asupranovich.expense.tracker.persistence.service;

import com.asupranovich.expense.tracker.domain.exception.ActionNotAllowedException;
import com.asupranovich.expense.tracker.domain.exception.RecordNotFoundException;
import com.asupranovich.expense.tracker.domain.model.Expense;
import com.asupranovich.expense.tracker.domain.service.persistence.ExpensePersistenceService;
import com.asupranovich.expense.tracker.persistence.entity.ExpenseEntity;
import com.asupranovich.expense.tracker.persistence.mapper.ExpenseMapper;
import com.asupranovich.expense.tracker.persistence.repository.ExpenseRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class ExpensePersistenceServiceImpl implements ExpensePersistenceService {

    private final ExpenseMapper expenseMapper;

    private final ExpenseRepository expenseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Expense> getExpenses(Long householdId, LocalDate fromDate, LocalDate toDate) {
        return expenseRepository.findByHouseholdIdAndPayDateBetween(householdId, fromDate, toDate).stream()
            .map(expenseMapper::toDomain)
            .toList();
    }

    @Override
    @Transactional
    public Expense add(Long householdId, Expense expense) {
        ExpenseEntity expenseEntity = expenseMapper.toEntity(expense);
        expenseEntity.setHouseholdId(householdId);

        ExpenseEntity savedExpenseEntity = expenseRepository.save(expenseEntity);
        return expenseMapper.toDomain(savedExpenseEntity);
    }

    @Override
    @Transactional
    public Expense edit(Long householdId, Expense expense) {
        Optional<ExpenseEntity> existingExpenseEntityOpt = expenseRepository.findById(expense.getId());
        if (existingExpenseEntityOpt.isEmpty()) {
            throw new RecordNotFoundException("Expense was not found");
        }
        ExpenseEntity existingExpenseEntity = existingExpenseEntityOpt.get();
        if (!householdId.equals(existingExpenseEntity.getHouseholdId())) {
            throw new ActionNotAllowedException("Expense editing is not allowed");
        }

        ExpenseEntity updatedExpenseEntity = expenseMapper.toEntity(expense);
        copyExpenseFields(updatedExpenseEntity, existingExpenseEntity);

        return expenseMapper.toDomain(expenseRepository.save(existingExpenseEntity));
    }

    private void copyExpenseFields(ExpenseEntity source, ExpenseEntity target) {
        target.setPayDate(source.getPayDate());
        target.setAmount(source.getAmount());
        target.setCategory(source.getCategory());
        target.setPayer(source.getPayer());
        target.setDescription(source.getDescription());
        target.setRemark(source.getRemark());
    }

    @Override
    @Transactional
    public void delete(Long householdId, Long expenseId) {
        ExpenseEntity expense = expenseRepository.findById(expenseId)
            .orElseThrow(() -> new RecordNotFoundException("Expense was not found"));

        if (!householdId.equals(expense.getHouseholdId())) {
            throw new ActionNotAllowedException("Expense deletion is not allowed");
        }

        expenseRepository.delete(expense);
    }
}
