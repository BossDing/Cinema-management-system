package User;

public class Ticket {
	
	String tic_id = "";
	int hal_number = -1;
	String pla_id = "";
	String tic_code = "";
	String cus_id = "";
	
	public String getCus_id() {
		return cus_id;
	}
	public void setCus_id(String cusId) {
		cus_id = cusId;
	}
	public String getTic_id() {
		return tic_id;
	}
	public void setTic_id(String ticId) {
		tic_id = ticId;
	}
	public int getHal_number() {
		return hal_number;
	}
	public void setHal_number(int halNumber) {
		hal_number = halNumber;
	}
	public String getPla_id() {
		return pla_id;
	}
	public void setPla_id(String plaId) {
		pla_id = plaId;
	}
	public String getTic_code() {
		return tic_code;
	}
	public void setTic_code(String ticCode) {
		tic_code = ticCode;
	}
}
