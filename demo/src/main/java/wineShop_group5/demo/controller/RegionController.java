package wineShop_group5.demo.controller;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wineShop_group5.demo.model.Region;
import wineShop_group5.demo.services.RegionService;

@RestController
@RequestMapping("/api/region")
public class RegionController {
	
	@Autowired
	RegionService regionService;
	

	@GetMapping("/all")
	public List<Region> getAllRegion() {
		return regionService.getAllRegion();
		
	}
	@GetMapping("/{id}")
	public Region getRegionId(@PathVariable Integer id) throws Exception{
		return regionService.getRegionId(id);
	}
		
	@PostMapping("/create")
	public Region createRegion(@RequestBody Region region) throws ServerException {
		return regionService.saveRegion(region);
	}
	
	@PutMapping("/update/{id}")
	public Region updateRegion(@PathVariable Integer id,@RequestBody Region region) throws Exception{
		return regionService.updateRegion(id,region);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteRegion(@PathVariable Integer id) {
		regionService.deleteRegion(id);
		return "Region"+ id + "deleted";
	}
	
}