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
import User.Vip;

public class VipDao {
	Db db = new Db();
	Connection con = null;
	public int add(Vip vip){
		con = db.getCon();
		String sql = "insert into vip values(?,?,?,?)";
		PreparedStatement pstmt = null;
		int p = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,vip.getId());
			pstmt.setString(2,vip.getPrice());
			pstmt.setString(3,vip.getLevel());
			pstmt.setString(4,vip.getDiscount());
			p = pstmt.executeUpdate();
			return p;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.closeCon(con);
		}
		return p;
		
	}
	public int update(Vip vip){
		con = db.getCon();
		String sql = "update vip set vip_price = ?,vip_level = ?,vip_discount = ? where vip_id = ?";
		PreparedStatement pstmt = null;
		int p = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,vip.getPrice());
			pstmt.setString(2,vip.getLevel());
			pstmt.setString(3,vip.getDiscount());
			pstmt.setString(4,vip.getId());
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

	public int delete(Vip vip){
		con = db.getCon();
		String sql = "delete from vip where vip_id = ?";
		PreparedStatement pstmt = null;
		int p = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vip.getId());
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
	
	public String list(String cus_id){
		String vip_id = "";
		try {
			con = db.getCon();
			String sql = "select * from vip where cus_id = '"+cus_id+"'";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				vip_id=rs.getString("vip_id");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vip_id;
	}
	
	public List<Vip> list(){
		List<Vip>listVip = new ArrayList<Vip>();
		try {
			con = db.getCon();
			String sql = "select * from vip";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Vip vip = null;
			while(rs.next()){
				vip = new Vip();
				vip.setId(rs.getString("vip_id"));
				vip.setPrice(rs.getString("vip_price"));
				vip.setLevel(rs.getString("vip_level"));
				vip.setDiscount(rs.getString("vip_discount"));
				listVip.add(vip);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listVip;
	}
}
