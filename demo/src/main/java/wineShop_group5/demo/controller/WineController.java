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

	@PostMapping("/create")
	public Wine createWine(@RequestBody Wine wine){
		wineRepository.save(wine);
		return wine;
	}

	@PutMapping("/update/{id}")
	public Wine updateWine(@PathVariable int id, @RequestBody Wine wine) throws Exception{
		Wine wine1 = getWineId(id);
		wine1.setName(wine.getName());
		wine1.setYear(wine.getYear());
		wine1.setRating(wine.getRating());
		wine1.setNum_reviews(wine.getNum_reviews());
		wine1.setBody(wine.getBody());
		wine1.setPrice(wine.getPrice());
		wine1.setAcidity(wine.getAcidity());
		
		return wineRepository.save(wine1);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteWine(@PathVariable int id){
		wineRepository.deleteById(id);
		return "Wine " + id + " has been deleted";
	}
}
