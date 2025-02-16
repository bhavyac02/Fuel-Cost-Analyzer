package com.example.fcs.dao.impl;

import com.example.fcs.dao.IStationDao;
import com.example.fcs.entity.Fuel;
import com.example.fcs.entity.Station;
import com.example.fcs.repository.FuelRepository;
import com.example.fcs.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationDao implements IStationDao {

    private final StationRepository stationRepository;
    private final FuelRepository fuelRepository;
    @Override
    public Station createStationRecord(Long vehicleId, Long fuelId, Station station) throws Exception {
        Fuel fuel = fuelRepository.findById(fuelId).orElseThrow(
                () -> new Exception("Fuel Record Not Found")
        );
        fuel.setStation(station);
        stationRepository.save(station);
        return station;
    }
}
