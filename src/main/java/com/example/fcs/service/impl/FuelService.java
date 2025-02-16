package com.example.fcs.service.impl;

import com.example.fcs.dao.impl.FuelDao;
import com.example.fcs.dao.impl.VehicleDao;
import com.example.fcs.entity.Fuel;
import com.example.fcs.entity.Vehicle;
import com.example.fcs.repository.FuelRepository;
import com.example.fcs.service.IFuelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelService implements IFuelService {

    private final FuelDao fuelDao;
    private final VehicleDao vehicleDao;
    private final FuelRepository fuelRepository;

    @Override
    public Double getTotalCost(List<Fuel> fuel) {
        Double totalCost=0d;
        for(Fuel f: fuel){
            totalCost=totalCost+f.getCost();
        }
        return totalCost;
    }

    @Override
    public Double getTotalDistance(List<Fuel> fuel) {
        Double totalDistance=0d;
        for(Fuel f: fuel){
            totalDistance=totalDistance+f.getDistance();
        }
        return totalDistance;
    }

    @Override
    public Double getTotalQuantity(List<Fuel> fuel) {
        Double totalQuantity=0d;
        for(Fuel f: fuel){
            totalQuantity=totalQuantity+f.getFuelQuantity();
        }
        return totalQuantity;
    }

    @Override
    public List<Fuel> getFuelRecord(Long vehicleId, Date fromDate, Date toDate) throws Exception {
        List<Fuel> fuel = fuelDao.getFuelRecord(fromDate, toDate);
        Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);
        vehicle.setFuel(fuel);
        return fuel;
    }


}
