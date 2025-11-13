package com.asupranovich.expense.tracker.persistence.mapper;

import com.asupranovich.expense.tracker.domain.model.Person;
import com.asupranovich.expense.tracker.persistence.entity.PersonEntity;

public class PersonMapper {

    public Person toDomain(PersonEntity personEntity) {
        return Person.builder()
            .id(personEntity.getId())
            .name(personEntity.getName())
            .email(personEntity.getEmail())
            .password(personEntity.getPassword())
            .householdId(personEntity.getHouseholdId())
            .build();
    }

    public PersonEntity toEntity(Person person) {
        return PersonEntity.builder()
            .id(person.getId())
            .name(person.getName())
            .email(person.getEmail())
            .password(person.getPassword())
            .householdId(person.getHouseholdId())
            .build();
    }

}
