package com.asupranovich.expense.tracker.persistence.service;

import com.asupranovich.expense.tracker.domain.model.Person;
import com.asupranovich.expense.tracker.domain.service.persistence.PersonPersistenceService;
import com.asupranovich.expense.tracker.persistence.mapper.PersonMapper;
import com.asupranovich.expense.tracker.persistence.repository.PersonRepository;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class PersonPersistenceServiceImpl implements PersonPersistenceService {

    private final PersonMapper personMapper;

    private final PersonRepository personRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findById(@NonNull Long id) {
        return personRepository.findById(id)
            .map(personMapper::toDomain);
    }
}
