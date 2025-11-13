package com.asupranovich.expense.tracker.service.impl;

import com.asupranovich.expense.tracker.domain.model.Household;
import com.asupranovich.expense.tracker.domain.model.Person;
import com.asupranovich.expense.tracker.domain.service.PersonService;
import com.asupranovich.expense.tracker.domain.service.persistence.HouseholdPersistenceService;
import com.asupranovich.expense.tracker.domain.service.persistence.PersonPersistenceService;
import com.asupranovich.expense.tracker.service.security.CurrentPersonDetailsProvider;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PasswordEncoder passwordEncoder;

    private final CurrentPersonDetailsProvider personDetailsProvider;

    private final HouseholdPersistenceService householdPersistenceService;

    private final PersonPersistenceService personPersistenceService;

    @Override
    public Person authenticate(@NonNull String email, @NonNull String password) {
        return personPersistenceService.findByEmail(email)
            .filter(person -> passwordEncoder.matches(password, person.getPassword()))
            .orElseThrow(() -> new AuthenticationServiceException("Authentication failed!"));
    }

    @Override
    public Person signUp(@NonNull Person person) {
        validate(person);
        Household household = new Household();
        household.setName(person.getName() + "'s Household");
        Household addedHousehold = householdPersistenceService.add(household);
        person.setHouseholdId(addedHousehold.getId());
        encodePassword(person);
        return personPersistenceService.add(person);
    }

    @Override
    public List<Person> getAll() {
        Long currentHouseholdId = personDetailsProvider.getCurrentHouseholdId();
        return personPersistenceService.findAllByHouseholdId(currentHouseholdId);
    }

    @Override
    public Optional<Person> findById(@NonNull Long id) {
        return personPersistenceService.findById(id);
    }

    @Override
    public Optional<Person> findByEmail(@NonNull String email) {
        return personPersistenceService.findByEmail(email);
    }

    @Override
    public Person add(@NonNull Person person) {
        validate(person);
        setHouseholdId(person);
        encodePassword(person);
        return personPersistenceService.add(person);
    }

    @Override
    public Person edit(@NonNull Person person) {
        validate(person);
        //TODO: check household for existing user?
        setHouseholdId(person);
        encodePassword(person);
        return personPersistenceService.edit(person);
    }

    private void validate(Person person) {
        String email = person.getEmail();
        personPersistenceService.findByEmail(email)
            .filter(existingPerson -> !existingPerson.getId().equals(person.getId()))
            .ifPresent(existingPerson -> {
                throw new IllegalArgumentException("User with email " + email + " already exists");
            });
    }

    private void setHouseholdId(Person person) {
        Long currentHouseholdId = personDetailsProvider.getCurrentHouseholdId();
        person.setHouseholdId(currentHouseholdId);
    }

    private void encodePassword(Person person) {
        String password = person.getPassword();
        person.setPassword(passwordEncoder.encode(password));
    }
}
