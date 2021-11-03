package com.laptrinhjavaweb.service.Impl;

import com.laptrinhjavaweb.convert.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.jdbc.BuildingJdbc;
import com.laptrinhjavaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id.*;


import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingJdbc buildingJdbc;

    @Autowired
    private BuildingConverter buildingConverter;


    @Override
    public List<BuildingDTO> findAll(BuildingSearchResponse buildingSearch) {
        List<BuildingDTO> results = new ArrayList<>();
        List<BuildingEntity> buildingEntities = buildingJdbc.findAll(buildingSearch);
        //convert entity -> BuildingSearchResponse
        for(BuildingEntity item: buildingEntities){
            BuildingDTO buildingDTO = buildingConverter.convertToDTO(item);
            results.add(buildingDTO);
        }
        return results;
    }

}
