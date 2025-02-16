package com.example.fcs.dao;

import com.example.fcs.entity.Fuel;

import java.util.Date;
import java.util.List;

public interface IFuelDao {
    List<Fuel> getFuelRecord(Date fromDate, Date toDate) throws Exception;
    Fuel getFuelById(Long vehicleId, Long fuelId);
    Fuel updateFuelRecord(Long vehicleId, Long fuelId, Fuel fuel);
    void deleteFuelRecord(Long vehicleId, Long fuelId) throws Exception;
}
