 package Chat;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart {
	ChartPanel frame1;
	public PieChart(){
		  DefaultPieDataset data = getDataSet();
	      JFreeChart chart = ChartFactory.createPieChart3D("Ʊ��ռ��",data,true,false,false);
	    //���ðٷֱ�
	      PiePlot pieplot = (PiePlot) chart.getPlot();
	      DecimalFormat df = new DecimalFormat("0.00%");//���һ��DecimalFormat������Ҫ������С������
	      NumberFormat nf = NumberFormat.getNumberInstance();//���һ��NumberFormat����
	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//���StandardPieSectionLabelGenerator����
	      pieplot.setLabelGenerator(sp1);//���ñ�ͼ��ʾ�ٷֱ�
	  
	  //û�����ݵ�ʱ����ʾ������
	      pieplot.setNoDataMessage("��������ʾ");
	      pieplot.setCircular(false);
	      pieplot.setLabelGap(0.02D);
	  
	      pieplot.setIgnoreNullValues(true);//���ò���ʾ��ֵ
	      pieplot.setIgnoreZeroValues(true);//���ò���ʾ��ֵ
	     frame1=new ChartPanel (chart,true);
	      chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
	      PiePlot piePlot= (PiePlot) chart.getPlot();//��ȡͼ���������
	      piePlot.setLabelFont(new Font("����",Font.BOLD,10));//�������
	      chart.getLegend().setItemFont(new Font("����",Font.BOLD,10));
	}
    private static DefaultPieDataset getDataSet() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Connection conn=null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=movie";
        try{  //����JDBC-ODBC����������
            Class.forName(driver);
            try {
                conn = DriverManager.getConnection(url,"sa","123456"); //��������
                Statement statement = conn.createStatement();
                String sql = "select movie.mov_id,mov_name,convert(float,play.tic_price)*COUNT(ticket.tic_id) " +
                		" from movie,play,ticket" +
                		" where movie.mov_id=play.mov_id and play.pla_id=ticket.pla_id " +
                		" group by movie.mov_id,mov_name,play.tic_price";
                ResultSet rs = statement.executeQuery(sql);

                while(rs.next()){
                    //int id = rs.getInt(1);
                	dataset.setValue(rs.getString(2), rs.getDouble(3));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dataset;
}
    public ChartPanel getChartPanel(){
    	return frame1;
    	
    }
}
