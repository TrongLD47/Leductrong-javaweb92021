package com.laptrinhjavaweb.jdbc;

import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import java.util.List;

public interface BuildingJdbc {
    List<BuildingEntity> findAll( BuildingSearchResponse buildingSearch);
}
