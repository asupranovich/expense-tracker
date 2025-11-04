package com.asupranovich.expense.tracker.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    private Long id;

    @NotNull
    private LocalDate payDate;

    @Positive
    private double amount;

    @NotNull
    private Category category;

    @NotNull
    private Person payer;

    @NotBlank
    private String description;

    private String remark;

}
