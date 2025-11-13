package com.asupranovich.expense.tracker.web.controller;

import com.asupranovich.expense.tracker.domain.model.Household;
import com.asupranovich.expense.tracker.domain.service.HouseholdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/household")
@RequiredArgsConstructor
public class HouseholdController {

    private final HouseholdService householdService;

    @GetMapping
    public ResponseEntity<Household> getHousehold() {
        Household household = householdService.getCurrentHousehold();
        return ResponseEntity.ok(household);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<?> enableCategory(@PathVariable(name = "id") Long categoryId) {
        householdService.enableCategory(categoryId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> disableCategory(@PathVariable(name = "id") Long categoryId) {
        householdService.disableCategory(categoryId);
        return ResponseEntity.noContent().build();
    }

}
