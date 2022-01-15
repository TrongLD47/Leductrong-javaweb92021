package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentAreaRespository extends JpaRepository<RentAreaEntity, Long> {
    List<RentAreaEntity> findByBuilding_Id(Long buildingId);
}
