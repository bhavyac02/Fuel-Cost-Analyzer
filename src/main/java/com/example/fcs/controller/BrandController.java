package com.example.fcs.controller;

import com.example.fcs.dao.impl.VehicleBrandDao;
import com.example.fcs.entity.VehicleBrand;
import com.example.fcs.enums.Enums;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {

    private final VehicleBrandDao vehicleBrandDao;

    @GetMapping
    @ResponseBody
    public List<VehicleBrand> getVehicleBrand(@RequestParam(required = false, name = "type") Enums.VehicleTypes vehicleType
            , @RequestParam(required = false, name = "id") Long id){
        return vehicleBrandDao.getVehicleRecord(vehicleType, id);
    }
}
