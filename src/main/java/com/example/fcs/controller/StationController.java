package com.example.fcs.controller;

import com.example.fcs.entity.Station;
import com.example.fcs.service.impl.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/{id}/{fuel_id}/station")
@RequiredArgsConstructor
public class StationController {

    private final StationService stationService;

    @PostMapping
    public Station createStationRecord(@PathVariable("id")Long vehicleId, @PathVariable("fuel_id") Long fuelId, @RequestBody Station station) throws Exception {
       return stationService.createStationRecord(vehicleId, fuelId, station);
    }
}
