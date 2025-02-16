package com.example.fcs.dao.impl;

import com.example.fcs.dao.IServicesDao;
import com.example.fcs.entity.Services;
import com.example.fcs.entity.Vehicle;
import com.example.fcs.repository.ServicesRepository;
import com.example.fcs.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesDao implements IServicesDao {

    private final ServicesRepository servicesRepository;
    private final VehicleDao vehicleDao;
    private final VehicleRepository vehicleRepository;

    @Override
    @SneakyThrows
    public Services createServiceRecord(Long vehicleId, Services services) {
        Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);
        vehicle.getServices().add(services);
        vehicleRepository.save(vehicle);
        return services;
    }

    @Override
    @SneakyThrows
    public List<Services> getServiceRecord(Long vehicleId) {
        List<Services> services = servicesRepository.findAll();
        Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);
        vehicle.setServices(services);
        return services;
    }
}
