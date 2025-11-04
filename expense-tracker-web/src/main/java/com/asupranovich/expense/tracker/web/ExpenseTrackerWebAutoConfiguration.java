package com.asupranovich.expense.tracker.web;

import com.asupranovich.expense.tracker.web.configuration.ExpenseTrackerSecurityConfiguration;
import com.asupranovich.expense.tracker.web.configuration.ExpenseTrackerWebConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import({
    ExpenseTrackerWebConfiguration.class,
    ExpenseTrackerSecurityConfiguration.class
})
public class ExpenseTrackerWebAutoConfiguration {

}
