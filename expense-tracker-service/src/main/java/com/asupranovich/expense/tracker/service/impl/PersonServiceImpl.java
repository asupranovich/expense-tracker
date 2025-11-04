package com.asupranovich.expense.tracker.service.impl;

import com.asupranovich.expense.tracker.domain.model.Person;
import com.asupranovich.expense.tracker.domain.service.PersonService;
import com.asupranovich.expense.tracker.domain.service.persistence.PersonPersistenceService;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonPersistenceService personPersistenceService;

    @Override
    public Optional<Person> findById(@NonNull Long id) {
        return personPersistenceService.findById(id);
    }

    @Override
    public Optional<Person> findByEmail(@NonNull String email) {
        return personPersistenceService.findByEmail(email);
    }

}
