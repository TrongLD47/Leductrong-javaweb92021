package com.laptrinhjavaweb.convert;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.DistrictEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.jdbc.DistrictJdbc;
import com.laptrinhjavaweb.jdbc.Impl.DistrictJdbcImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuildingConverter {

    @Autowired
    private ModelMapper modelMapper;

    private final DistrictJdbcImpl district = new DistrictJdbcImpl();

    public BuildingSearchResponse convertToBuidingSearchResponse(BuildingEntity entity){

        DistrictEntity districtEntity = district.findById(entity.getDistrictId());

        BuildingSearchResponse buildingSearchResponse = modelMapper.map(entity, BuildingSearchResponse.class);

        buildingSearchResponse.setAddress(buildingSearchResponse.getStreet() + ", "
                + buildingSearchResponse.getWard() + ", " + districtEntity.getName() );

        return  buildingSearchResponse;

        /*        BuildingSearchRequest buildingSearchResponse = new BuildingSearchRequest();
        buildingSearchResponse.setName(entity.getName());*/

//buildingSearchResponse.setAddress(buildingSearchResponse.getStreet() + ", " + buildingSearchResponse.getWard() + ", " + DistrictsEnum.getValueByName(buildingSearchResponse.getDistrict()));
    }

    public BuildingDTO convertToDTO(BuildingEntity entity) {
        BuildingDTO dto = modelMapper.map(entity, BuildingDTO.class);
        dto.setAddress(dto.getStreet() + ", " + dto.getWard() + ", " + DistrictsEnum.getValueByName(dto.getDistrict()));
        dto.setType(String.valueOf(convertBuildingType(dto.getType())));
        return dto;
    }

    private String convertBuildingType(String type) {
        /*String value = "";
        if(type != null && type != "") {
            String[] array = type.split("\\,", -1);
            for (int i = 0; i < array.length; i++) {
                for (BuildingTypesEnum item : BuildingTypesEnum.values()) {
                    if(item.name().equals(array[i])) {
                        if(i > 0) {
                            value += "," +  item.getBuildingTypeValue();
                        }else {
                            value += item.getBuildingTypeValue();
                        }

                    }
                }
            }
        }*/

        String[] array = type.split(",");
        StringBuilder value = new StringBuilder();
        if(0 < array.length) {
            for(String code : array) {
                value.append("\n -").append(BuildingTypesEnum.valueOf(code).getBuildingTypeValue());
            }
        }else {
            return "BuildingType not found!";
        }
        return value.toString();
    }
}
