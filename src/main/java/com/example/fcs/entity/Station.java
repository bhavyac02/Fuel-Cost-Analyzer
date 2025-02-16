package com.example.fcs.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "Station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("STATION_NAME")
    @NotEmpty
    @Column(name="STATION_NAME")
    private String stationName;

    @JsonProperty("LATITUDE")
    @Column(name = "LATITUTE")
    private Double latitude;

    @JsonProperty("LONGITUDE")
    @Column(name = "LONGITUDE")
    private Double longitude;
}
