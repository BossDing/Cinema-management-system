package User;

public class User {
	private int id;
	private String userName;
	private String passWord;
	private int userLevel;
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getPassWord(){
		return passWord;
	}
	public void setPassWord(String passWord){
		this.passWord=passWord;
	}
}
