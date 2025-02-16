package com.example.fcs.dao;

import com.example.fcs.entity.Services;

import java.util.List;

public interface IServicesDao {
    Services createServiceRecord(Long vehicleId, Services services);
    List<Services> getServiceRecord(Long vehicleId);
}
