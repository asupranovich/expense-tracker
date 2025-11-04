package com.asupranovich.expense.tracker.service.impl;

import com.asupranovich.expense.tracker.domain.model.Person;
import com.asupranovich.expense.tracker.domain.service.AuthenticationService;
import com.asupranovich.expense.tracker.domain.service.persistence.PersonPersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;

    private final PersonPersistenceService personPersistenceService;

    @Override
    public Person authenticate(String email, String password) {
        return personPersistenceService.findCredentialsByEmail(email)
            .filter(credentials -> passwordEncoder.matches(password, credentials.password()))
            .flatMap(credentials -> personPersistenceService.findByEmail(credentials.email()))
            .orElseThrow(() -> new AuthenticationServiceException("Authentication failed!"));
    }
}
