package com.asupranovich.expense.tracker.web.configuration;

import com.asupranovich.expense.tracker.domain.service.AuthenticationService;
import com.asupranovich.expense.tracker.domain.service.CategoryService;
import com.asupranovich.expense.tracker.domain.service.ExpenseService;
import com.asupranovich.expense.tracker.domain.service.HouseholdService;
import com.asupranovich.expense.tracker.domain.service.PersonService;
import com.asupranovich.expense.tracker.web.controller.AuthenticationController;
import com.asupranovich.expense.tracker.web.controller.CategoryController;
import com.asupranovich.expense.tracker.web.controller.ExpenseController;
import com.asupranovich.expense.tracker.web.controller.ExpenseTrackerControllerAdvice;
import com.asupranovich.expense.tracker.web.controller.HouseholdController;
import com.asupranovich.expense.tracker.web.controller.PersonController;
import com.asupranovich.expense.tracker.web.jwt.JwtHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration(proxyBeanMethods = false)
public class ExpenseTrackerWebConfiguration implements WebMvcConfigurer {

    @Bean
    public ExpenseTrackerControllerAdvice expenseTrackerControllerAdvice() {
        return new ExpenseTrackerControllerAdvice();
    }

    @Bean
    public AuthenticationController authenticationController(JwtHelper jwtHelper, AuthenticationService authenticationService) {
        return new AuthenticationController(jwtHelper, authenticationService);
    }

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

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOriginPatterns("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}
