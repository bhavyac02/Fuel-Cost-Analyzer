package com.example.fcs.service;


import com.example.fcs.entity.Fuel;
import com.example.fcs.entity.Station;
import com.example.fcs.entity.Vehicle;
import com.example.fcs.entity.VehicleAttribute;

import java.util.List;
import java.util.Optional;

//Business Logic - Create Fuel Records
public interface IVehicleService {
    Fuel createFuelRecord(Fuel fuel, Long vehicleId) throws Exception;
    void updateVehicleStats(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Long vehicleId) throws Exception;
}
