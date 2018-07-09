package User;

public class Hall {
	private String hal_id;
	private String hal_name;
	private int hal_rows;
	private int hal_seats;
	private int hal_count;
	private String hal_kind;
	private String hal_state;
	
	public String getHal_id() {
		return hal_id;
	}
	public void setHal_id(String halId) {
		hal_id = halId;
	}
	public String getHal_name() {
		return hal_name;
	}
	public void setHal_name(String halName) {
		hal_name = halName;
	}
	public int getHal_rows() {
		return hal_rows;
	}
	public void setHal_rows(int halRows) {
		hal_rows = halRows;
	}
	public int getHal_seats() {
		return hal_seats;
	}
	public void setHal_seats(int halSeats) {
		hal_seats = halSeats;
	}
	public int getHal_count() {
		return hal_count;
	}
	public void setHal_count(int halCount) {
		hal_count = halCount;
	}
	public String getHal_kind() {
		return hal_kind;
	}
	public void setHal_kind(String halKind) {
		hal_kind = halKind;
	}
	public String getHal_state() {
		return hal_state;
	}
	public void setHal_state(String halState) {
		hal_state = halState;
	}
	
	public Hall(String hal_id,String hal_name,int hal_count,String hal_kind,String hal_state) {
		super();
		this.hal_id=hal_id;
		this.hal_name=hal_name;
		this.hal_count=hal_count;
		this.hal_kind=hal_kind;
		this.hal_state=hal_state;
	}
	public Hall() {
		// TODO Auto-generated constructor stub
	}
	public Hall(String hal_id) {
		// TODO Auto-generated constructor stub
		super();
		this.hal_id = hal_id;
	}
	
}
