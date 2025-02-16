package com.example.fcs.service.impl;

import com.example.fcs.dao.impl.ExpenseDao;
import com.example.fcs.entity.Expense;
import com.example.fcs.service.IExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService implements IExpenseService {

    private final ExpenseDao expenseDao;
    @Override
    public Expense createExpenseRecord(Long vehicleId, Expense expense) {
        return expenseDao.createExpenseRecord(vehicleId, expense);
    }

    @Override
    public List<Expense> getExpenseRecord(Long vehicleId) {
        return expenseDao.getExpenseRecord(vehicleId);
    }
}
