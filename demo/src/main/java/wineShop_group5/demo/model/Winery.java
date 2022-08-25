package wineShop_group5.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="winery")
public class Winery {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotNull(message= "It can't be null")
	@NotBlank(message="It must have a name")
	private String name;
	
	public Winery() {
		
	}

	public Winery(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Winery(String name){
		this.name = name;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
