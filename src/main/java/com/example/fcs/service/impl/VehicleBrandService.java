package com.example.fcs.service.impl;

import com.example.fcs.dao.impl.VehicleBrandDao;
import com.example.fcs.entity.VehicleBrand;
import com.example.fcs.enums.Enums;
import com.example.fcs.service.IVehicleBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleBrandService implements IVehicleBrandService {

    private final VehicleBrandDao vehicleBrandDao;

    @Override
    public List<VehicleBrand> getVehicleRecord() {
        return null;
    }
}

