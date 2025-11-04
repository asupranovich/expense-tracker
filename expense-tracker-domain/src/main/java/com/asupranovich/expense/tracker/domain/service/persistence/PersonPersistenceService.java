package com.asupranovich.expense.tracker.domain.service.persistence;

import com.asupranovich.expense.tracker.domain.model.Person;
import com.asupranovich.expense.tracker.domain.model.PersonCredentials;
import java.util.Optional;

public interface PersonPersistenceService {

    Optional<Person> findById(Long id);

    Optional<Person> findByEmail(String email);

    Optional<PersonCredentials> findCredentialsByEmail(String email);
}
