package com.example.fcs.service.impl;

import com.example.fcs.dao.impl.VehicleDao;
import com.example.fcs.entity.Fuel;
import com.example.fcs.entity.Vehicle;

import com.example.fcs.repository.VehicleRepository;
import com.example.fcs.service.IVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VehicleService implements IVehicleService {

    private final VehicleDao vehicleDao;
    private final VehicleRepository vehicleRepository;
    private final FuelService fuelService;

    @Override
    public Fuel createFuelRecord(Fuel fuel, Long vehicleId) throws Exception {
        Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);
        //fuelRepository.save(fuel);
        if(fuel.getDate()==null){
            fuel.setDate(new Date());
        }
        vehicle.getFuel().add(fuel);
        vehicleRepository.save(vehicle);
        return fuel;
    }

    @Override
    public void updateVehicleStats(Vehicle vehicle) {
        Double totalCost = fuelService.getTotalCost(vehicle.getFuel());
        Double totalDistance = fuelService.getTotalDistance(vehicle.getFuel());
        Double totalQuantity = fuelService.getTotalQuantity(vehicle.getFuel());

        vehicle.setTotalCost(totalCost);
        vehicle.setTotalQuantity(totalQuantity);

        Double avg = totalDistance/totalQuantity;
        vehicle.setAverage(avg);
    }

    @Override
    public List<Vehicle> getAllVehicles() {

        List<Vehicle> vehicles = vehicleDao.getAllVehicles();
        vehicles.forEach(vehicle -> updateVehicleStats(vehicle));
        return vehicles;
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) throws Exception {
        Vehicle vehicles = vehicleDao.getVehicleById(vehicleId);
        updateVehicleStats(vehicles);
        return vehicles;
    }
}
