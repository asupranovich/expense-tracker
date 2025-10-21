package com.asupranovich.expense.tracker.web.controller;

import com.asupranovich.expense.tracker.domain.model.Household;
import com.asupranovich.expense.tracker.domain.service.HouseholdService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/households")
@RequiredArgsConstructor
public class HouseholdController {

    private final HouseholdService householdService;

    @GetMapping("/{id}")
    public ResponseEntity<Household> getHousehold(@PathVariable("id") Long householdId) {
        Optional<Household> householdOptional = householdService.findById(householdId);
        return householdOptional.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
