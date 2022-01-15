package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IBuildingService {

//    BuildingDTO save(BuildingDTO newBuilding);
    BuildingDTO findById(Long id);
//    List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, Pageable pageable);
//    List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch);
    List<BuildingDTO> findAll();
    void save(BuildingDTO newBuilding);
}
