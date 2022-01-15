package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRespository extends JpaRepository<BuildingEntity, Long> {
//    List<RentAreaEntity> findByBuilding_Id(Long buildingId);
}
