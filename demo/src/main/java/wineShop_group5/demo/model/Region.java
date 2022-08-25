package wineShop_group5.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "region")
public class Region {
	
	@Id
	@Column(name = "id")
	private int id;
	@NotNull(message= "It can't be null")
	@NotBlank(message="It must have a name")
	private String name;
	@NotNull(message= "It can't be null")
	private String country;
	
	public Region(){
	
	}

	public Region(int id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
}
