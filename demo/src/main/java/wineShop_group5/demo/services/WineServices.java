package wineShop_group5.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import wineShop_group5.demo.model.Wine;
import wineShop_group5.demo.repository.WineRepository;

@Service
public class WineServices {

	@Autowired
	WineRepository wineRepository;

	public List<Wine> getAllWine() {
		return wineRepository.findAll();
	}

	public Wine getWineId(int id) throws Exception {
		return wineRepository.findById(id).orElseThrow(() -> new Exception("Not found"));
	}

	public Wine createWine(Wine wine) {
		return wineRepository.save(wine);
	}

	public Wine updateWine(int id, Wine wine) throws Exception {
		Wine wine1 = getWineId(id);
		wine1.setName(wine.getName());
		wine1.setYear(wine.getYear());
		wine1.setRating(wine.getRating());
		wine1.setNum_reviews(wine.getNum_reviews());
		wine1.setBody(wine.getBody());
		wine1.setPrice(wine.getPrice());
		wine1.setAcidity(wine.getAcidity());
		return wineRepository.save(wine1);
		// return new ResponseEntity<>(wine,HttpStatus.OK);
	}

	public void deleteWine(int id) {
		wineRepository.deleteById(id);
	}
}
