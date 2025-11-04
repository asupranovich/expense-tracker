package com.asupranovich.expense.tracker.domain.exception;

public class ActionNotAllowedException extends RuntimeException {

    public ActionNotAllowedException(String message) {
        super(message);
    }

}
