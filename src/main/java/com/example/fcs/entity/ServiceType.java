package com.example.fcs.entity;

import com.example.fcs.enums.Enums;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "service_type")
@Getter
@Setter
@RequiredArgsConstructor
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("SERVICE_TYPE")
    @Column(name = "SERVICE_TYPE")
    @Enumerated(EnumType.STRING)
    private Enums.ServiceType serviceType;

    @JsonProperty("SERVICE_COST")
    @Column(name = "SERVICE_COST")
    private Long serviceCost;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private Services service;
}
