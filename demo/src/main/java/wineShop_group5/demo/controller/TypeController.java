package wineShop_group5.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import wineShop_group5.demo.model.Region;
import wineShop_group5.demo.model.Type;
import wineShop_group5.demo.repository.TypeRepository;

@RestController
public class TypeController {
	@Autowired
	TypeRepository TypeRepository;
	
	@GetMapping("/api/type")
	public List<Type> getAllType() {
		return TypeRepository.findAll();
		
	}
	@GetMapping("/api/type/{id}")
	public Type getTypeId(@PathVariable Integer id) throws Exception{
	return TypeRepository.findById(id).orElseThrow(()-> new Exception("Not found"));
	}

}