package com.asupranovich.expense.tracker.domain.model;

public record PersonCredentials (String email, String password) {

    public static PersonCredentials of(String email, String password) {
        return new PersonCredentials(email, password);
    }

}
