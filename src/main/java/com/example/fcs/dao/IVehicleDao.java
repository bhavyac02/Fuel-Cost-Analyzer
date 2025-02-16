package com.example.fcs.dao;

import com.example.fcs.entity.Vehicle;
import com.example.fcs.entity.VehicleAttribute;

import java.util.List;
import java.util.Optional;

public interface IVehicleDao{
    Vehicle createVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Long vehicleId) throws Exception;
    Optional<Vehicle> updateVehicle(Vehicle vehicle, Long vehicleId);
    void deleteVehicleById(Long vehicleId) throws Exception;
    void deleteVehicles() throws Exception;
}
