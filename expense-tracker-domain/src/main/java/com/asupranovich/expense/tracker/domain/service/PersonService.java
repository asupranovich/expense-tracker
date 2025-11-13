package com.asupranovich.expense.tracker.domain.service;

import com.asupranovich.expense.tracker.domain.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person authenticate(String email, String password);

    Person signUp(Person person);

    List<Person> getAll();

    Optional<Person> findById(Long id);

    Optional<Person> findByEmail(String email);

    Person add(Person person);

    Person edit(Person person);
}
