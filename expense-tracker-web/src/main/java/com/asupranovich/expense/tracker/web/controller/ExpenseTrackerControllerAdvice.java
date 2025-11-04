package com.asupranovich.expense.tracker.web.controller;

import com.asupranovich.expense.tracker.domain.exception.ActionNotAllowedException;
import com.asupranovich.expense.tracker.domain.exception.RecordNotFoundException;
import javax.naming.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExpenseTrackerControllerAdvice {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ActionNotAllowedException.class)
    public ResponseEntity<?> handleActionNotAllowedException(ActionNotAllowedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

}
