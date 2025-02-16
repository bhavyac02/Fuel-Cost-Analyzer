package com.example.fcs.entity;

import com.example.fcs.enums.Enums;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "income")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="DATE")
    private Date date;

    @JsonProperty("ODOMETER")
    @Column(name = "ODOMETER")
    private Long odometerReading;

    @JsonProperty("VALUE")
    @Column(name="VALUE")
    private Long value;

    @JsonProperty("SERVICE_TYPE")
    @Column(name = "SERVICE_TYPE")
    @Enumerated(EnumType.STRING)
    private Enums.ServiceType serviceType;

    @JsonProperty("NOTES")
    @Column(name = "NOTES")
    @Size(min=5, max = 128, message = "Additional Notes for further Review")
    private String notes;
}
