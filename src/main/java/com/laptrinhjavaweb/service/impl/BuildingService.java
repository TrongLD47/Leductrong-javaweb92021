package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.BuildingRespository;
import com.laptrinhjavaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingService implements IBuildingService {

	@Autowired
	private BuildingRespository buildingRespository;

	@Autowired
	private BuildingConverter buildingConverter;

//	@Override
//	public BuildingDTO save(BuildingDTO newBuilding) {
//		return null;
//	}

	@Override
	public BuildingDTO findById(Long id) {
		return null;
	}

//	@Override
//	public List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, Pageable pageable) {
//		return null;
//	}
//
//	@Override
//	public List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch) {
//		return null;
//	}

	@Override
	public List<BuildingDTO> findAll() {
		List<BuildingDTO> results = new ArrayList<>();
		List<BuildingEntity> entities = buildingRespository.findAll();
		for(BuildingEntity item: entities){
			BuildingDTO buildingDTO = buildingConverter.convertToDTO(item);
			results.add(buildingDTO);
		}
		return results;
	}

	@Override
	@Transactional
	public void save(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		buildingRespository.save(buildingEntity);
	}
}
