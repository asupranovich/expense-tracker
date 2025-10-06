package com.asupranovich.expense.tracker.web.configuration;

import com.asupranovich.expense.tracker.domain.service.PersonService;
import com.asupranovich.expense.tracker.web.controller.PersonController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExpenseTrackerWebConfiguration {

    @Bean
    public PersonController personController(PersonService personService) {
        return new PersonController(personService);
    }

}
