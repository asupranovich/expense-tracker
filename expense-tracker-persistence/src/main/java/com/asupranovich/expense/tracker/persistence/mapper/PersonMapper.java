package com.asupranovich.expense.tracker.persistence.mapper;

import com.asupranovich.expense.tracker.domain.model.Person;
import com.asupranovich.expense.tracker.persistence.entity.PersonEntity;

public class PersonMapper {

    public Person toDomain(PersonEntity personEntity) {
        return Person.builder()
            .id(personEntity.getId())
            .name(personEntity.getName())
            .email(personEntity.getEmail())
            .build();
    }

}
