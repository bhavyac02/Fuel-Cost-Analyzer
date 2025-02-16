package com.example.fcs.controller;

import com.example.fcs.entity.Income;
import com.example.fcs.service.impl.IncomeService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{vehicle_id}/income")
public class IncomeController {

    private final IncomeService incomeService;

    @PostMapping
    public Income createIncomeRecord(@PathVariable("vehicle_id") Long vehicleId, @RequestBody Income income){
        return incomeService.createIncomeRecord(vehicleId, income);
    }

    @GetMapping
    public List<Income> getIncomeRecord(@PathVariable("vehicle_id") Long vehicleId){
        return incomeService.getIncomeRecord(vehicleId);
    }
}
