package com.asupranovich.expense.tracker.service;

import com.asupranovich.expense.tracker.service.configuration.ExpenseTrackerServiceConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import(ExpenseTrackerServiceConfiguration.class)
public class ExpenseTrackerServiceAutoConfiguration {

}
