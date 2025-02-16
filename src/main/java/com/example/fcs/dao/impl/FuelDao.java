package com.example.fcs.dao.impl;

import com.example.fcs.dao.IFuelDao;
import com.example.fcs.entity.Fuel;
import com.example.fcs.entity.Vehicle;
import com.example.fcs.repository.FuelRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FuelDao implements IFuelDao {

    private final FuelRepository fuelRepository;
    private final VehicleDao vehicleDao;

    @Override
    public List<Fuel> getFuelRecord(Date fromDate, Date toDate) throws Exception {
        if((fromDate != null) && (toDate!=null))
            return fuelRepository.findFuelRecord(fromDate, toDate);
        else if((toDate != null))
            return fuelRepository.findFuelRecordByDate(toDate);
        else
            return fuelRepository.findAll();
    }

    @Override
    @SneakyThrows
    public Fuel getFuelById(Long vehicleId, Long fuelId) {
        Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);

        for (Fuel fuel: vehicle.getFuel()) {
            if(fuel.getId() == fuelId)
                return fuel;
        }
        throw new Exception("ffsdfdsfsdfdsfds");

        //Alternate Method
//        vehicle.getFuel().forEach(
//                fuel -> {return fuel.getId() == fuelId}
//        );
//        return null;
    }

    @Override
    @SneakyThrows
    public Fuel updateFuelRecord(Long vehicleId, Long fuelId, Fuel fuel) {
        Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);
        for(Fuel fuel1: vehicle.getFuel()) {
            if (fuel.getId() == fuelId) {
                fuel1.setFuelType(fuel.getFuelType());
                fuel1.setFuelQuantity(fuel.getFuelQuantity());
                fuel1.setCost(fuel.getCost());
                fuel1.setDistance(fuel.getDistance());
                fuel1.setMeterReading(fuel.getMeterReading());

                fuelRepository.save(fuel1);
            }
        }

        return fuel;
    }

    @Override
    public void deleteFuelRecord(Long vehicleId, Long fuelId) throws Exception {
        Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);
        for(Fuel fuel : vehicle.getFuel()){
            if(fuel.getId() == fuelId){
                fuelRepository.deleteById(fuelId);
            }
        }
    }


}
