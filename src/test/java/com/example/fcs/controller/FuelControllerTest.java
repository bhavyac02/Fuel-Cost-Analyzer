package com.example.fcs.controller;

import com.example.fcs.dao.impl.FuelDao;
import com.example.fcs.entity.Fuel;
import com.example.fcs.entity.Station;
import com.example.fcs.enums.Enums;
import com.example.fcs.service.impl.FuelService;
import com.example.fcs.service.impl.VehicleService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FuelControllerTest {

    private FuelController fuelController;
    private VehicleService vehicleServiceMock;
    private FuelService fuelServiceMock;
    private FuelDao fuelDaoMock;

    @BeforeEach
    void setup(){
        this.fuelDaoMock = Mockito.mock(FuelDao.class);
        this.vehicleServiceMock = Mockito.mock(VehicleService.class);
        this.fuelServiceMock = Mockito.mock(FuelService.class);

        this.fuelController = new FuelController(vehicleServiceMock, fuelDaoMock, fuelServiceMock);
    }

    @Test
    @SneakyThrows
    // Vehicle Id Exist
    // Vehicle Id does not exist
    // Fuel Body does not exist
    void createFuelRecord01() {
        var fuel = new Fuel(1L, Date.valueOf(LocalDate.now()), 5,
                Enums.FuelType.L, 45, 999999L, 123.32, new Station());
        Long vehicleId = 1L;

        Mockito.when(fuelController.createFuelRecord(fuel, vehicleId)).thenReturn(fuel);

        var actual = fuelController.createFuelRecord(fuel, vehicleId);

        assertEquals(fuel, actual);
    }

    @Test
    @SneakyThrows
    void createFuelRecord02(){
        Long vehicleId = null;
        var fuel = new Fuel(1L, Date.valueOf(LocalDate.now()), 5,
                Enums.FuelType.L, 45, 999999L, 123.32, new Station());

        Mockito.when(fuelController.createFuelRecord(fuel, vehicleId)).thenThrow(new IndexOutOfBoundsException());

        assertThrows(IndexOutOfBoundsException.class, () -> fuelController.createFuelRecord(fuel, vehicleId));
    }

    @Test
    @SneakyThrows
    void createFuelRecord03(){
        Long vehicleId = 1L;
        var fuel = new Fuel();

        Mockito.when(fuelController.createFuelRecord(fuel, vehicleId)).thenThrow(new NoSuchFieldError());

        assertThrows(NoSuchFieldError.class, () -> fuelController.createFuelRecord(fuel, vehicleId));
    }

    @Test
    // Vehicle and Fuel Exists
    // Vehicle exist and Fuel does not exist
    //Vehicle and Fuel does not exist

    void getFuelById01() {
        var vehicleId = 1L;
        var fuelId = 1L;
        var expected = new Fuel(1L, Date.valueOf(LocalDate.now()), 5,
                Enums.FuelType.L, 45, 999999L, 123.32, new Station());

        Mockito.when(fuelController.getFuelById(vehicleId, fuelId)).thenReturn(expected);

        var actual = fuelController.getFuelById(vehicleId, fuelId);

        assertEquals(expected, actual);
    }

    @Test
    void getFuelById02(){
        var vehicleId = 1L;
        Long fuelId = null;

        Mockito.when(fuelController.getFuelById(vehicleId, fuelId)).thenThrow(new IndexOutOfBoundsException());

        assertThrows(IndexOutOfBoundsException.class, () -> fuelController.getFuelById(vehicleId, fuelId));

    }

    @Test
    void getFuelById03(){
        Long vehicleId = null;
        Long fuelId = null;

        Mockito.when(fuelController.getFuelById(vehicleId, fuelId)).thenThrow(new IndexOutOfBoundsException());

        assertThrows(IndexOutOfBoundsException.class, ()-> fuelController.getFuelById(vehicleId, fuelId));
    }

    @Test
    @SneakyThrows
    // Vehicle exist and List has No Fuel Record
    // Vehicle exist and List has only one Record
    // Vehicle exist and List has multiple Records
    // All above without fromDate and toDate
    // Vehicle does not Exist
    void getFuelRecord01() {
        var vehicleId = 1L;

        Mockito.when(fuelController.getFuelRecord(vehicleId, null, null)).thenThrow(new NoSuchElementException());

        assertThrows(NoSuchElementException.class, () -> fuelController.getFuelRecord(vehicleId, null, null));
    }

    @Test
    @SneakyThrows
    void getFuelRecord02(){
        var vehicleId = 1L;
        var fuel = new ArrayList<>(List.of(new Fuel(1L, Date.valueOf(LocalDate.now()), 5,
                Enums.FuelType.L, 45, 999999L, 123.32, new Station())));

        Mockito.when(fuelController.getFuelRecord(vehicleId, null, null)).thenReturn(fuel);

        var actual = fuelController.getFuelRecord(vehicleId, null, null);

        assertEquals(fuel, actual);
    }

    @Test
    @SneakyThrows
    void getFuelRecord03(){
        var vehicleID = 1L;
        var fuel = new ArrayList<>(List.of(new Fuel(1L, Date.valueOf(LocalDate.now()), 5,
                Enums.FuelType.L, 45, 999999L, 123.32, new Station()),
                new Fuel(1L, Date.valueOf(LocalDate.now()), 5,
                Enums.FuelType.L, 45, 999999L, 123.32, new Station()),
                new Fuel(1L, Date.valueOf(LocalDate.now()), 5,
                        Enums.FuelType.L, 45, 999999L, 123.32, new Station())));

        Mockito.when(fuelController.getFuelRecord(vehicleID, null, null)).thenReturn(fuel);

        var actual = fuelController.getFuelRecord(vehicleID, null, null);

        assertEquals(fuel, actual);
    }

    @Test
    @SneakyThrows
    void getFuelRecords04(){
        Long vehicleId = null;

        Mockito.when(fuelController.getFuelRecord(vehicleId, null, null)).thenThrow(new NoSuchElementException());

        assertThrows(NoSuchElementException.class, () -> fuelController.getFuelRecord(vehicleId, null, null));


    }

    @Test
    // -> Requires fuelId, vehicleId, fuel Body
    // Vehicle does not exist
    // Vehicle exist and fuel Record does not Exist
    // Vehicle exist, fuel Record exist, but not fuel Body
    // Vehicle exist, fuel Record exist, fuel body Exist
    void updateFuelRecord() {
    }

    @Test
    // -> Requires vehicleIdm fuelId
    // Vehicle does not exist
    // Vehicle exist but no Fuel Record
    // Vehicle and Fuel Record exists
    void deleteFuelRecord() {
    }
}