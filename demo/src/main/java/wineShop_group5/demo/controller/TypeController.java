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
import wineShop_group5.demo.service.TypeService;

@RestController
@RequestMapping("/api/type")
public class TypeController {
	@Autowired
	TypeService typeService;
	
	@GetMapping("/all")
	public List<Type> getAllType() {
		return typeService.getAllType();
				
	}
	@GetMapping("/{id}")
	public Type getTypeId(@PathVariable Integer id) throws Exception{
	return typeService.getTypeId(id);
			//.orElseThrow(()-> new Exception("Not found"));
	}

	@PostMapping("/create")
	public Type createType (@RequestBody Type type){
		typeService.createType(type);
		return type;
	}

	@PutMapping("/update/{id}")
	public Type updateType(@PathVariable int id, @RequestBody Type type) throws Exception{
		return typeService.updateType(id, type);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteType(@PathVariable int id){
		typeService.deleteType(id);
		return "Type" + id + "has been deleted";
	}
	
}