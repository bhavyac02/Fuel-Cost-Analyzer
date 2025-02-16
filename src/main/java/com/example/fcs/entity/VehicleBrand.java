package com.example.fcs.entity;

import com.example.fcs.enums.Enums;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="vehicle_brand")
public class VehicleBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="VEHICLE_BRAND")
    private String vehicleBrand;

    @Column(name="VEHICLE_TYPE")
    @Enumerated(EnumType.STRING)
    private Enums.VehicleTypes vehicleTypes;
}
