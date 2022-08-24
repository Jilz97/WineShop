package wineShop_group5.demo.controller;

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
import wineShop_group5.demo.model.Wine;
import wineShop_group5.demo.repository.RegionRepository;

@RestController
@RequestMapping("/api/region")
public class RegionController {
	
	@Autowired
	RegionRepository regionRepository;
	
	@GetMapping("/all")
	public List<Region> getAllRegion() {
		return regionRepository.findAll();
		
	}
	@GetMapping("/{id}")
	public Region getRegionId(@PathVariable Integer id) throws Exception{
		return regionRepository.findById(id).orElseThrow(()-> new Exception("Not found"));
	}
	
	@PostMapping("/create")
	public Region postRegion(@RequestBody Region region) {
		return regionRepository.save(region);
	}
	@PutMapping("/update/{id}")
	public Region updateRegion(@PathVariable int id, @RequestBody Region region) throws Exception{
		Region region1 = getRegionId(id);
		region1.setId(id);
		region1.setCountry(region.getCountry());
		region1.setName(region.getName());
		return region1;
	}
	@DeleteMapping("/delete/{id}")
	public String deleteRegion(@PathVariable Integer id) {
		regionRepository.deleteById(id);
		return "Region"+ id + "deleted";
	}
	
}