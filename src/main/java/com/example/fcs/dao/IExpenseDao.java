package com.example.fcs.dao;

import com.example.fcs.entity.Expense;

import java.util.List;

public interface IExpenseDao {
    Expense createExpenseRecord(Long vehicleId, Expense expense);
    List<Expense> getExpenseRecord(Long vehicleId);
}
