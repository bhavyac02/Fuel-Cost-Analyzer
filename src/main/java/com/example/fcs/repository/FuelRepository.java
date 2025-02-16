package com.example.fcs.repository;

import com.example.fcs.entity.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FuelRepository extends JpaRepository<Fuel, Long> {

    //Do not check for null, as service layer already checks for nullability...
    @Query(value = "SELECT f FROM Fuel f WHERE (:fromDate is null OR f.date >= :fromDate) AND (:toDate is null OR f.date <= :toDate)")
    List<Fuel> findFuelRecord(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

    @Query(value = "SELECT f1 FROM Fuel f1 WHERE f1.date = :date")
    List<Fuel> findFuelRecordByDate(@Param("date") Date date);
}
