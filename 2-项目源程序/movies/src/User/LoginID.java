package User;

public class LoginID {

	private static LoginID instance = new LoginID();
	private LoginID(){}
	
	public static LoginID getInstance() {
		return instance;
	}

	public static String CusId = "000";
}
