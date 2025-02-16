package com.example.fcs.service.impl;

import com.example.fcs.dao.impl.IncomeDao;
import com.example.fcs.entity.Income;
import com.example.fcs.service.IIncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeService implements IIncomeService {

    private final IncomeDao incomeDao;

    @Override
    public Income createIncomeRecord(Long vehicleId, Income income) {
        return incomeDao.createIncomeRecord(vehicleId, income);
    }

    @Override
    public List<Income> getIncomeRecord(Long vehicleId) {
        return incomeDao.getIncomeRecord(vehicleId);
    }
}
