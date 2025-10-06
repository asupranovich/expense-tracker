package com.asupranovich.expense.tracker.service.configuration;

import com.asupranovich.expense.tracker.domain.service.PersonService;
import com.asupranovich.expense.tracker.domain.service.persistence.PersonPersistenceService;
import com.asupranovich.expense.tracker.service.impl.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExpenseTrackerServiceConfiguration {

    @Bean
    public PersonService personService(PersonPersistenceService personPersistenceService) {
        return new PersonServiceImpl(personPersistenceService);
    }

}
