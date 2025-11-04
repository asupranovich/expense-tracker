package com.asupranovich.expense.tracker.service.security;

import com.asupranovich.expense.tracker.domain.model.Person;
import java.util.Optional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentPersonDetailsProvider {

    public Long getCurrentPersonId() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
            .map(Authentication::getPrincipal)
            .map(Person.class::cast)
            .map(Person::getId)
            .orElseThrow();
    }

    public Long getCurrentHouseholdId() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
            .map(Authentication::getPrincipal)
            .map(Person.class::cast)
            .map(Person::getHouseholdId)
            .orElseThrow();
    }

}
