package com.example.fcs.controller;

import com.example.fcs.entity.Expense;
import com.example.fcs.enums.Enums;
import com.example.fcs.service.impl.ExpenseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseControllerTest {

    private ExpenseController expenseController;
    private ExpenseService expenseServiceMock;

    @BeforeEach
    void setup(){
        this.expenseServiceMock = Mockito.mock(ExpenseService.class);

        this.expenseController = new ExpenseController(expenseServiceMock);
    }

    @Test
    void createExpenseRecordTest01(){
        var expense = new Expense(1L, Date.valueOf(LocalDate.now()), 123453L,new ArrayList<>(),
                Enums.Reason.WORK,
                1234.12, 1234.324, "No Note");
        var vehicleId = 1L;

        var expected = new Expense(1L, Date.valueOf(LocalDate.now()), 12345L,new ArrayList<>(),
                Enums.Reason.WORK,
                1234.12, 1234.324, "No Note");

        Mockito.when(expenseController.createExpenseRecord(vehicleId, expense)).thenReturn(expected);

        var actual = expenseController.createExpenseRecord(vehicleId, expense);

        assertEquals(expected, actual);
    }

    @Test
    void createExpenseRecordTest02(){
        var expense = new Expense(1L, Date.valueOf(LocalDate.now()), 123453L,new ArrayList<>(),
                Enums.Reason.WORK,
                1234.12, 1234.324, "No Note");
        Long vehicleId = null;

        Mockito.when(expenseController.createExpenseRecord(vehicleId, expense)).thenThrow(new IndexOutOfBoundsException());

        assertThrows(IndexOutOfBoundsException.class, () -> expenseController.createExpenseRecord(vehicleId, expense));
    }

    @Test
    void getExpenseRecordTest01(){
        var id = 1L;
        var expected = new ArrayList<Expense>();
        Mockito.when(expenseController.getExpenseRecord(id)).thenReturn(expected);

        var actual = expenseController.getExpenseRecord(id);

        assertEquals(expected, actual);
    }

    @Test
    void getExpenseRecordTest02(){
        var id = 1L;
        var expected = new ArrayList<>(Arrays.asList(new Expense(1L, Date.valueOf(LocalDate.now()),
                12345L,new ArrayList<>(),
                Enums.Reason.WORK,
                1234.12, 1234.324, "No Note")));
        Mockito.when(expenseController.getExpenseRecord(id)).thenReturn(expected);

        var actual = expenseController.getExpenseRecord(id);

        assertEquals(expected, actual);
    }

    @Test
    void getExpenseRecordTest03(){
        var id = 1L;
        var expected = new ArrayList<>(Arrays.asList(new Expense(1L, Date.valueOf(LocalDate.now()),
                12345L,new ArrayList<>(),
                Enums.Reason.WORK,
                1234.12, 1234.324, "No Note"), new Expense(1L, Date.valueOf(LocalDate.now()),
                12345L,new ArrayList<>(),
                Enums.Reason.WORK,
                1234.12, 1234.324, "No Note")));
        Mockito.when(expenseController.getExpenseRecord(id)).thenReturn(expected);

        var actual = expenseController.getExpenseRecord(id);

        assertEquals(expected, actual);
    }

    @Test()
    void getExpenseRecordTest04(){
        var id = 199L;
        Mockito.when(expenseController.getExpenseRecord(id)).thenThrow(new IndexOutOfBoundsException());

        assertThrows(IndexOutOfBoundsException.class, ()-> expenseController.getExpenseRecord(id), "Given Id does not exist");
    }
}