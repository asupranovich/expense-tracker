package com.asupranovich.expense.tracker.service.configuration;

import com.asupranovich.expense.tracker.domain.service.AuthenticationService;
import com.asupranovich.expense.tracker.domain.service.CategoryService;
import com.asupranovich.expense.tracker.domain.service.ExpenseService;
import com.asupranovich.expense.tracker.domain.service.HouseholdService;
import com.asupranovich.expense.tracker.domain.service.PersonService;
import com.asupranovich.expense.tracker.domain.service.persistence.CategoryPersistenceService;
import com.asupranovich.expense.tracker.domain.service.persistence.ExpensePersistenceService;
import com.asupranovich.expense.tracker.domain.service.persistence.HouseholdPersistenceService;
import com.asupranovich.expense.tracker.domain.service.persistence.PersonPersistenceService;
import com.asupranovich.expense.tracker.service.impl.AuthenticationServiceImpl;
import com.asupranovich.expense.tracker.service.impl.CategoryServiceImpl;
import com.asupranovich.expense.tracker.service.impl.ExpenseServiceImpl;
import com.asupranovich.expense.tracker.service.impl.HouseholdServiceImpl;
import com.asupranovich.expense.tracker.service.impl.PersonServiceImpl;
import com.asupranovich.expense.tracker.service.security.CurrentPersonDetailsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration(proxyBeanMethods = false)
public class ExpenseTrackerServiceConfiguration {

    @Bean
    public CurrentPersonDetailsProvider personDetailsProvider() {
        return new CurrentPersonDetailsProvider();
    }

    @Bean
    public CategoryService categoryService(CategoryPersistenceService categoryPersistenceService) {
        return new CategoryServiceImpl(categoryPersistenceService);
    }

    @Bean
    public PersonService personService(PersonPersistenceService personPersistenceService) {
        return new PersonServiceImpl(personPersistenceService);
    }

    @Bean
    public HouseholdService householdService(CurrentPersonDetailsProvider personDetailsProvider,
        HouseholdPersistenceService householdPersistenceService) {
        return new HouseholdServiceImpl(personDetailsProvider, householdPersistenceService);
    }

    @Bean
    public ExpenseService expenseService(CurrentPersonDetailsProvider personDetailsProvider, ExpensePersistenceService expensePersistenceService) {
        return new ExpenseServiceImpl(personDetailsProvider, expensePersistenceService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationService authenticationService(PasswordEncoder passwordEncoder, PersonPersistenceService personPersistenceService) {
        return new AuthenticationServiceImpl(passwordEncoder, personPersistenceService);
    }

}
