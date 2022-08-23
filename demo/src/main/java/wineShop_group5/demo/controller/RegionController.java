package wineShop_group5.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import wineShop_group5.demo.model.Region;
import wineShop_group5.demo.repository.RegionRepository;

@RestController
public class RegionController {
	
	@Autowired
	RegionRepository regionRepository;
	
	@GetMapping("/api/region")
	public List<Region> getAllRegion() {
		return regionRepository.findAll();
		
	}
	@GetMapping("/api/region/{id}")
	public Region getRegionId(@PathVariable Integer id) throws Exception{
	return regionRepository.findById(id).orElseThrow(()-> new Exception("Not found"));
	}

}