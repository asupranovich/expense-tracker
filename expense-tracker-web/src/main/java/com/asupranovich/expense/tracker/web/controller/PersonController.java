package com.asupranovich.expense.tracker.web.controller;

import com.asupranovich.expense.tracker.domain.model.Person;
import com.asupranovich.expense.tracker.domain.service.PersonService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody @Valid Person person) {
        Person addedPerson = personService.add(person);
        return ResponseEntity.created(URI.create("/person/" + addedPerson.getId()))
            .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> edit(@PathVariable(name = "id") Long personId, @RequestBody @Valid Person person) {
        person.setId(personId);
        Person updatedPerson = personService.edit(person);
        return ResponseEntity.ok(updatedPerson);
    }
}
