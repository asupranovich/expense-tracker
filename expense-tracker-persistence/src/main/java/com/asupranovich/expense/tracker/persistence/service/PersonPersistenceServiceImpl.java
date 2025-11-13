package com.asupranovich.expense.tracker.persistence.service;

import com.asupranovich.expense.tracker.domain.exception.ActionNotAllowedException;
import com.asupranovich.expense.tracker.domain.exception.RecordNotFoundException;
import com.asupranovich.expense.tracker.domain.model.Person;
import com.asupranovich.expense.tracker.domain.service.persistence.PersonPersistenceService;
import com.asupranovich.expense.tracker.persistence.entity.PersonEntity;
import com.asupranovich.expense.tracker.persistence.mapper.PersonMapper;
import com.asupranovich.expense.tracker.persistence.repository.PersonRepository;
import java.util.List;
import java.util.Objects;
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
    public List<Person> findAllByHouseholdId(Long householdId) {
        return personRepository.findByHouseholdId(householdId)
            .stream()
            .map(personMapper::toDomain)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findById(@NonNull Long id) {
        return personRepository.findById(id)
            .map(personMapper::toDomain);
    }

    @Override
    public Optional<Person> findByEmail(String email) {
        return personRepository.findByEmail(email)
            .map(personMapper::toDomain);
    }

    @Override
    @Transactional
    public Person add(@NonNull Person person) {
        PersonEntity personEntity = personMapper.toEntity(person);
        return personMapper.toDomain(personRepository.save(personEntity));
    }

    @Override
    public Person edit(@NonNull Person person) {
        PersonEntity personEntity = getById(person.getId());
        if (!Objects.equals(personEntity.getHouseholdId(), person.getHouseholdId())) {
            throw new ActionNotAllowedException("Person edit not allowed");
        }
        PersonEntity updatedPersonEntity = personMapper.toEntity(person);
        personEntity.setName(updatedPersonEntity.getName());
        personEntity.setEmail(updatedPersonEntity.getEmail());
        personEntity.setPassword(updatedPersonEntity.getPassword());
        return personMapper.toDomain(personRepository.save(personEntity));
    }

    private PersonEntity getById(Long id) {
        return personRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException("Person was not found"));
    }
}
