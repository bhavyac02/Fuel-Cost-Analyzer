package com.example.fcs.entity;

import com.example.fcs.enums.Enums;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "fuel")
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @JsonProperty("DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE")
    private Date date;

    @JsonProperty("FUEL_QUANTITY")
    @NotNull
    @Column(name="`FUEL_QUANTITY`")
    private Integer fuelQuantity;

    @JsonProperty("FUEL_TYPE")
    @Column(name="`FUEL_TYPE`", columnDefinition = "VARCHAR(10)")
    @Enumerated(EnumType.STRING)
    //@Type(type = "PSQL_ENUM")
    private Enums.FuelType fuelType;

    @JsonProperty("DISTANCE")
    @NotNull
    @Column(name = "`DISTANCE`")
    private Integer distance;

    @JsonProperty("METER_READING")
    @NotNull
    @Column(name = "`METER_READING`")
    private Long meterReading;

    @JsonProperty("COST")
    @NotNull
    @Column(name = "`COST`", nullable = false)
    private Double cost;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "station_id")
    private Station station;

}
