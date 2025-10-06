package com.asupranovich.expense.tracker.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "expense")
public class ExpenseEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity payer;

    @Column(name = "pay_date")
    private LocalDate payDate;

    @ManyToOne
    @JoinColumn(name = "expense_category_id")
    private CategoryEntity category;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "description")
    private String description;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "household_id")
    private HouseholdEntity household;

}
