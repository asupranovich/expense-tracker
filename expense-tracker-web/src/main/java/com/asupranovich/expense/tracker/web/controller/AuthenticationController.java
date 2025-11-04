package com.asupranovich.expense.tracker.web.controller;

import com.asupranovich.expense.tracker.domain.model.Person;
import com.asupranovich.expense.tracker.domain.service.AuthenticationService;
import com.asupranovich.expense.tracker.web.jwt.JwtHelper;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
public class AuthenticationController {

    private final JwtHelper jwtHelper;

    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        Person person = authenticationService.authenticate(email, password);
        String token = jwtHelper.generateToken(person);
        return ResponseEntity.ok(Map.of("token", token));
    }

}
