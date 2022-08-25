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

import wineShop_group5.demo.model.Type;
import wineShop_group5.demo.services.*;

@RestController
@RequestMapping("/api/type")
public class TypeController {
	@Autowired
	TypeServices typeServices;
	
	@GetMapping("/all")
	public List<Type> getAllType() {
		return typeServices.getAllType();
				
	}
	@GetMapping("/{id}")
	public Type getTypeId(@PathVariable Integer id) throws Exception{
	return typeServices.getTypeId(id);
			//.orElseThrow(()-> new Exception("Not found"));
	}

	@PostMapping("/create")
	public Type createType (@RequestBody Type type){
		typeServices.createType(type);
		return type;
	}

	@PutMapping("/update/{id}")
	public Type updateType(@PathVariable int id, @RequestBody Type type) throws Exception{
		return typeServices.updateType(id, type);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteType(@PathVariable int id){
		typeServices.deleteType(id);
		return "Type" + id + "has been deleted";
	}
	
}