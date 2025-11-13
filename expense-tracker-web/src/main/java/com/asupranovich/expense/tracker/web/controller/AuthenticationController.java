package com.asupranovich.expense.tracker.web.controller;

import com.asupranovich.expense.tracker.domain.model.Person;
import com.asupranovich.expense.tracker.domain.service.PersonService;
import com.asupranovich.expense.tracker.web.jwt.JwtHelper;
import jakarta.validation.Valid;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final JwtHelper jwtHelper;

    private final PersonService personService;

    @PostMapping
    @RequestMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        Person person = personService.authenticate(email, password);
        String token = jwtHelper.generateToken(person);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping
    @RequestMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody @Valid Person person) {
        Person createdPerson = personService.signUp(person);
        String token = jwtHelper.generateToken(createdPerson);
        return ResponseEntity.ok(Map.of("token", token));
    }

}
