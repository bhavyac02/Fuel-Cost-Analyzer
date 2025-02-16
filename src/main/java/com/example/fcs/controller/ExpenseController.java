package com.example.fcs.controller;

import com.example.fcs.entity.Expense;
import com.example.fcs.service.impl.ExpenseService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{vehicle_id}/expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping
    public Expense createExpenseRecord(@PathVariable("vehicle_id") Long vehicleId, @RequestBody Expense expense){
        return expenseService.createExpenseRecord(vehicleId, expense);
    }

    @GetMapping
    public List<Expense> getExpenseRecord(@PathVariable("vehicle_id") Long vehicleId){
        return expenseService.getExpenseRecord(vehicleId);
    }
}
