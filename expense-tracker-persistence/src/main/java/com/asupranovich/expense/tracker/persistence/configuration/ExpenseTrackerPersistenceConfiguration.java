package com.asupranovich.expense.tracker.persistence.configuration;

import com.asupranovich.expense.tracker.domain.service.persistence.PersonPersistenceService;
import com.asupranovich.expense.tracker.persistence.entity.PersonEntity;
import com.asupranovich.expense.tracker.persistence.mapper.PersonMapper;
import com.asupranovich.expense.tracker.persistence.repository.PersonRepository;
import com.asupranovich.expense.tracker.persistence.service.PersonPersistenceServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = PersonEntity.class)
@EnableJpaRepositories(basePackageClasses = PersonRepository.class)
public class ExpenseTrackerPersistenceConfiguration {

    @Bean
    public PersonMapper personMapper() {
        return new PersonMapper();
    }

    @Bean
    public PersonPersistenceService userService(PersonMapper personMapper, PersonRepository personRepository) {
        return new PersonPersistenceServiceImpl(personMapper, personRepository);
    }

}
