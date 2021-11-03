package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import java.util.List;

public interface BuildingService {
    List<BuildingDTO> findAll(BuildingSearchResponse buildingSearch);
}
