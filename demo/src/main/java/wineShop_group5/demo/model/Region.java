package wineShop_group5.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Region {
	
	@Id
	private int region_id;
	
	private String region_name;
	private String country_name;
	
	public Region() {
		
	}
	
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	
}
