package com.example.fcs.repository;

import com.example.fcs.entity.VehicleBrand;
import com.example.fcs.enums.Enums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface VehicleBrandRepository extends JpaRepository<VehicleBrand, Long>, JpaSpecificationExecutor<VehicleBrand> {

    //Hard-Coded Query
//    @Query(value = "SELECT v FROM VehicleBrand v WHERE v.vehicleTypes= :type AND v.id= :id")
//    List<VehicleBrand> getAllVehicleBrand(@Param("type") Enums.VehicleTypes vehicleType, @Param("id") Long id);

//    @Query(value = "SELECT v FROM VehicleBrand v WHERE v.vehicleTypes= :type")
//    List<VehicleBrand> getVehicleBrandByVehicleTypes(@Param("type") Enums.VehicleTypes vehicleType);
//
//    @Query("SELECT v FROM VehicleBrand v WHERE v.id= :id")
//    List<VehicleBrand> getVehicleBrandById(@Param("id") Long id);

    //Dynamic Query
    @Query(value = "SELECT v FROM VehicleBrand v WHERE (:type is null OR v.vehicleTypes= :type) AND (:id is null OR v.id= :id)")
    List<VehicleBrand> getAllVehicleBrand(@Param("type") Enums.VehicleTypes vehicleType, @Param("id") Long id);
    List<VehicleBrand> getVehicleBrandByVehicleTypes(Enums.VehicleTypes vehicleType);
    List<VehicleBrand> getVehicleBrandById(Long id);
}