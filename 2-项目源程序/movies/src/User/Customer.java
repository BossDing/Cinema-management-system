package User;

public class Customer {
	private String cus_id;
	private String cus_name;
	private String cus_sex;
	private String cus_phone;
	private String vip_discount;
	private String vip_id;
	private String cus_viptime;
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cusId) {
		cus_id = cusId;
	}
	public String getCus_name() {
		return cus_name;
	}
	public void setCus_name(String cusName) {
		cus_name = cusName;
	}
	public String getCus_sex() {
		return cus_sex;
	}
	public void setCus_sex(String cusSex) {
		cus_sex = cusSex;
	}
	public String getCus_phone() {
		return cus_phone;
	}
	public void setCus_phone(String cusPhone) {
		cus_phone = cusPhone;
	}
	public String getVip_discount() {
		return vip_discount;
	}
	public void setVip_discount(String vipDiscount) {
		vip_discount = vipDiscount;
	}
	public String getVip_id() {
		return vip_id;
	}
	public void setVip_id(String vipId) {
		vip_id = vipId;
	}
	public String getCus_viptime() {
		return cus_viptime;
	}
	public void setCus_viptime(String cusViptime) {
		cus_viptime = cusViptime;
	}
	public Customer(String cus_id, String cus_name,String cus_sex,String cus_phone) {
		super();
		this.cus_id=cus_id;
		this.cus_name = cus_name;
		this.cus_sex = cus_sex;
		this.cus_phone = cus_phone;
	}
	public Customer(String cus_id,String vip_discount,String vip_id,String cus_viptime,int i) {
		super();
		this.cus_id=cus_id;
		this.vip_discount = vip_discount;
		this.vip_id = vip_id;
		this.cus_viptime = cus_viptime;
		i=0;
	}
	public Customer() {
		super();
	}
	public Customer(String cusId) {
		// TODO Auto-generated constructor stub
		super();
		this.cus_id = cusId;
	}
}
