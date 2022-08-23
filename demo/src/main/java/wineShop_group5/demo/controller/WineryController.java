package wineShop_group5.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import wineShop_group5.demo.model.Winery;
import wineShop_group5.demo.repository.MySqlRepository;

@RestController
public class WineryController {
	
	@Autowired
	MySqlRepository mySqlRepository;
	
	@GetMapping("/api/winery")
	public List<Winery> getAllWine() {
		return mySqlRepository.findAll();
		
	}
	@GetMapping("/api/winery/{identity}")
	public Winery getSingleWine(@PathVariable("identity")Integer id) {
	return mySqlRepository.findById(id).get();
	}

}
