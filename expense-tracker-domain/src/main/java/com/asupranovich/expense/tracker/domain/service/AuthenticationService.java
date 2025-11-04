package com.asupranovich.expense.tracker.domain.service;

import com.asupranovich.expense.tracker.domain.model.Person;

public interface AuthenticationService {

    Person authenticate(String email, String password);

}
