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

import wineShop_group5.demo.model.Wine;
import wineShop_group5.demo.repository.WineRepository;
import wineShop_group5.demo.services.WineServices;

@RestController
@RequestMapping("/api/wine")
public class WineController {

	@Autowired
	WineServices wineServices;

	@GetMapping("/all")
	public List<Wine> getAllWine() {
		return wineServices.getAllWine();
	}
	@GetMapping("/{id}")
	public Wine getWineId(@PathVariable Integer id) throws Exception{
		 return wineServices.getWineId(id);
	}

	@PostMapping("/create")
	public Wine createWine(@RequestBody Wine wine){
		return wineServices.createWine(wine);
	}

	@PutMapping("/update/{id}")
	public Wine updateWine(@PathVariable int id, @RequestBody Wine wine) throws Exception{
		return wineServices.updateWine(id, wine);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteWine(@PathVariable int id){
		wineServices.deleteWine(id);
		return "Wine " + id + " has been deleted";
	}
}
