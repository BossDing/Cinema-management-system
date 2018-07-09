package UserDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.util.StringUtils;


import connect.Db;
import Bool.Bool;
import User.Movie;
public class MovieDao {
	Db db = new Db();
	Connection con = null;
	public int add(Movie movie){
		con = db.getCon();
		String sqla="select * from movie where mov_id = ?";
		PreparedStatement pstmta = null;
		try {
			pstmta = con.prepareStatement(sqla);
			pstmta.setString(1, movie.getId());
			ResultSet rs = pstmta.executeQuery();
			if(rs.next()){
				return -2;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "insert into movie values(?,'0',?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int p = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,movie.getId());
			pstmt.setString(2,movie.getName());
			pstmt.setString(3,movie.getIntroduce());
			pstmt.setString(4,movie.getIndate());
			pstmt.setString(5,movie.getOutdate());
			pstmt.setString(6,movie.getTime());
			pstmt.setString(7,movie.getDirector());
			pstmt.setString(8,movie.getStar());
			pstmt.setString(9,movie.getStyle());
			pstmt.setString(10,movie.getKind());
			
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
	public int update(Movie movie){
		con = db.getCon();
		String sql = "update movie set mov_name = ?,mov_introduce = ?,mov_indate=?,mov_outdate=?,mov_time=?,mov_director=?,mov_star=?,mov_style=?,mov_kind=? where mov_id = ?";
		PreparedStatement pstmt = null;
		int p = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,movie.getName());
			pstmt.setString(2,movie.getIntroduce());
			pstmt.setString(3,movie.getIndate());
			pstmt.setString(4,movie.getOutdate());
			pstmt.setString(5,movie.getTime());
			pstmt.setString(6,movie.getDirector());
			pstmt.setString(7,movie.getStar());
			pstmt.setString(8,movie.getStyle());
			pstmt.setString(9,movie.getKind());
			pstmt.setString(10,movie.getId());
			
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

	public int delete(Movie movie){
		con = db.getCon();
		String sql = "delete from movie where mov_id = ?";
		
		PreparedStatement pstmt = null;
		int p = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movie.getId());
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
	public List<Movie> list(String str){
		List<Movie>listMovie = new ArrayList<Movie>();
		try {
			con = db.getCon();
			String sql = "select * from movie";
			if(Bool.isNotEmpty(str)){
				sql+=" where mov_name like '%"+str+"%'";
			}
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Movie movie = null;
			while(rs.next()){
				movie = new Movie();
				movie.setId(rs.getString("mov_id"));
				movie.setName(rs.getString("mov_name"));
				movie.setIntroduce(rs.getString("mov_introduce"));
				movie.setIndate(rs.getString("mov_indate"));
				movie.setOutdate(rs.getString("mov_outdate"));
				movie.setTime(rs.getString("mov_time"));
				movie.setDirector(rs.getString("mov_director"));
				movie.setStar(rs.getString("mov_star"));
				movie.setStyle(rs.getString("mov_style"));
				movie.setKind(rs.getString("mov_kind"));
				listMovie.add(movie);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMovie;
	}
}
