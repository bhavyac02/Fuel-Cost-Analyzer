package com.example.fcs.service;

import com.example.fcs.entity.Fuel;

import java.util.Date;
import java.util.List;

public interface IFuelService {
    Double getTotalCost(List<Fuel> fuel);
    Double getTotalDistance(List<Fuel> fuel);
    Double getTotalQuantity(List<Fuel> fuel);
    List<Fuel> getFuelRecord(Long vehicleId, Date fromDate, Date toDate) throws Exception;
}
