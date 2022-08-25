package wineShop_group5.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wineShop_group5.demo.model.Region;
import wineShop_group5.demo.model.Type;
import wineShop_group5.demo.repository.RegionRepository;


@Service
public class RegionService {
	
	@Autowired
	RegionRepository regionRepository;
	


	public List<Region> getAllRegion() {
		return regionRepository.findAll();
		
	}

	public Region getRegionId(Integer id) throws Exception{
		return regionRepository.findById(id).orElseThrow(()-> new Exception("Not found"));
	}
	

	public Region saveRegion(Region region) {
		return regionRepository.save(region);
	}

	public Region updateRegion(int id,Region region) throws Exception{
		Region region1 = getRegionId(id);
		region1.setName(region.getName());
		region1.setCountry(region.getCountry());	
		return regionRepository.save(region1);
		
	}
	
	public void deleteRegion(Integer id) {
		regionRepository.deleteById(id);
	}
	
}