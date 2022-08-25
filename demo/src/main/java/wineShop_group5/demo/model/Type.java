package wineShop_group5.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity

@Table(name= "type")

public class Type {
	
	@Id
	private int id;
	@NotNull(message= "It can't be null")
	@NotBlank(message="It must have a name")
	private String name;
	
	public Type() {
		
	}

	public Type(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
