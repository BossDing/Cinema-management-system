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
import User.Play;
import User.Play;
import Vip.Discount;
import Vip.VIPA;
import Vip.VIPB;
import Vip.VIPC;
import Vip.VIPD;

public class PlayDao {
	Db db = new Db();
	Connection con = null;
	public int add(Play play){
		con = db.getCon();
		String sqla="select * from play where pla_id = ?";
		PreparedStatement pstmta = null;
		try {
			pstmta = con.prepareStatement(sqla);
			pstmta.setString(1, play.getPla_id());
			ResultSet rs = pstmta.executeQuery();
			if(rs.next()){
				return -2;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "insert into play values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int p = 0;
		try {
			int i =1;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(i++,play.getPla_id());
			pstmt.setString(i++,play.getHal_id());
			pstmt.setString(i++,play.getMov_id());
			pstmt.setString(i++,play.getPla_starttime());
			pstmt.setString(i++,play.getTic_price());
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
	
	public int update(Play play){
		con = db.getCon();
		String sql = "update play set hal_id = ?,mov_id = ?,pla_starttime = ?,tic_price=? where pla_id = ?";
		PreparedStatement pstmt = null;
		int p = 0;
		try {
			int i =1;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(i++,play.getHal_id());
			pstmt.setString(i++,play.getMov_id());
			pstmt.setString(i++,play.getPla_starttime());
			pstmt.setString(i++,play.getTic_price());
			pstmt.setString(i++,play.getPla_id());
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

	public int delete(Play play){
		con = db.getCon();
		String sql = "delete from play where pla_id = ?";
		PreparedStatement pstmt = null;
		int p = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, play.getPla_id());
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
	
	public List<Play> userList(String cus_id){
		List<Play>listPlay = new ArrayList<Play>();
		try {
			con = db.getCon();
			String sql = "EXEC pr_tickets "+cus_id;
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Play play = null;
			VipDao vipDao = new VipDao();
			String vip_id = vipDao.list(cus_id);
			Discount discount =null;
			if(vip_id.equals("初级")){
				discount = new VIPA();
			}else if(vip_id.equals("中级")){
				discount = new VIPB();
			}else if(vip_id.equals("高级")){
				discount = new VIPC();
			}else{
				discount = new VIPD();
			}
			while(rs.next()){
				play=new Play(discount);
				play.setHal_name(rs.getString("hal_name"));
				play.setHal_kind(rs.getString("hal_kind"));
				play.setMov_name(rs.getString("mov_name"));
				play.setPla_starttime(rs.getString("pla_starttime"));
				play.setMov_time(rs.getString("mov_time"));
				play.setTic_price(rs.getString("tic_price"));
				play.setHal_count(rs.getInt("hal_number"));
				listPlay.add(play);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPlay;
	}
	
	public List<Play> list(String str){
		List<Play>listPlay = new ArrayList<Play>();
		try {
			con = db.getCon();
			String sql = "select * from v_play";
			if(Bool.isNotEmpty(str)){
				sql+=" where mov_name like '%"+str+"%'";
			}
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Play play = null;
			while(rs.next()){
				play = new Play();
				play.setPla_id(rs.getString("pla_id"));
				play.setHal_name(rs.getString("hal_name"));
				play.setHal_kind(rs.getString("hal_kind"));
				play.setMov_name(rs.getString("mov_name"));
				play.setPla_starttime(rs.getString("pla_starttime"));
				play.setMov_time(rs.getString("mov_time"));
				play.setTic_price(rs.getString("tic_price"));
				play.setHal_count(rs.getInt("hal_count"));
				listPlay.add(play);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPlay;
	}
	
	public List<Play> list(String str, String str2){
		List<Play>listPlay = new ArrayList<Play>();
		try {
			con = db.getCon();
			String sql = "select * from v_play";
			if(Bool.isNotEmpty(str)){
				sql+=" where mov_name like '%"+str+"%'";
			}
			if(Bool.isNotEmpty(str2)){
				sql+=" where hal_name like '"+str2+"'";
			}
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Play play = null;
			while(rs.next()){
				play = new Play();
				play.setPla_id(rs.getString("pla_id"));
				play.setHal_name(rs.getString("hal_name"));
				play.setHal_kind(rs.getString("hal_kind"));
				play.setMov_name(rs.getString("mov_name"));
				play.setPla_starttime(rs.getString("pla_starttime"));
				play.setMov_time(rs.getString("mov_time"));
				play.setTic_price(rs.getString("tic_price"));
				listPlay.add(play);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPlay;
	}
	
}
