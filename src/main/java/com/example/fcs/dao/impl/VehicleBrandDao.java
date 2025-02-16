package com.example.fcs.dao.impl;

import com.example.fcs.dao.IVehicleBrandDao;
import com.example.fcs.entity.VehicleBrand;
import com.example.fcs.enums.Enums;
import com.example.fcs.repository.VehicleBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.JpaQueryCreator;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VehicleBrandDao implements IVehicleBrandDao {

    private final VehicleBrandRepository vehicleBrandRepository;

    @Override
    public List<VehicleBrand> getVehicleRecord(Enums.VehicleTypes vehicleType, Long id) {
        if(vehicleType != null && id != null)
            return vehicleBrandRepository.getAllVehicleBrand(vehicleType, id);
        else if (id==null && vehicleType != null)
            return vehicleBrandRepository.getVehicleBrandByVehicleTypes(vehicleType);
        else if (id != null)
            return vehicleBrandRepository.getVehicleBrandById(id);
        else
            return vehicleBrandRepository.findAll();
}


}
