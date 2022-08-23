package wineShop_group5.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wineShop_group5.demo.model.Wine;
import wineShop_group5.demo.repository.WineRepository;

@RestController
@RequestMapping("/api/wine")
public class WineController {

	@Autowired
	WineRepository wineRepository;

	@GetMapping("/all")
	public List<Wine> getAllWine() {
		return wineRepository.findAll();

	}
	@GetMapping("/{id}")
	public Wine getWineId(@PathVariable Integer id) throws Exception{
		return wineRepository.findById(id).orElseThrow(()-> new Exception("Not found"));
	}
}
