package com.asupranovich.expense.tracker.web.configuration;

import com.asupranovich.expense.tracker.domain.service.CategoryService;
import com.asupranovich.expense.tracker.domain.service.ExpenseService;
import com.asupranovich.expense.tracker.domain.service.HouseholdService;
import com.asupranovich.expense.tracker.domain.service.PersonService;
import com.asupranovich.expense.tracker.web.controller.CategoryController;
import com.asupranovich.expense.tracker.web.controller.ExpenseController;
import com.asupranovich.expense.tracker.web.controller.HouseholdController;
import com.asupranovich.expense.tracker.web.controller.PersonController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ExpenseTrackerWebConfiguration {

    @Bean
    public CategoryController categoryController(CategoryService categoryService) {
        return new CategoryController(categoryService);
    }

    @Bean
    public PersonController personController(PersonService personService) {
        return new PersonController(personService);
    }

    @Bean
    public HouseholdController householdController(HouseholdService householdService) {
        return new HouseholdController(householdService);
    }

    @Bean
    public ExpenseController expenseController(ExpenseService expenseService) {
        return new ExpenseController(expenseService);
    }
}
