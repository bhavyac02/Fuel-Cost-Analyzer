package com.example.fcs.controller;

import com.example.fcs.dao.impl.VehicleDao;
import com.example.fcs.entity.Vehicle;
import com.example.fcs.entity.VehicleAttribute;
import com.example.fcs.service.impl.VehicleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleDao vehicleDao;
    private final VehicleService vehicleService;


    @PostMapping
    public Vehicle createVehicle(@RequestBody @Valid Vehicle vehicle){
        return vehicleDao.createVehicle(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable("id") Long vehicleId) throws Exception{
        return vehicleService.getVehicleById(vehicleId);
    }

    @PutMapping("/{id}")
    public Optional<Vehicle> updateVehicle(@PathVariable("id") Long vehicleId, @RequestBody @Valid Vehicle vehicle){
        return vehicleDao.updateVehicle(vehicle, vehicleId);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicleById(@PathVariable("id") Long vehicleId) throws Exception{
        vehicleDao.deleteVehicleById(vehicleId);
    }

    @DeleteMapping
    public void deleteVehicles() throws Exception{
        vehicleDao.deleteVehicles();
    }
}
