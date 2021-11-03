package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.dto.BuildingDTO;
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
	public List<BuildingDTO> findAll(@RequestParam Map<String, String> model, @RequestParam String[] buildingTypes){
		BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse.Builder()
				.setName(model.get("name")) .setDistrict(model.get("district"))
				.setFloorArea(model.get("floorArea"))
				.setNumberOfBasement(model.get("numberOfBasement"))
				.setStreet(model.get("street")) .setWard(model.get("ward"))
				.setBuildingTypes(buildingTypes)
				.setAreaRentFrom(model.get("areaRentFrom"))
				.setAreaRentTo(model.get("areaRentTo"))
				.setCostRentFrom(model.get("rentpriceFrom"))
				.setCostRentTo(model.get("rentpriceTo")) .setStaffId(model.get("staffId"))
				.build();
		List<BuildingDTO> buildings = buildingService.findAll(buildingSearchResponse);
		return buildings;

}
}