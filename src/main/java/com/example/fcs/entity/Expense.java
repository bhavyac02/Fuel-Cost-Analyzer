package com.example.fcs.entity;

import com.example.fcs.enums.Enums;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;  //Outdated and poorly designed
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="Expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="DATE")
    private Date Date;

    @JsonProperty("ODOMETER")
    @Column(name = "ODOMETER")
    private Long odometerReading;

//    @JsonProperty("EXPENSE_TYPE")
//    @Enumerated(EnumType.STRING)
//    @Column(name = "EXPENSE_TYPE")
//    private Enums.ExpenseType expenseType;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "`EXPENSE_ID`")
    private List<ExpenseType> expenseType;


    @JsonProperty("REASON")
    @Enumerated(EnumType.STRING)
    @Column(name = "REASON")
    private Enums.Reason reason;

    @JsonProperty("LATITUDE")
    @Column(name = "LATITUTE")
    private Double latitude;

    @JsonProperty("LONGITUDE")
    @Column(name = "LONGITUDE")
    private Double longitude;

    @JsonProperty("NOTES")
    @Column(name = "NOTES")
    @Size(min=5, max = 128, message = "Additional Notes for further Review")
    private String notes;
}
