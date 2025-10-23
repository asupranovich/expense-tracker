package com.asupranovich.expense.tracker.domain.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Household {

    private Long id;

    private String name;

    private List<Person> members;

    private List<Category> categories;
}
