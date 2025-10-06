package com.asupranovich.expense.tracker.service.impl;

import com.asupranovich.expense.tracker.domain.model.Person;
import com.asupranovich.expense.tracker.domain.service.PersonService;
import com.asupranovich.expense.tracker.domain.service.persistence.PersonPersistenceService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonPersistenceService personPersistenceService;

    @Override
    public Optional<Person> findById(Long id) {
        return personPersistenceService.findById(id);
    }
}
