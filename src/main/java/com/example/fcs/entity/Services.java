package com.example.fcs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "services")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Services {
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "`SERVICE_ID")
    private List<ServiceType> serviceType;

}
