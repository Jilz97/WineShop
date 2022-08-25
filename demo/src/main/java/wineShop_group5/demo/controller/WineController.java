package wineShop_group5.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Wine> createWine(@Valid @RequestBody Wine wine) throws Exception{
		return new ResponseEntity<>(wineServices.createWine(wine),HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Wine> updateWine(@PathVariable int id, @RequestBody Wine wine) throws Exception{
		wineServices.updateWine(id, wine);
		return new ResponseEntity<Wine>(wine, HttpStatus.OK); 
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteWine(@PathVariable int id){
		wineServices.deleteWine(id);
		return new ResponseEntity<String>("It's been deleted, ", HttpStatus.OK);
	}
}
