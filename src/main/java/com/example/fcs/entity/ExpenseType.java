package com.example.fcs.entity;


import com.example.fcs.enums.Enums;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "expense_type")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ExpenseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("EXPENSE_TYPE")
    @Column(name = "EXPENSE_TYPE")
    @Enumerated(EnumType.STRING)
    private Enums.ExpenseType expenseType;

    @JsonProperty("EXPENSE_COST")
    @Column(name = "EXPENSE_COST")
    private Double expenseCost;

    //@JsonProperty("EXPENSE_TYPE_LIST")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private Expense expense;
}

