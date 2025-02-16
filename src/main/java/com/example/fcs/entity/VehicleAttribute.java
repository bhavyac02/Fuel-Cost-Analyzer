package com.example.fcs.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="VEHICLE_ATTRIBUTE")
public class VehicleAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("VEHICLE_TYPES")
    @Column(name="VEHICLE_TYPES")
    private String vehicleTypes;

    @JsonProperty("VEHICLE_BAND")
    @Column(name="VEHICLE_BRAND")
    private String vehicleBrand;

    @JsonProperty("VEHICLE_MODEL")
    @Column(name="VEHICLE_MODEL")
    private String vehicleModel;

    @JsonProperty("YEAR_OF_PURCHASE")
    @Column(name="YEAR_OF_PURCHASE")
    private Long yearOfPurchase;
}
