package com.example.fcs.service.impl;

import com.example.fcs.dao.impl.ServicesDao;
import com.example.fcs.entity.Services;
import com.example.fcs.service.IServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesService implements IServicesService {

    private final ServicesDao servicesDao;

    @Override
    public Services createServiceRecord(Long vehicleId, Services service) {
        return servicesDao.createServiceRecord(vehicleId, service);
    }

    @Override
    public List<Services> getServiceRecord(Long vehicleId) {
        return servicesDao.getServiceRecord(vehicleId);
    }
}
