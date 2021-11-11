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
    public List<BuildingSearchResponse> findAll(Map<String, Object> params,
                                                List<String> buildingTypes) {

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

    @Override
    public BuildingSearchRequest initSearchParams(Map<String, Object> model,
                                                  List<String> buildingTypes) {

        BuildingSearchRequest request = new BuildingSearchRequest();
        if(null != model.get("name") && !"".equals(model.get("name").toString())){
            //request.setName((String)model.get("name")) ;
            request.setName((model.get("name").toString()));
        }
        if(null != model.get("district") && !"".equals(model.get("district").toString())){
            request.setDistrict(model.get("district").toString());
        }

        if(null != model.get("street") && !"".equals(model.get("street").toString())){
            //request.setStreet((String)model.get("street"));
            request.setStreet(model.get("street").toString());
        }
        if(null != model.get("ward") && !"".equals(model.get("ward").toString())){
            //request.setWard((String)model.get("ward"));
            request.setWard(model.get("ward").toString());
        }
        if(null != model.get("floorArea") && !"".equals(model.get("floorArea"))){
           // request.setBuildingArea(Integer.valueOf((String )model.get("buildingArea")));
            request.setBuildingArea(Integer.parseInt(model.get("buildingArea").toString() ));
        }
        if(null != model.get("numberOfBasement") && !"".equals(model.get("numberOfBasement"))){
            request.setNumberOfBasement(Integer.parseInt(model.get("numberOfBasement").toString() ));
           // request.setNumberOfBasement(Integer.valueOf((String )model.get("numberOfBasement")));
        }
        if(null != model.get("areaRentFrom") && !"".equals(model.get("areaRentFrom"))){
           // request.setAreaRentFrom(Integer.valueOf((String )model.get("areaRentFrom")));
            request.setAreaRentFrom(Integer.parseInt(model.get("areaRentFrom").toString() ));
        }
        if(null != model.get("areaRentTo") && !"".equals(model.get("areaRentTo"))){
            //request.setAreaRentTo(Integer.valueOf((String )model.get("areaRentTo")));
            request.setAreaRentTo(Integer.parseInt(model.get("areaRentTo").toString() ));
        }
        if(null != model.get("rentpriceFrom") && !"".equals(model.get("rentpriceFrom"))){
           // request.setRentPriceFrom(Integer.valueOf((String )model.get("rentpriceFrom")));
            request.setRentPriceFrom(Integer.parseInt(model.get("rentpriceFrom").toString() ));
        }
        if(null != model.get("rentpriceTo") && !"".equals(model.get("rentpriceTo"))){
            //request.setRentPriceTo(Integer.valueOf((String )model.get("rentpriceTo")));
            request.setRentPriceTo(Integer.parseInt(model.get("rentpriceTo").toString() ));
        }
        if(null != model.get("staffId") && !"".equals(model.get("staffId"))){
           // request.setStaffId(Integer.valueOf((String )model.get("staffId")));
            request.setStaffId(Integer.parseInt(model.get("staffId").toString() ));
        }
        if(null != buildingTypes && !"".equals(buildingTypes)){
            request.setBuildingTypes(buildingTypes.toString());
        }
        return request;
    }
}
