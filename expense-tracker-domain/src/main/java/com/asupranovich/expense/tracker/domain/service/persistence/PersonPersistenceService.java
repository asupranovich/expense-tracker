package com.asupranovich.expense.tracker.domain.service.persistence;

import com.asupranovich.expense.tracker.domain.model.Person;
import java.util.Optional;

public interface PersonPersistenceService {

    Optional<Person> findById(Long id);

}
