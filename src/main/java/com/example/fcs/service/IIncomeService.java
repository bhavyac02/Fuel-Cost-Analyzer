package com.example.fcs.service;

import com.example.fcs.entity.Income;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface IIncomeService {
    Income createIncomeRecord(Long vehicleId, Income income);
    List<Income> getIncomeRecord(Long vehicleId);
}
