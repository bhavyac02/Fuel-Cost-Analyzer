package com.example.fcs.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="VEHICLE_MODEL")
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="VEHICLE_BRAND")
    private String vehicleBrand;

    @Column(name="VEHICLE_MODEL")
    private String vehicleModel;
}
