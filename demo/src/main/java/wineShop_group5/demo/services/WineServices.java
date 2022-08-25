package wineShop_group5.demo.services;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	
	
	//Best Wine Rating Service
	public List<Wine> getBest(){
        List<Wine> wines = getAllWine();
        return wines.stream().filter((w)-> w.getRating()>=4.0)
                .sorted(Comparator.comparingInt(Wine::getNum_reviews))
                .limit(10)
                .collect(Collectors.toList());
    }
	
	//Get Expensive Wines TOP10
	public List<Wine> getExpensive(){
		List<Wine> wines = getAllWine();
		return wines.stream().sorted(Comparator.comparingDouble(Wine::getPrice).reversed()).limit(10).collect(Collectors.toList());
	}
	
	//Get Best bang rating-price (Opinion -> precio)
	
	public List<Wine> findByBang(Integer top) {
		Page<Wine> listOfWines = wineRepository.findAll(PageRequest.of(0,top,Sort.by("price").ascending().and(Sort.by("rating").descending())));
		return listOfWines.getContent();
	}
	
	
	
	
	//Get Best Vintage rated by years
	public Map<String, List<Wine>> getYearsWithBestRatedWines(){
        List<Wine> wines = getAllWine();
        return wines.stream()
                .sorted(
                        Comparator.comparingInt(Wine::getNum_reviews).reversed()
                        .thenComparingDouble(Wine::getRating).reversed())
                		.collect(Collectors.groupingBy(Wine::getYear));
    }
	 
	 
	
}
