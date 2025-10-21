package com.asupranovich.expense.tracker.service.configuration;

import com.asupranovich.expense.tracker.domain.service.CategoryService;
import com.asupranovich.expense.tracker.domain.service.ExpenseService;
import com.asupranovich.expense.tracker.domain.service.HouseholdService;
import com.asupranovich.expense.tracker.domain.service.PersonService;
import com.asupranovich.expense.tracker.domain.service.persistence.CategoryPersistenceService;
import com.asupranovich.expense.tracker.domain.service.persistence.ExpensePersistenceService;
import com.asupranovich.expense.tracker.domain.service.persistence.HouseholdPersistenceService;
import com.asupranovich.expense.tracker.domain.service.persistence.PersonPersistenceService;
import com.asupranovich.expense.tracker.service.impl.CategoryServiceImpl;
import com.asupranovich.expense.tracker.service.impl.ExpenseServiceImpl;
import com.asupranovich.expense.tracker.service.impl.HouseholdServiceImpl;
import com.asupranovich.expense.tracker.service.impl.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ExpenseTrackerServiceConfiguration {

    @Bean
    public CategoryService categoryService(CategoryPersistenceService categoryPersistenceService) {
        return new CategoryServiceImpl(categoryPersistenceService);
    }

    @Bean
    public PersonService personService(PersonPersistenceService personPersistenceService) {
        return new PersonServiceImpl(personPersistenceService);
    }

    @Bean
    public HouseholdService householdService(HouseholdPersistenceService householdPersistenceService) {
        return new HouseholdServiceImpl(householdPersistenceService);
    }

    @Bean
    public ExpenseService expenseService(ExpensePersistenceService expensePersistenceService) {
        return new ExpenseServiceImpl(expensePersistenceService);
    }

}
