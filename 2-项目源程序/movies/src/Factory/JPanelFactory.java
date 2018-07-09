package Factory;


import javax.swing.JPanel;

import Customer.CustomerMain;
import Customer.TicketSee;
import Customer.UserCenter;
import Hall.HallMain;
import Movie.MovieAdd;
import Movie.MovieMain;
import Movie.MovieModify;
import Play.PlayMain;
import Sale.SaleMain;
import Sale.SeatHall;
import Statistics.BoxOffice;
import Statistics.DailySales;
import Statistics.ReportOutput;
import Vip.VipAdd;
import Vip.VipMain;
import Vip.VipModify;

public class JPanelFactory {

	public static JPanel GetJPanel(String str){
		if(str.equals("SaleMain")){
			return new SaleMain();
		}else if (str.equals("TicketSee")){
			return new TicketSee();
		}else if (str.equals("HallMain")) {
			return new HallMain();
		}else if (str.equals("CustomerMain")){
			return new CustomerMain();
		}else if (str.equals("UserCenter")) {
			return new UserCenter();
		}else if (str.equals("MovieAdd")) {
			return new MovieAdd();
		}else if (str.equals("MovieMain")) {
			return new MovieMain();
		}else if (str.equals("PlayMain")) {
			return new PlayMain();
		}else if (str.equals("SaleMain")) {
			return new SaleMain();
		}else if (str.equals("BoxOffice")) {
			return new BoxOffice();
		}else if (str.equals("DailySales")) {
			return new DailySales();
		}else if (str.equals("ReportOutput")) {
			return new ReportOutput();
		}else if (str.equals("VipAdd")) {
			return new VipAdd();
		}else if (str.equals("VipModify")) {
			return new VipModify();
		}else if (str.equals("VipMain")) {
			return new VipMain();
		}
		return new JPanel();
	}
}
