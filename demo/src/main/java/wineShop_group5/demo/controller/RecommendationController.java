package wineShop_group5.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wineShop_group5.demo.model.Wine;
import wineShop_group5.demo.services.WineServices;

@RestController
@RequestMapping("/api/recommend")
public class RecommendationController {

	@Autowired
	WineServices wineServices;

	// Api Recommend Best Top 10 Vines by Rating
	@GetMapping("/best")
	List<Wine> getBest(@RequestParam("top10") Optional<Integer> top10) {
		return top10.map(integer -> wineServices.getBest().stream().limit(10).collect(Collectors.toList()))
				.orElseGet(() -> wineServices.getBest());
	}

	// API Top 10 Expensive Wines
	@GetMapping("/expensive")
	List<Wine> getExpensive(@RequestParam("top10") Optional<Integer> top10) {
		return top10.map(integer -> wineServices.getExpensive().stream().limit(integer).collect(Collectors.toList()))
				.orElseGet(() -> wineServices.getExpensive());

	}

	// API Bang (Ratings - Price)

	/*falta
	 * Bang Api
	 */
	
	
	// API Vintatge (Best Rated - Years)

	@GetMapping("/vintage")
	Map<String, List<Wine>> getVintage(@RequestParam("top10") Optional<Integer> top10) {
		return top10
				.map(integer -> wineServices.getYearsWithBestRatedWines().entrySet().stream().limit(integer)
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
				.orElseGet(() -> wineServices.getYearsWithBestRatedWines());

	}

}
