package Chat;
import java.awt.Font;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis;  
import org.jfree.chart.axis.ValueAxis;  
import org.jfree.chart.plot.CategoryPlot;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  

import User.User;
import User.Vip;
import connect.Db;
public class BarChart {
	ChartPanel frame1;  
    public  BarChart(){  
        CategoryDataset dataset = getDataSet();  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                             "��ӰƱ��", // ͼ�����  
                            "��Ӱ����", // Ŀ¼�����ʾ��ǩ  
                            "Ʊ��(��)", // ��ֵ�����ʾ��ǩ  
                            dataset, // ���ݼ�  
                            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ  
                            true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)  
                            false,          // �Ƿ����ɹ���  
                            false           // �Ƿ�����URL����  
                            );  
          
        //�����￪ʼ  
        CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������  
        CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�  
         domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����  
         domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����  
         ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״  
         rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));  
          chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));  
          chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������  
            
          //�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������  
            
         frame1=new ChartPanel(chart,true);        //����Ҳ������chartFrame,����ֱ������һ��������Frame  
    }  
    
    private static CategoryDataset getDataSet() {  
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
        Connection conn=null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=movie";
        try{  //����JDBC-ODBC����������
            Class.forName(driver);
            try {
                conn = DriverManager.getConnection(url,"sa","123456"); //��������
                Statement statement = conn.createStatement();
                String sql = "SELECT movie.mov_id, mov_name,convert(float,play.tic_price) * COUNT(ticket.tic_id) FROM movie, play, ticket" +
                		" WHERE movie.mov_id = play.mov_id AND play.pla_id = ticket.pla_id " +
                		" GROUP BY movie.mov_id, mov_name, play.tic_price";
                ResultSet rs = statement.executeQuery(sql);

                while(rs.next()){
                    //int id = rs.getInt(1);
                    dataset.addValue(rs.getInt(3),"��Ӱ����",rs.getString(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataset;

//        dataset.addValue(100, "��Ӱ����", "ƻ��");  
//        dataset.addValue(100,"��Ӱ����", "ƻ��");  
//        dataset.addValue(100, "��Ӱ����", "ƻ��");  
//        dataset.addValue(200, "��Ӱ����", "����");  
//        dataset.addValue(200, "��Ӱ����", "����");  
//        dataset.addValue(200, "��Ӱ����", "����");  
//        return dataset;  
	}  
	public ChartPanel getChartPanel(){  
	return frame1;  
	}  
}
