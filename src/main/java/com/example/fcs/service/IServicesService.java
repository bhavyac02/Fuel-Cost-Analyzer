package com.example.fcs.service;

import com.example.fcs.entity.Services;

import java.util.List;

public interface IServicesService {
    Services createServiceRecord(Long vehicleId, Services service);
    List<Services> getServiceRecord(Long vehicleId);
}
