package com.asupranovich.expense.tracker.web.controller;

import com.asupranovich.expense.tracker.domain.model.Expense;
import com.asupranovich.expense.tracker.domain.service.ExpenseService;
import jakarta.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> getMonthExpenses(@RequestParam(name = "date", required = false) LocalDate date) {
        return ResponseEntity.ok(expenseService.getMonthExpenses(date));
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid Expense expense) {
        Expense addedExpense = expenseService.add(expense);
        return ResponseEntity.created(URI.create("/expenses/" + addedExpense.getId()))
            .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> edit(@PathVariable("id") Long id, @RequestBody @Valid Expense expense) {
        expense.setId(id);
        Expense updatedExpense = expenseService.edit(expense);
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        expenseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
