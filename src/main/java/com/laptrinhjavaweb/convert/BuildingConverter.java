package com.laptrinhjavaweb.convert;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BuildingSearchResponse convertToBuidingSearchResponse(BuildingEntity entity){
        BuildingSearchResponse buildingSearchResponse = modelMapper.map(entity, BuildingSearchResponse.class);
/*        BuildingSearchRequest buildingSearchResponse = new BuildingSearchRequest();
        buildingSearchResponse.setName(entity.getName());*/
        return  buildingSearchResponse;
    }

    public BuildingDTO convertToDTO(BuildingEntity entity) {
        BuildingDTO dto = modelMapper.map(entity, BuildingDTO.class);
        dto.setAddress(dto.getStreet() + ", " + dto.getWard() + ", " + DistrictsEnum.getValueByName(dto.getDistrict()));
        dto.setType(String.valueOf(convertBuildingType(dto.getType())));
        return dto;
    }

    private String convertBuildingType(String type) {
        String value = "";
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
        }
        return value;
    }
}
