package com.example.fcs.controller;

import com.example.fcs.entity.Services;
import com.example.fcs.service.impl.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{vehicle_id}/service")
@RequiredArgsConstructor
public class ServiceController {

    private final ServicesService serviceService;

    @PostMapping
    public Services createServiceRecord(@PathVariable("vehicle_id") Long vehicleId, @RequestBody Services service){
        return serviceService.createServiceRecord(vehicleId, service);
    }

    @GetMapping
    public List<Services> getServiceRecord(@PathVariable("vehicle_id") Long vehicleId){
        return serviceService.getServiceRecord(vehicleId);
    }
}
