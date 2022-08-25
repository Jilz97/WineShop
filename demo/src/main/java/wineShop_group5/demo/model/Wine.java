package wineShop_group5.demo.model;

import java.util.Objects;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "wine")
public class Wine {
	@Id
	private int id;
	
	@NotNull(message = "Can't be null")
	@NotBlank(message="Must have a name")
	private String name;

	@NotNull(message = "Can't be null")
	@Range(min = 1990, max = 2022)
	private String year;

	@NotNull(message = "Can't be null")
	@Range(min = 0, max = 5,  message = "Must be between 1 to 5")
	private float rating;

	@NotNull(message = "Can't be null")
	@Min(value = 0, message = "Must be positive Number")
	@Column(name = "num_reviews")
	private int num_reviews;

	@NotNull(message = "Can't be null")
	@Min(value = 0, message = "Must be positive Number")
	@Column(name = "price")
	private float price;

	@NotNull(message = "Can't be null")
	@Range(min = 1, max = 5, message = "Must be between 1 to 5")
	@Column(name = "body")
	private String body;

	@NotNull(message = "Can't be null")
	@Range(min = 1, max = 5)
	@Column(name = "acidity")
	private String acidity;

	@ManyToOne
	@NotNull(message = "Can't be null")
	@JoinColumn(name = "winery_id")
	Winery winery;

	@ManyToOne
	@NotNull(message = "Can't be null")
	@JoinColumn(name = "type_id")
	Type type;

	@ManyToOne
	@NotNull(message = "Can't be null")
	@JoinColumn(name = "region_id")
	Region region;

	public Wine() {

	}

	public Wine(int id, String name, String year, float rating, int num_reviews, float price, String body,
			String acidity, Winery winery, Type type, Region region) {
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAcidity() {
		return acidity;
	}

	public void setAcidity(String acidity) {
		this.acidity = acidity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wine other = (Wine) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Wine [id=" + id + ", name=" + name + ", year=" + year + ", rating=" + rating + ", num_reviews="
				+ num_reviews + ", price=" + price + ", body=" + body + ", acidity=" + acidity + ", winery=" + winery
				+ ", type=" + type + ", region=" + region + "]";
	}

}
