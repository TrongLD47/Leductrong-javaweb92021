package com.laptrinhjavaweb.service.Impl;


import com.laptrinhjavaweb.convert.BuildingConverter;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.jdbc.BuildingJdbc;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingJdbc buildingJdbc;

    @Autowired
    private BuildingConverter buildingConverter;
    @Autowired
    private BuildingService buildingService;


    @Override
    public List<BuildingSearchResponse> findAll(BuildingSearchRequest buildingSearch) {
        List<BuildingSearchResponse> results = new ArrayList<>();
        List<BuildingEntity> buildingEntities = buildingJdbc.findAll(buildingSearch);
        //convert entity -> BuildingSearchResponse
        for(BuildingEntity item: buildingEntities){
            BuildingSearchResponse buildingSearchResponse = buildingConverter.convertToBuidingSearchResponse(item);
            results.add(buildingSearchResponse);
        }
        return results;
    }

    @Override
    public Map<String, String> getDistricts() {
        Map<String, String> districts = new HashMap<>();
        for (DistrictsEnum item : DistrictsEnum.values()) {
            districts.put(item.name(), item.getDistrictValue());
        }
        return districts;
    }

    @Override
    public Map<String, String> getBuildingTypes() {
        Map<String, String> buildingTypes = new HashMap<>();
        for (BuildingTypesEnum item : BuildingTypesEnum.values()) {
            buildingTypes.put(item.name(), item.getBuildingTypeValue());
        }
        return buildingTypes;
    }

    @Override
    public BuildingSearchRequest initSearchParams(Map<String, String> model, String[] buildingTypes) {

        BuildingSearchRequest buildingSearchRequest = new BuildingSearchRequest();

        buildingSearchRequest.setName(model.get("name"));
        buildingSearchRequest.setDistrict(model.get("district"));
        buildingSearchRequest.setBuildingArea(model.get("buildingArea"));
        buildingSearchRequest.setNumberOfBasement(model.get("numberOfBasement"));
        buildingSearchRequest.setStreet(model.get("street"));
        buildingSearchRequest.setWard(model.get("ward"));
        buildingSearchRequest.setBuildingTypes(buildingTypes);
        buildingSearchRequest.setAreaRentFrom(model.get("areaRentFrom"));
        buildingSearchRequest.setAreaRentTo(model.get("areaRentTo"));
        buildingSearchRequest.setRentPriceFrom(model.get("rentpriceFrom"));
        buildingSearchRequest.setRentPriceTo(model.get("rentpriceTo"));
        buildingSearchRequest.setStaffId(model.get("staffId"));;

        return buildingSearchRequest;
    }
}
