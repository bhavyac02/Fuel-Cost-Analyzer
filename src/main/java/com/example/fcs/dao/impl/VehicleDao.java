package com.example.fcs.dao.impl;

import com.example.fcs.dao.IVehicleDao;
import com.example.fcs.entity.Vehicle;
import com.example.fcs.entity.VehicleAttribute;
import com.example.fcs.repository.VehicleAttributeRepository;
import com.example.fcs.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleDao implements IVehicleDao {

    private final VehicleRepository vehicleRepository;
    private final VehicleAttributeRepository vehicleAttributeRepository;

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        //vehicleAttributeRepository.save(vehicleAttribute);
        //vehicle.setVehicleAttribute(vehicleAttribute);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) throws Exception{
        return vehicleRepository.findById(vehicleId).orElseThrow(
                () -> new Exception("Vehicle Not Found")
        );
    }

    @Override
    public Optional<Vehicle> updateVehicle(Vehicle vehicle, Long vehicleId) {
        Optional<Vehicle> vehicle1 = vehicleRepository.findById(vehicleId);
        vehicle1.ifPresent(
                v -> {
                    v.setVehicleName(vehicle.getVehicleName());
                    v.setVehicleType(vehicle.getVehicleType());
                    v.setRegistrationNumber(vehicle.getRegistrationNumber());
                }
        );
        vehicleRepository.save(vehicle1.get());
        return vehicle1;
    }

    @Override
    public void deleteVehicleById(Long vehicleId) throws Exception {
        vehicleRepository.deleteById(vehicleId);
    }

    @Override
    public void deleteVehicles() throws Exception {
        vehicleRepository.deleteAll();
    }
}
