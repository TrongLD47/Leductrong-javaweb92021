package com.laptrinhjavaweb.service.Impl;


import com.laptrinhjavaweb.convert.BuildingConverter;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.jdbc.BuildingJdbc;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuildingServiceImpl implements  BuildingService {

    @Autowired
    private BuildingJdbc buildingJdbc;

    @Autowired
    private BuildingConverter buildingConverter;


    @Override
    public List<BuildingSearchResponse> findAll(Map<String, Object> params,
                                                String[] buildingTypes) {

        BuildingSearchRequest request = initSearchParams(params, buildingTypes);

        List<BuildingSearchResponse> results = new ArrayList<>();

        List<BuildingEntity> buildingEntities = buildingJdbc.findAll(request);

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

    public BuildingSearchRequest initSearchParams(Map<String, Object> model,
                                                  String[] buildingTypes) {

        BuildingSearchRequest request = new BuildingSearchRequest();
        if(ValidateUtils.isValid(model.get("name"))){
            //request.setName((String)model.get("name")) ;
            request.setName((model.get("name").toString()));
        }
        if(ValidateUtils.isValid(model.get("district"))){
            request.setDistrict(model.get("district").toString());
        }
        if(ValidateUtils.isValid(model.get("street"))){
            //request.setStreet((String)model.get("street"));
            request.setStreet(model.get("street").toString());
        }
        if(ValidateUtils.isValid(model.get("ward"))){
            //request.setWard((String)model.get("ward"));
            request.setWard(model.get("ward").toString());
        }
        if(ValidateUtils.isValid(model.get("buildingArea"))){
           // request.setBuildingArea(Integer.valueOf((String )model.get("buildingArea")));
            request.setBuildingArea(Integer.parseInt(model.get("buildingArea").toString() ));
        }
        if(ValidateUtils.isValid(model.get("numberOfBasement"))){
            request.setNumberOfBasement(Integer.parseInt(model.get("numberOfBasement").toString() ));
           // request.setNumberOfBasement(Integer.valueOf((String )model.get("numberOfBasement")));
        }
        if(ValidateUtils.isValid(model.get("areaRentFrom"))){
           // request.setAreaRentFrom(Integer.valueOf((String )model.get("areaRentFrom")));
            request.setAreaRentFrom(Integer.parseInt(model.get("areaRentFrom").toString() ));
        }
        if(ValidateUtils.isValid(model.get("areaRentTo"))){
            //request.setAreaRentTo(Integer.valueOf((String )model.get("areaRentTo")));
            request.setAreaRentTo(Integer.parseInt(model.get("areaRentTo").toString() ));
        }
        if(ValidateUtils.isValid(model.get("rentpriceFrom"))){
           // request.setRentPriceFrom(Integer.valueOf((String )model.get("rentpriceFrom")));
            request.setRentPriceFrom(Integer.parseInt(model.get("rentpriceFrom").toString() ));
        }
        if(ValidateUtils.isValid(model.get("rentpriceTo"))){
            //request.setRentPriceTo(Integer.valueOf((String )model.get("rentpriceTo")));
            request.setRentPriceTo(Integer.parseInt(model.get("rentpriceTo").toString() ));
        }
        if(ValidateUtils.isValid(model.get("staffId"))){
           // request.setStaffId(Integer.valueOf((String )model.get("staffId")));
            request.setStaffId(Integer.parseInt(model.get("staffId").toString() ));
        }
        if(ValidateUtils.isValid(model.get(buildingTypes))){
            request.setBuildingTypes(buildingTypes);
        }
        return request;
    }
}
