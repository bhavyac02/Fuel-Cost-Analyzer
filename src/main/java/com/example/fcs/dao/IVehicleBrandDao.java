package com.example.fcs.dao;

import com.example.fcs.entity.VehicleBrand;
import com.example.fcs.enums.Enums;
import com.example.fcs.repository.VehicleBrandRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface IVehicleBrandDao {
    List<VehicleBrand> getVehicleRecord(Enums.VehicleTypes vehicleType, Long id);
}
