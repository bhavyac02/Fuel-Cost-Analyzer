package com.example.fcs.entity;


import com.example.fcs.enums.Enums;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "VEHICLE_INFORMATION")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID")
    private Long id;

    @JsonProperty("VEHICLE_NAME")
    @NotEmpty
    @Size(min=3, max=30, message = "Vehicle Name should be 3-30 Characters long")
    @Column(name="`VEHICLE_NAME`")
    private String vehicleName;

    @JsonProperty("VEHICLE_TYPE")
    @Column(name="`VEHICLE_TYPE`")
    @Enumerated(EnumType.STRING)
//    @Type(type = "PSQL_ENUM")
    private Enums.VehicleType vehicleType;

    @JsonProperty("REGISTRATION_NUMBER")
    @Size(min=5, max=10, message = "Registration number should be 5-10 ")
    @NotEmpty
    @Column(name="`REGISTRATION_NUMBER`")
    private String registrationNumber;

    //UniDirectional One to Many Mapping
    @JsonProperty("FUEL")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="vehicle_id")
    private List<Fuel> fuel;

    //UniDirectional One to One Mapping
    @JsonProperty("VEHICLE_ATTRIBUTE")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="attribute_id")
    private VehicleAttribute vehicleAttribute;

    //UniDirectional One to Many Mapping
    @JsonProperty("EXPENSE")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private List<Expense> expense;

    @JsonProperty("SERVICES")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private List<Services> services;

    @JsonProperty("INCOME")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private List<Income> incomes;

    @Transient
    @Column(name="TOTAL_COST")
    private Double totalCost;

    @Transient
    @Column(name="TOTAL_QUANTITY")
    private Double totalQuantity;

    @Transient
    @Column(name = "AVERAGE")
    private Double average;

    public Vehicle() {

    }
}
