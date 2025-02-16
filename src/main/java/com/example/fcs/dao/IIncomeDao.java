package com.example.fcs.dao;

import com.example.fcs.entity.Income;

import java.util.List;

public interface IIncomeDao {
    Income createIncomeRecord(Long vehicleId, Income income);
    List<Income> getIncomeRecord(Long vehicleId);
}
