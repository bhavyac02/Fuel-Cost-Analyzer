package com.example.fcs.service;

import com.example.fcs.entity.Station;

public interface IStationService {
    Station createStationRecord(Long vehicleId, Long fuelId, Station station) throws Exception;
}
