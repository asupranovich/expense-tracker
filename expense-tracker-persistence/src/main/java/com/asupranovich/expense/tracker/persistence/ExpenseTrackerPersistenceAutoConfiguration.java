package com.asupranovich.expense.tracker.persistence;

import com.asupranovich.expense.tracker.persistence.configuration.ExpenseTrackerPersistenceConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import({ExpenseTrackerPersistenceConfiguration.class})
public class ExpenseTrackerPersistenceAutoConfiguration {

}
