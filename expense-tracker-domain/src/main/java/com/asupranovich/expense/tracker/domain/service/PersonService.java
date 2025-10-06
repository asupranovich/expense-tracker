package com.asupranovich.expense.tracker.domain.service;

import com.asupranovich.expense.tracker.domain.model.Person;
import java.util.Optional;

public interface PersonService {

    Optional<Person> findById(Long id);

}
