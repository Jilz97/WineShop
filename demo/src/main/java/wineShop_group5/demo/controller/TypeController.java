package wineShop_group5.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import wineShop_group5.demo.model.Type;
import wineShop_group5.demo.repository.TypeRepository;

@RestController
public class TypeController {
	@Autowired
	TypeRepository TypeRepository;
	
	@GetMapping("/get-all-type")
	public List<Type> getAllType() {
		return TypeRepository.findAll();
		
}
}