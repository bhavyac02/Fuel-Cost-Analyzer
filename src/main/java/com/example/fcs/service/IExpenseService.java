package com.example.fcs.service;

import com.example.fcs.entity.Expense;

import java.util.List;

public interface IExpenseService {
    Expense createExpenseRecord(Long vehicleId, Expense expense);
    List<Expense> getExpenseRecord(Long vehicleId);
}
