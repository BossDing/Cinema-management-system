package User;

import Vip.Discount;

public class Play {
	private String pla_id;
	private String hal_id;
	private String mov_id;
	private String hal_name;
	private String hal_kind;
	private String mov_name;
	private String pla_starttime;
	private String mov_time;
	private String tic_price;
	private int hal_count;
	private Discount discount;
	
	public Play(Discount discount){
		this.discount = discount;
	}
	
	public Play(String plaId) {
		// TODO Auto-generated constructor stub
		super();
		this.pla_id=plaId;
	}
	public Play() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Play(String palId, String halId, String movId,
			String plaStarttime, String ticPrice) {
		// TODO Auto-generated constructor stub
		super();
		this.pla_id = palId;
		this.hal_id = halId;
		this.mov_id = movId;
		this.pla_starttime = plaStarttime;
		this.tic_price = ticPrice;
		
	}
	public String getHal_id() {
		return hal_id;
	}
	public void setHal_id(String halId) {
		hal_id = halId;
	}
	public String getMov_id() {
		return mov_id;
	}
	public void setMov_id(String movId) {
		mov_id = movId;
	}
	public String getPla_id() {
		return pla_id;
	}
	public void setPla_id(String plaId) {
		pla_id = plaId;
	}
	public String getHal_name() {
		return hal_name;
	}
	public void setHal_name(String halName) {
		hal_name = halName;
	}
	public String getHal_kind() {
		return hal_kind;
	}
	public void setHal_kind(String halKind) {
		hal_kind = halKind;
	}
	public String getMov_name() {
		return mov_name;
	}
	public void setMov_name(String movName) {
		mov_name = movName;
	}
	public String getPla_starttime() {
		return pla_starttime;
	}
	public void setPla_starttime(String plaStarttime) {
		pla_starttime = plaStarttime;
	}
	public String getMov_time() {
		return mov_time;
	}
	public void setMov_time(String movTime) {
		mov_time = movTime;
	}
	public String getTic_price() {
		return tic_price;
	}
	public void setTic_price(String ticPrice) {
		if(discount!=null){
			tic_price = discount.count(ticPrice);
		}else{
			tic_price = ticPrice;
		}
		
	}
	public int getHal_count() {
		return hal_count;
	}
	public void setHal_count(int halCount) {
		hal_count = halCount;
	}
	
	
	
}
