package com.asupranovich.expense.tracker.persistence.configuration;

import com.asupranovich.expense.tracker.domain.service.persistence.CategoryPersistenceService;
import com.asupranovich.expense.tracker.domain.service.persistence.ExpensePersistenceService;
import com.asupranovich.expense.tracker.domain.service.persistence.HouseholdPersistenceService;
import com.asupranovich.expense.tracker.domain.service.persistence.PersonPersistenceService;
import com.asupranovich.expense.tracker.persistence.entity.PersonEntity;
import com.asupranovich.expense.tracker.persistence.mapper.CategoryMapper;
import com.asupranovich.expense.tracker.persistence.mapper.ExpenseMapper;
import com.asupranovich.expense.tracker.persistence.mapper.HouseholdMapper;
import com.asupranovich.expense.tracker.persistence.mapper.PersonMapper;
import com.asupranovich.expense.tracker.persistence.repository.CategoryRepository;
import com.asupranovich.expense.tracker.persistence.repository.ExpenseRepository;
import com.asupranovich.expense.tracker.persistence.repository.HouseholdRepository;
import com.asupranovich.expense.tracker.persistence.repository.PersonRepository;
import com.asupranovich.expense.tracker.persistence.service.CategoryPersistenceServiceImpl;
import com.asupranovich.expense.tracker.persistence.service.ExpensePersistenceServiceImpl;
import com.asupranovich.expense.tracker.persistence.service.HouseholdPersistenceServiceImpl;
import com.asupranovich.expense.tracker.persistence.service.PersonPersistenceServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration(proxyBeanMethods = false)
@EntityScan(basePackageClasses = PersonEntity.class)
@EnableJpaRepositories(basePackageClasses = PersonRepository.class)
public class ExpenseTrackerPersistenceConfiguration {

    @Bean
    public CategoryMapper categoryMapper() {
        return new CategoryMapper();
    }

    @Bean
    public PersonMapper personMapper() {
        return new PersonMapper();
    }

    @Bean
    public HouseholdMapper householdMapper(CategoryMapper categoryMapper, PersonMapper personMapper) {
        return new HouseholdMapper(categoryMapper, personMapper);
    }

    @Bean
    public ExpenseMapper expenseMapper(CategoryMapper categoryMapper, PersonMapper personMapper, HouseholdMapper householdMapper) {
        return new ExpenseMapper(categoryMapper, personMapper, householdMapper);
    }

    @Bean
    public CategoryPersistenceService categoryPersistenceService(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        return new CategoryPersistenceServiceImpl(categoryMapper, categoryRepository);
    }

    @Bean
    public PersonPersistenceService personPersistenceService(PersonMapper personMapper, PersonRepository personRepository) {
        return new PersonPersistenceServiceImpl(personMapper, personRepository);
    }

    @Bean
    public HouseholdPersistenceService householdPersistenceService(HouseholdMapper householdMapper, HouseholdRepository householdRepository) {
        return new HouseholdPersistenceServiceImpl(householdMapper, householdRepository);
    }

    @Bean
    public ExpensePersistenceService expensePersistenceService(ExpenseMapper expenseMapper, ExpenseRepository expenseRepository) {
        return new ExpensePersistenceServiceImpl(expenseMapper, expenseRepository);
    }

}
