package com.example.fcs.dao.impl;

import com.example.fcs.dao.IExpenseDao;
import com.example.fcs.entity.Expense;
import com.example.fcs.entity.Vehicle;
import com.example.fcs.repository.ExpenseRepository;
import com.example.fcs.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseDao implements IExpenseDao {

    private final ExpenseRepository expenseRepository;
    private final VehicleDao vehicleDao;
    private final VehicleRepository vehicleRepository;

    @Override
    @SneakyThrows
    public Expense createExpenseRecord(Long vehicleId, Expense expense) {
        Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);
        vehicle.getExpense().add(expense);
        vehicleRepository.save(vehicle);
        return expense;
    }

    @Override
    @SneakyThrows
    public List<Expense> getExpenseRecord(Long vehicleId) {
        List<Expense> expense = expenseRepository.findAll();
        Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);
        vehicle.setExpense(expense);
        return expense;
    }
}
