package wineShop_group5.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import wineShop_group5.demo.model.Type;
import wineShop_group5.demo.repository.TypeRepository;

@Service
public class TypeServices {
	@Autowired
	TypeRepository TypeRepository;
	
	public List<Type> getAllType() {
		return TypeRepository.findAll();
	}
	
	public Type getTypeId(int id) throws Exception{
	return TypeRepository.findById(id).orElseThrow(()-> new Exception("Not found"));
	}

	public Type createType (Type type){
		TypeRepository.save(type);
		return type;
	}

	public Type updateType(int id, Type type) throws Exception{
		Type type1 = getTypeId(id);
		type1.setName(type.getName());
		return TypeRepository.save(type1);
	}

	public String deleteType(int id){
		TypeRepository.deleteById(id);
		return "Type" + id + "has been deleted";
	}

	public Object postType(Type type) {
		// TODO Auto-generated method stub
		return null;
	}
	
}