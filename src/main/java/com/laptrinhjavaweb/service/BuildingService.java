package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    List<BuildingSearchResponse> findAll(Map<String, Object> model, List<String> buildingTypes);
    Map<String, String> getDistricts();
    Map<String, String> getBuildingTypes();
    BuildingSearchRequest initSearchParams(Map<String, Object> model, List<String> buildingTypes);
}
