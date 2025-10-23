package com.asupranovich.expense.tracker.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private Long id;

    private String name;

    private String email;

}
