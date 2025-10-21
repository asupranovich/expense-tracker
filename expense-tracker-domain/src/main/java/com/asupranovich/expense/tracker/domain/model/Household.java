package com.asupranovich.expense.tracker.domain.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Household {

    private Long id;

    private String name;

    private List<Person> members;

    private List<Category> categories;
}
