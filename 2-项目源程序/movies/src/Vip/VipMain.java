/*
 * VipMain.java
 *
 * Created on __DATE__, __TIME__
 */

package Vip;

import java.awt.Dimension;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import UserDao.VipDao;
import Bool.Bool;
import User.Vip;

/**
 *
 * @author  __USER__
 */
public class VipMain extends javax.swing.JPanel {
	VipDao vipDao = new VipDao();

	/** Creates new form VipMain */
	public VipMain() {
		initComponents();
		fillTable(new Vip());
		resetValue();
		this.jTextField1.setText("");
		this.jTextField4.setText("");
		this.jTextField2.setText("");
		this.jTextField3.setText("");
	}

	private void fillTable(Vip vip) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
		dtm.setRowCount(0);
		List<Vip> listVip = vipDao.list();
		if (listVip.size() != 0) {
			for (int i = 0; i < listVip.size(); i++) {
				vip = listVip.get(i);
				Vector v = new Vector();
				v.add(vip.getId());
				v.add(vip.getPrice());
				v.add(vip.getLevel());
				v.add(vip.getDiscount());
				dtm.addRow(v);
			}
		}
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLayeredPane1 = new javax.swing.JLayeredPane();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton3 = new javax.swing.JButton();
		jTextField3 = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jTextField5 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jTextField6 = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jTextField7 = new javax.swing.JTextField();
		jLabel9 = new javax.swing.JLabel();
		jTextField8 = new javax.swing.JTextField();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jLabel10 = new javax.swing.JLabel();

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "编号",
						"单价", "级别", "折扣" }));
		jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jTable1MousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(jTable1);

		jScrollPane1.setBounds(0, 50, 600, 180);
		jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton3.setText("\u5220\u9664");
		jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton3MouseClicked(evt);
			}
		});
		jButton3.setBounds(507, 10, 80, 25);
		jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField3.setText("jTextField3");
		jTextField3.setBounds(200, 330, 70, 23);
		jLayeredPane1.add(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel4.setText("\u6298    \u6263\uff1a");
		jLabel4.setBounds(150, 330, 52, 17);
		jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField2.setText("jTextField2");
		jTextField2.setBounds(60, 330, 70, 23);
		jLayeredPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel3.setText("\u7ea7    \u522b\uff1a");
		jLabel3.setBounds(10, 330, 52, 17);
		jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel1.setText("\u7f16    \u53f7\uff1a");
		jLabel1.setBounds(10, 280, 52, 17);
		jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField1.setText("jTextField1");
		jTextField1.setBounds(60, 280, 67, 23);
		jLayeredPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel2.setText("\u5355    \u4ef7\uff1a");
		jLabel2.setBounds(150, 280, 52, 17);
		jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField4.setText("jTextField4");
		jTextField4.setBounds(200, 280, 70, 23);
		jLayeredPane1.add(jTextField4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton1.setText("\u91cd\u7f6e");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton1MouseClicked(evt);
			}
		});
		jButton1.setBounds(60, 370, 60, 25);
		jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton4.setText("\u6dfb\u52a0");
		jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton4MouseClicked(evt);
			}
		});
		jButton4.setBounds(160, 370, 60, 25);
		jLayeredPane1.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLabel5.setBounds(0, 260, 300, 150);
		jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField5.setText("jTextField3");
		jTextField5.setBounds(510, 330, 70, 23);
		jLayeredPane1.add(jTextField5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel6.setText("\u6298    \u6263\uff1a");
		jLabel6.setBounds(450, 330, 52, 17);
		jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField6.setText("jTextField2");
		jTextField6.setBounds(370, 330, 70, 23);
		jLayeredPane1.add(jTextField6, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel7.setText("\u7ea7    \u522b\uff1a");
		jLabel7.setBounds(310, 330, 52, 17);
		jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel8.setText("\u7f16    \u53f7\uff1a");
		jLabel8.setBounds(310, 280, 52, 17);
		jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField7.setText("jTextField1");
		jTextField7.setBounds(370, 280, 67, 23);
		jLayeredPane1.add(jTextField7, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel9.setText("\u5355    \u4ef7\uff1a");
		jLabel9.setBounds(450, 280, 52, 17);
		jLayeredPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField8.setText("jTextField4");
		jTextField8.setBounds(510, 280, 70, 23);
		jLayeredPane1.add(jTextField8, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton6.setText("\u91cd\u7f6e");
		jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton6MouseClicked(evt);
			}
		});
		jButton6.setBounds(360, 370, 60, 25);
		jLayeredPane1.add(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton7.setLabel("\u4fee\u6539");
		jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton7MouseClicked(evt);
			}
		});
		jButton7.setBounds(460, 370, 60, 25);
		jLayeredPane1.add(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLabel10.setBounds(300, 260, 300, 150);
		jLayeredPane1.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437,
				Short.MAX_VALUE));
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		this.jTextField1.setText("");
		this.jTextField4.setText("");
		this.jTextField2.setText("");
		this.jTextField3.setText("");
	}

	private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		String id = this.jTextField1.getText();
		String price = this.jTextField4.getText();
		String level = this.jTextField2.getText();
		String discount = this.jTextField3.getText();
		if (Bool.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择你要修改的记录！");
			return;
		}
		if (Bool.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "价格不能为空！");
			return;
		}
		if (Bool.isEmpty(level)) {
			JOptionPane.showMessageDialog(null, "级别不能为空！");
			return;
		}
		if (Bool.isEmpty(discount)) {
			JOptionPane.showMessageDialog(null, "折扣不能为空！");
			return;
		}

		Vip vip = new Vip(id, price, level, discount);
		int addNum = vipDao.add(vip);
		if (addNum == 1) {
			JOptionPane.showMessageDialog(null, "添加成功！");
			resetValue();
			this.fillTable(new Vip());
		} else {
			JOptionPane.showMessageDialog(null, "添加失败！");
		}
	}

	private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		this.jTextField7.setText("");
		this.jTextField8.setText("");
		this.jTextField6.setText("");
		this.jTextField5.setText("");
	}

	private void jTable1MousePressed(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = this.jTable1.getSelectedRow();
		this.jTextField7.setText(this.jTable1.getValueAt(row, 0).toString());
		this.jTextField8.setText(this.jTable1.getValueAt(row, 1).toString());
		this.jTextField6.setText(this.jTable1.getValueAt(row, 2).toString());
		this.jTextField5.setText(this.jTable1.getValueAt(row, 3).toString());
	}

	private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = jTable1.getSelectedRow();//取得表格选中行
		String id = jTable1.getValueAt(row, 0).toString();
		String price = this.jTextField8.getText();
		String level = this.jTextField6.getText();
		String discount = this.jTextField5.getText();
		if (Bool.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择你要修改的记录！");
			return;
		}
		if (Bool.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "价格不能为空！");
			return;
		}
		if (Bool.isEmpty(level)) {
			JOptionPane.showMessageDialog(null, "级别不能为空！");
			return;
		}
		if (Bool.isEmpty(discount)) {
			JOptionPane.showMessageDialog(null, "折扣不能为空！");
			return;
		}
		Vip vip = new Vip(id, price, level, discount);
		int modifyNum = vipDao.update(vip);
		if (modifyNum == 1) {
			JOptionPane.showMessageDialog(null, "修改成功！");
			resetValue();
			this.fillTable(new Vip());
		} else {
			JOptionPane.showMessageDialog(null, "修改失败！");
		}
	}

	private void resetValue() {
		this.jTextField7.setText("");
		this.jTextField8.setText("");
		this.jTextField6.setText("");
		this.jTextField5.setText("");
	}

	void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = jTable1.getSelectedRow();//取得表格选中行
		String id = jTable1.getValueAt(row, 0).toString();
		if (Bool.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请选择你要删除的记录！");
			return;
		}
		int vipid = Integer.parseInt((String) jTable1.getValueAt(row, 0));
		if (vipid == 1) {
			JOptionPane.showMessageDialog(null, "该条记录为默认数据，不能被删除！");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "确定要删除这条记录吗？");
		if (n == 0) {
			Vip vip = new Vip(id);
			int delecteNum = vipDao.delete(vip);
			if (delecteNum == 1) {
				JOptionPane.showMessageDialog(null, "删除成功！");
				this.fillTable(new Vip());
			} else {
				JOptionPane.showMessageDialog(null, "删除失败！");
			}
		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;
	// End of variables declaration//GEN-END:variables

}