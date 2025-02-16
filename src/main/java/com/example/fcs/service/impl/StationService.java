package com.example.fcs.service.impl;

import com.example.fcs.dao.impl.StationDao;
import com.example.fcs.entity.Station;
import com.example.fcs.service.IStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationService implements IStationService {

    private final StationDao stationDao;
    @Override
    public Station createStationRecord(Long vehicleId, Long fuelId, Station station) throws Exception {
        return stationDao.createStationRecord(vehicleId, fuelId, station);
    }
}
