package UserDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.util.StringUtils;

import connect.Db;
import Bool.Bool;
import User.Hall;
public class HallDao {
	Db db = new Db();
	Connection con = null;
	public int update(Hall hall){
		con = db.getCon();
		String sql = "update hall set hal_name = ?,hal_count = ? ,hal_kind = ?,hal_state = ? where hal_id = ?";
		PreparedStatement pstmt = null;
		int p = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,hall.getHal_name());
			pstmt.setInt(2,hall.getHal_count());
			pstmt.setString(3,hall.getHal_kind());
			pstmt.setString(4,hall.getHal_state());
			pstmt.setString(5,hall.getHal_id());
			p = pstmt.executeUpdate();
			return p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				db.closeCon(con);
				return p;
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
		
	}
	
	public List<Hall> list(String str){
		List<Hall>listHall = new ArrayList<Hall>();
		try {
			con = db.getCon();
			String sql = "select * from hall";
			if(Bool.isNotEmpty(str)){
				sql+=" where hal_name='"+str+"'";
			}
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Hall hall = null;
			while(rs.next()){
				hall = new Hall();
				hall.setHal_id(rs.getString("hal_id"));
				hall.setHal_name(rs.getString("hal_name"));
				hall.setHal_rows(rs.getInt("hal_rows"));
				hall.setHal_seats(rs.getInt("hal_seats"));
				hall.setHal_count(rs.getInt("hal_count"));
				hall.setHal_kind(rs.getString("hal_kind"));
				hall.setHal_state(rs.getString("hal_state"));
				listHall.add(hall);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listHall;
	}

	public List<Hall> list(String str,String str2){
		List<Hall>listHall = new ArrayList<Hall>();
		try {
			con = db.getCon();
			String sql = "select * from hall";
			if(Bool.isNotEmpty(str)){
				sql+=" where hal_kind like '%"+str+"%'";
			}
			if(Bool.isNotEmpty(str2)){
				sql+=" where hal_state like '"+str2+"'";
			}
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Hall hall = null;
			while(rs.next()){
				hall = new Hall();
				hall.setHal_id(rs.getString("hal_id"));
				hall.setHal_name(rs.getString("hal_name"));
				hall.setHal_rows(rs.getInt("hal_rows"));
				hall.setHal_seats(rs.getInt("hal_seats"));
				hall.setHal_count(rs.getInt("hal_count"));
				hall.setHal_kind(rs.getString("hal_kind"));
				hall.setHal_state(rs.getString("hal_state"));
				listHall.add(hall);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listHall;
	}

}
