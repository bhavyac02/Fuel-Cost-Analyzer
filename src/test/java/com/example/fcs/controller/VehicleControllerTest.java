package com.example.fcs.controller;

import com.example.fcs.dao.impl.VehicleDao;
import com.example.fcs.entity.Vehicle;
import com.example.fcs.service.impl.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class VehicleControllerTest {
    private VehicleDao vehicleDaoMock;
    private VehicleService vehicleServiceMock;
    private VehicleController vehicleController;

    @BeforeEach
    void setup(){
        this.vehicleDaoMock = Mockito.mock(VehicleDao.class);
        this.vehicleServiceMock = Mockito.mock(VehicleService.class);

        this.vehicleController = new VehicleController(vehicleDaoMock, vehicleServiceMock);
    }

    @Test
    void CreateVehicleTest01(){
        //var vehicle = new Vehicle(1L, "Honda City", "PETROL", "abcd123", );
    }

}