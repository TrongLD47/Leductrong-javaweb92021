package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildingConverter {

    @Autowired
    private ModelMapper modelMapper;
//
//    @Autowired
//    private RentAreaRespository rentAreaRespository;

    public BuildingDTO convertToDTO(BuildingEntity entity) {
        BuildingDTO dto = modelMapper.map(entity, BuildingDTO.class);
        dto.setAddress(dto.getStreet() + ", " + dto.getWard() + ", " + DistrictsEnum.getValueByName(dto.getDistrict()));
        dto.setType(generateBuildingType(dto.getType()));
        return dto;
    }
    public BuildingEntity convertToEntity(BuildingDTO dto) {
        BuildingEntity entity = modelMapper.map(dto, BuildingEntity.class);
        return entity;
    }
    private String generateBuildingType(String type) {
        String[] array = type.split(",");
        StringBuilder value = new StringBuilder();

        if (0 < array.length) {
            for (String code : array) {
                value.append("\n -").append(BuildingTypesEnum.valueOf(code).getBuildingTypeValue());
            }
        } else {
            return "BuildingType not found!";
        }
        return value.toString();
    }

//    public BuildingDTO convertoDTO(BuildingEntity entity){
//        BuildingDTO buildingDTO = modelMapper.map(entity, BuildingDTO.class);
//        //convert to rentarea
//        //List<RentAreaEntity> rentAreaEntities = entity.getRentAreas();
//        List<RentAreaEntity> rentAreaEntities =rentAreaRespository.findByBuilding(buildingDTO.getId()); // cach truyen thong dung JDBC
//        List<String> rentAreas =new ArrayList<>();
//        for(RentAreaEntity item: rentAreaEntities){
//            rentAreas.add(item.getValue());
//        }
//        buildingDTO.setRentAreaStr(String.join(",", rentAreas));
//        return buildingDTO;
//    }
}
