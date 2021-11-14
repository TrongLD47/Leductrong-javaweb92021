package com.laptrinhjavaweb.api;

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
	public List<BuildingSearchResponse> findAll(@RequestParam Map<String, Object> params,
                                                @RequestParam String[] buildingTypes){
		//buildingService.initSearchParams(params, buildingTypes);

		return  buildingService.findAll(params, buildingTypes);
}
}