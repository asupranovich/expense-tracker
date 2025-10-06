package com.asupranovich.expense.tracker.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {

    private Long id;

    private String name;

    private boolean isDefault;
}
