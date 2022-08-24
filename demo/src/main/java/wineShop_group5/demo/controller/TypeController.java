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

import wineShop_group5.demo.model.Region;
import wineShop_group5.demo.model.Type;
import wineShop_group5.demo.repository.TypeRepository;

@RestController
@RequestMapping("/api/type")
public class TypeController {
	@Autowired
	TypeRepository TypeRepository;
	
	@GetMapping("/all")
	public List<Type> getAllType() {
		return TypeRepository.findAll();
		
	}
	@GetMapping("/{id}")
	public Type getTypeId(@PathVariable Integer id) throws Exception{
	return TypeRepository.findById(id).orElseThrow(()-> new Exception("Not found"));
	}

	@PostMapping("/create")
	public Type createType (@RequestBody Type type){
		TypeRepository.save(type);
		return type;
	}

	@PutMapping("/update/{id}")
	public Type updateType(@PathVariable int id, @RequestBody Type type) throws Exception{
		Type type1 = getTypeId(id);
		type1.setName(type.getName());
		return TypeRepository.save(type1);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteType(@PathVariable int id){
		TypeRepository.deleteById(id);
		return"Type" + id + "has been deleted";
	}
}