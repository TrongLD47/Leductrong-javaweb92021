package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponse;
import com.laptrinhjavaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/building")
	public class BuildingAPI {

	@Autowired
	private BuildingService buildingService;

	@GetMapping
	public List<BuildingSearchResponse> findAll(@RequestParam Map<String, String> model, @RequestParam String[] buildingTypes){
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
		List<BuildingSearchResponse> buildings = buildingService.findAll(buildingSearchRequest);

		return buildings;
}
}