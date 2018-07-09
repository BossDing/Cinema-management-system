package User;

public class Vip {
	private String id;
	private String price;
	private String level;
	private String discount;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public Vip(String id, String price,String level,String discount) {
		super();
		this.id = id;
		this.price = price;
		this.level = level;
		this.discount = discount;
	}
	public Vip() {
		// TODO Auto-generated constructor stub
	}
	public Vip(String id) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
	}
}	
