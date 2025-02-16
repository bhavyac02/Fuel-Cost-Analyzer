package com.example.fcs.dao;

import com.example.fcs.entity.Station;

public interface IStationDao {
    Station createStationRecord(Long vehicleId, Long fuelId, Station station) throws Exception;
}
