package com.laptrinhjavaweb.jdbc;

import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;

public interface BuildingJdbc {
    List<BuildingEntity> findAll(BuildingSearchRequest buildingSearch);
}
