package wineShop_group5.demo.model;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="wine")
public class Wine {
	@Id
    private int id;

    private String name;
    private int year;
    private float rating;
    private int num_reviews;
    private float price;
    private int body;
    private int acidity;
    
    @ManyToOne
    @JoinColumn(name="winery_id")
    Winery winery;
   
    @ManyToOne
    @JoinColumn(name="type_id")
    Type type;
    
    @ManyToOne
    @JoinColumn(name="region_id")
    Region region;
    
   
    public Wine() {
    	
    }
    
	
	public Wine(int id, String name, int year, float rating, int num_reviews, float price, int body, int acidity,
			Winery winery, Type type, Region region) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.rating = rating;
		this.num_reviews = num_reviews;
		this.price = price;
		this.body = body;
		this.acidity = acidity;
		this.winery = winery;
		this.type = type;
		this.region = region;
	}


	public Winery getWinery() {
		return winery;
	}

	public void setWinery(Winery winery) {
		this.winery = winery;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getNum_reviews() {
		return num_reviews;
	}

	public void setNum_reviews(int num_reviews) {
		this.num_reviews = num_reviews;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getBody() {
		return body;
	}

	public void setBody(int body) {
		this.body = body;
	}

	public int getAcidity() {
		return acidity;
	}

	public void setAcidity(int acidity) {
		this.acidity = acidity;
	}
    
}
