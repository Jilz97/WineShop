package wineShop_group5.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wineShop_group5.demo.exception.NotFoundException;
import wineShop_group5.demo.model.Winery;
import wineShop_group5.demo.repository.MySqlRepository;
import wineShop_group5.demo.services.WineryService;

@RestController
@RequestMapping("/api/winery")
public class WineryController {

	@Autowired
	WineryService wineryService;
	
	

	@GetMapping("/all")
	public List<Winery> getAllWinery() {
		return wineryService.getAll();

	}

	// get wines by id
	@GetMapping("/{identity}")
	public Winery getById(@PathVariable("identity") Long id) throws Exception {
		return wineryService.getById(id);
	}

	// Post create wine

	@PostMapping("/create")
	public ResponseEntity<Winery> save(@RequestBody Winery winery) {
		return new ResponseEntity<>(wineryService.save(winery), null, HttpStatus.CREATED);
	}

	// Put Mapping

	@PutMapping("/put/{identity}")
	public ResponseEntity<Winery> update(@PathVariable("identity") Long id, @RequestBody Winery winery) {
		winery.setId(id);
		return new ResponseEntity<>(wineryService.update(winery), null, 204);
	}

	// Delete
	@DeleteMapping("/delete/{identity}")
	public ResponseEntity<String> delete(@PathVariable("identity") Long id) {
		wineryService.delete(id);
		return new ResponseEntity<>("Winery was deleted", null, 204);

	}
	
}


