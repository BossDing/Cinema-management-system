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
                             "电影票房", // 图表标题  
                            "电影名称", // 目录轴的显示标签  
                            "票房(万)", // 数值轴的显示标签  
                            dataset, // 数据集  
                            PlotOrientation.VERTICAL, // 图表方向：水平、垂直  
                            true,           // 是否显示图例(对于简单的柱状图必须是false)  
                            false,          // 是否生成工具  
                            false           // 是否生成URL链接  
                            );  
          
        //从这里开始  
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象  
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表  
         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题  
         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题  
         ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状  
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
            
          //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题  
            
         frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame,可以直接生成一个独立的Frame  
    }  
    
    private static CategoryDataset getDataSet() {  
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
        Connection conn=null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=movie";
        try{  //加载JDBC-ODBC桥驱动程序
            Class.forName(driver);
            try {
                conn = DriverManager.getConnection(url,"sa","123456"); //建立连接
                Statement statement = conn.createStatement();
                String sql = "SELECT movie.mov_id, mov_name,convert(float,play.tic_price) * COUNT(ticket.tic_id) FROM movie, play, ticket" +
                		" WHERE movie.mov_id = play.mov_id AND play.pla_id = ticket.pla_id " +
                		" GROUP BY movie.mov_id, mov_name, play.tic_price";
                ResultSet rs = statement.executeQuery(sql);

                while(rs.next()){
                    //int id = rs.getInt(1);
                    dataset.addValue(rs.getInt(3),"电影名称",rs.getString(2));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataset;

//        dataset.addValue(100, "电影名称", "苹果");  
//        dataset.addValue(100,"电影名称", "苹果");  
//        dataset.addValue(100, "电影名称", "苹果");  
//        dataset.addValue(200, "电影名称", "梨子");  
//        dataset.addValue(200, "电影名称", "梨子");  
//        dataset.addValue(200, "电影名称", "梨子");  
//        return dataset;  
	}  
	public ChartPanel getChartPanel(){  
	return frame1;  
	}  
}
