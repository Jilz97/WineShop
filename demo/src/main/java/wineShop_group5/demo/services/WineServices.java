package wineShop_group5.demo.services;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import wineShop_group5.demo.model.Wine;
import wineShop_group5.demo.repository.WineRepository;

@Service
public class WineServices {
	
	@Autowired
	WineRepository wineRepository;
	
	
	public List<Wine> getAllWine() {
		return wineRepository.findAll();
	}
	
	public Wine getWineId(int id) throws Exception{
		return wineRepository.findById(id).orElseThrow(()-> new Exception("Not found"));
	}
	public Wine createWine(Wine wine){
		return wineRepository.save(wine);
	}
	public Wine updateWine(int id,Wine wine) throws Exception{
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
	
	public void deleteWine( int id){
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
