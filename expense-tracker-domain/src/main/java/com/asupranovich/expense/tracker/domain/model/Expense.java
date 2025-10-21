package com.asupranovich.expense.tracker.domain.model;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Expense {

    private Long id;

    private LocalDate payDate;

    private Double amount;

    private Category category;

    private Person payer;

    private String description;

    private String remark;

    private Household household;
}
