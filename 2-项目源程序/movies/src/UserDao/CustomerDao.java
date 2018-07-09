package UserDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.sun.xml.internal.ws.util.StringUtils;


import connect.Db;
import Bool.Bool;
import User.Customer;
import User.Play;
import User.User;
public class CustomerDao {
	Db db = new Db();
	Connection con = null;
	public String getCus_id(int id){
		String cus_id = "";
		try {
			con = db.getCon();
			String sql="select cus_id From customer where use_id = "+id;
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				cus_id=rs.getString("cus_id");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return cus_id;
	}
	public int add(Customer customer,String type){
//		con = db.getCon();
//		String sqla="select * from customer where cus_id = ?";
//		PreparedStatement pstmta = null;
//		try {
//			pstmta = con.prepareStatement(sqla);
//			pstmta.setString(1, customer.getCus_id());
//			ResultSet rs = pstmta.executeQuery();
//			if(rs.next()){
//				return -2;
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String sql="";
		if(type=="customer"){
		  sql = "insert into customer values(?,?,?,?)";
		  PreparedStatement pstmt = null;
		  int p = 1;
		  try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,customer.getCus_id());
			pstmt.setString(2,customer.getCus_name());
			pstmt.setString(3,customer.getCus_sex());
			pstmt.setString(4,customer.getCus_phone());
			p = pstmt.executeUpdate();
			return 1;
		  } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
		}
		if(type=="vip"){
			  sql = "insert into vip values(?,?,?,?)";
			  PreparedStatement pstmt = null;
			  int p = 1;
			  try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,customer.getCus_id());
				pstmt.setString(2,"0");
				pstmt.setString(3,customer.getVip_id());
				pstmt.setString(4,customer.getCus_viptime());
				p = pstmt.executeUpdate();
				return p;
			  } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;
			}
		return 1;
		
	}
	public int update(Customer customer,String type){
		con = db.getCon();
		String sql="";
		if(type=="customer"){
			sql = "update customer set cus_name = ?,cus_sex = ? ,cus_phone= ? where cus_id = ?";
			PreparedStatement pstmt = null;
			int p = 0;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,customer.getCus_name());
				pstmt.setString(2,customer.getCus_sex());
				pstmt.setString(3,customer.getCus_phone());
				pstmt.setString(4,customer.getCus_id());
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
		if(type=="vip"){
			sql = "update vip set vip_discount = ?,vip_id= ? ,cus_viptime = ? where cus_id = ?";
			PreparedStatement pstmt = null;
			int p = 0;
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,"0");
				pstmt.setString(2,customer.getVip_id());
				pstmt.setString(3,customer.getCus_viptime());
				pstmt.setString(4,customer.getCus_id());
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
		return 0;
	}

	public int delete(Customer customer){
		con = db.getCon();
		String sql = "delete from customer where cus_id = ?";
		PreparedStatement pstmt = null;
		int p = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getCus_id());
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
	public List<Customer> list(String str,String type){
		if(type.equals("vip_id")){
			List<Customer>listCustomer = new ArrayList<Customer>();
			try {
				con = db.getCon();
				String sql = "select * from v_vip";
				if(Bool.isNotEmpty(str)){
					sql+=" where vip_id like '%"+str+"%'";
				}
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				Customer customer = null;
				while(rs.next()){
					customer = new Customer();
					customer.setCus_id(rs.getString("cus_id"));
					customer.setCus_name(rs.getString("cus_name"));
					customer.setCus_sex(rs.getString("cus_sex"));
					customer.setCus_phone(rs.getString("cus_phone"));
					customer.setVip_discount(rs.getString("vip_discount"));
					customer.setVip_id(rs.getString("vip_id"));
					customer.setCus_viptime(rs.getString("cus_viptime"));
					listCustomer.add(customer);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listCustomer;
		}
		if(type.equals("cus_name")){
			List<Customer>listCustomer = new ArrayList<Customer>();
			try {
				con = db.getCon();
				String sql = "select * from v_vip";
				if(Bool.isNotEmpty(str)){
					sql+=" where cus_name like '%"+str+"%'";
				}
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				Customer customer = null;
				while(rs.next()){
					customer = new Customer();
					customer.setCus_id(rs.getString("cus_id"));
					customer.setCus_name(rs.getString("cus_name"));
					customer.setCus_sex(rs.getString("cus_sex"));
					customer.setCus_phone(rs.getString("cus_phone"));
					customer.setVip_discount(rs.getString("vip_discount"));
					customer.setVip_id(rs.getString("vip_id"));
					customer.setCus_viptime(rs.getString("cus_viptime"));
					listCustomer.add(customer);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return listCustomer;
		}
		return null;
		
	}	
	

}
