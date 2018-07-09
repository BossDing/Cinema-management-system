package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import User.User;

public class UserDao {
	public User login(Connection con,User user){
		User resultUser=null;
		String sql="select * From users where use_name = ? and pwdcompare(?, use_password)=1";
		PreparedStatement pstmt;
		try {
			pstmt=con.prepareStatement(sql);
			//pstmt.setInt(1, user.getId());
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassWord());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				resultUser=new User();
				resultUser.setId(rs.getInt("use_id"));
				resultUser.setUserName(rs.getString("use_name"));
				resultUser.setPassWord(rs.getString("use_password"));
				resultUser.setUserLevel(rs.getInt("use_level"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return resultUser;
	}
}
