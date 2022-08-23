package wineShop_group5.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import wineShop_group5.demo.model.winery;
import wineShop_group5.demo.repository.MySqlRepository;

@RestController
public class WineryController {
	
	@Autowired
	MySqlRepository mySqlRepository;
	
	@GetMapping("/get-all-wine")
	public List<winery> getAllWine() {
		return mySqlRepository.findAll();
		
	}

}
