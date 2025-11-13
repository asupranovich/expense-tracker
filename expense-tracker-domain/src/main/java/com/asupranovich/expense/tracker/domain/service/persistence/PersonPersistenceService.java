package com.asupranovich.expense.tracker.domain.service.persistence;

import com.asupranovich.expense.tracker.domain.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonPersistenceService {

    List<Person> findAllByHouseholdId(Long householdId);

    Optional<Person> findById(Long id);

    Optional<Person> findByEmail(String email);

    Person add(Person person);

    Person edit( Person person);
}
