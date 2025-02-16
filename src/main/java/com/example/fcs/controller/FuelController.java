package com.example.fcs.controller;


import com.example.fcs.dao.impl.FuelDao;
import com.example.fcs.entity.Fuel;
import com.example.fcs.service.impl.FuelService;
import com.example.fcs.service.impl.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/{id}/fuel")
@RequiredArgsConstructor
public class FuelController {

    private final VehicleService vehicleService;
    private final FuelDao fuelDao;
    private final FuelService fuelService;


    @PostMapping
    public Fuel createFuelRecord(@RequestBody @Valid Fuel fuel, @PathVariable("id") Long vehicleId) throws Exception {
        return vehicleService.createFuelRecord(fuel, vehicleId);
    }

    @GetMapping("/{fuel_id}")
    public Fuel getFuelById(@PathVariable("id") Long vehicleId, @PathVariable("fuel_id") Long fuelId){
        return fuelDao.getFuelById(vehicleId, fuelId);
    }

    @GetMapping
    public List<Fuel> getFuelRecord(@PathVariable("id") Long vehicleId, @RequestParam(required = false, name = "fromDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") Date fromDate, @RequestParam(required = false, name = "toDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd") Date toDate) throws Exception{
        return fuelService.getFuelRecord(vehicleId, fromDate, toDate);
    }

    @PutMapping("/{fuel_id}")
    public Fuel updateFuelRecord(@PathVariable("id") Long vehicleId,@PathVariable("fuel_id") Long fuelId, @RequestBody Fuel fuel){
        return fuelDao.updateFuelRecord(vehicleId, fuelId, fuel);
    }

    @DeleteMapping("/{fuel_id}")
    public void deleteFuelRecord(@PathVariable("id") Long vehicleId,@PathVariable("fuel_id") Long fuelId) throws Exception{
        fuelDao.deleteFuelRecord(vehicleId, fuelId);
    }
}
