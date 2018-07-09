package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Bool.Bool;
import User.Play;
import User.Ticket;

import connect.Db;

public class TicketDao {
	Db db = new Db();
	Connection con = null;
	
	public int add(Ticket ticket){
		con = db.getCon();
		String sql = "insert into ticket values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int p = 0;
		try {
			int i =1;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(i++,ticket.getTic_id());
			pstmt.setInt(i++,ticket.getHal_number());
			pstmt.setString(i++,ticket.getPla_id());
			pstmt.setString(i++,ticket.getTic_code());
			pstmt.setString(i++,ticket.getCus_id());
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
	
	public List<Ticket> list(String str){
		List<Ticket>listTickets = new ArrayList<Ticket>();
		Ticket ticket = null;
		try {
			con = db.getCon();
			String sql = "select * from ticket";
			if(Bool.isNotEmpty(str)){
				sql+=" where pla_id='"+str+"'";
			}
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				ticket = new Ticket();
				int i =1;
				ticket.setTic_id(rs.getString(i++));
				ticket.setHal_number(Integer.parseInt(rs.getString(i++)));
				ticket.setPla_id(rs.getString(i++));
				ticket.setTic_code(rs.getString(i++));
				listTickets.add(ticket);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listTickets;
	}
	
	public List<Ticket> user_list(String cus_id){
		List<Ticket>listTickets = new ArrayList<Ticket>();
		Ticket ticket = null;
		try {
			con = db.getCon();
			String sql = "select * from ticket";
			if(Bool.isNotEmpty(cus_id)){
				sql+=" where cus_id='"+cus_id+"'";
			}
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				ticket = new Ticket();
				int i =1;
				ticket.setTic_id(rs.getString(i++));
				ticket.setHal_number(Integer.parseInt(rs.getString(i++)));
				ticket.setPla_id(rs.getString(i++));
				ticket.setTic_code(rs.getString(i++));
				listTickets.add(ticket);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listTickets;
	}
}
