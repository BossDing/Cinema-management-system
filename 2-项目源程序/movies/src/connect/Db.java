package connect;
import java.sql.DriverManager;
import java.sql.Connection;

public class Db {
	private String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=movie";
	private String dbUserName="sa";
	private String dbPassWord="123456";
	private String jdbcName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	Connection con =null;
	public Connection getCon(){
		try {
			Class.forName(jdbcName);
			con =DriverManager.getConnection(dbUrl,dbUserName,dbPassWord);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			return con;
		}
	}
	public void closeCon(Connection con){
		try {
			if(con!=null){
				con.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main (String[] args){
		Db db =new Db();
		db.getCon();
		System.out.println("Á´½Ó³É¹¦£¡");
	}
}
