package com.example.fcs.dao.impl;

import com.example.fcs.dao.IIncomeDao;
import com.example.fcs.entity.Income;
import com.example.fcs.entity.Vehicle;
import com.example.fcs.repository.IncomeRepository;
import com.example.fcs.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeDao implements IIncomeDao {

    private final IncomeRepository incomeRepository;
    private final VehicleDao vehicleDao;
    private final VehicleRepository vehicleRepository;

    @Override
    @SneakyThrows
    public Income createIncomeRecord(Long vehicleId, Income income) {
        Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);
        vehicle.getIncomes().add(income);
        vehicleRepository.save(vehicle);
        return income;
    }

    @Override
    @SneakyThrows
    public List<Income> getIncomeRecord(Long vehicleId) {
        List<Income> incomes = incomeRepository.findAll();
        Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);
        vehicle.setIncomes(incomes);
        return incomes;
    }
}
