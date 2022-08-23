package wineShop_group5.demo.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import wineShop_group5.demo.repository.TypeRepository;

@Entity
@Table(name= "Type")
public class Type {
	
	@Id
	private int id;
	
	private String name;
	
	public Type() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	
}
}
