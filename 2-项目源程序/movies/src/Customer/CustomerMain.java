/*
 * CustomerMain.java
 *
 * Created on __DATE__, __TIME__
 */

package Customer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import UserDao.CustomerDao;
import Bool.Bool;
import User.Customer;

/**
 *
 * @author  __USER__
 */
public class CustomerMain extends javax.swing.JPanel {
	CustomerDao customerDao = new CustomerDao();

	/** Creates new form CustomerMain */
	public CustomerMain() {
		initComponents();
		resetValue();
		fillTable(new Customer(), "vip_id");
	}

	List<Customer> listCustomer;

	private void fillTable(Customer customer, String type) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
		dtm.setRowCount(0);

		if (type.equals("vip_id")) {
			listCustomer = customerDao.list(customer.getVip_id(), "vip_id");
		}
		if (type.equals("cus_name")) {
			listCustomer = customerDao.list(customer.getCus_name(), "cus_name");
		}
		if (listCustomer.size() != 0) {
			for (int i = 0; i < listCustomer.size(); i++) {
				customer = listCustomer.get(i);
				Vector v = new Vector();
				v.add(customer.getCus_id());
				v.add(customer.getCus_name());
				v.add(customer.getCus_sex());
				v.add(customer.getCus_phone());
				v.add(customer.getVip_discount());
				v.add(customer.getVip_id());
				v.add(customer.getCus_viptime());
				dtm.addRow(v);
			}
		}
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		jLayeredPane1 = new javax.swing.JLayeredPane();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jButton2 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jComboBox1 = new javax.swing.JComboBox();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jRadioButton1 = new javax.swing.JRadioButton();
		jRadioButton2 = new javax.swing.JRadioButton();
		jLabel3 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jTextField4 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jComboBox2 = new javax.swing.JComboBox();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jLabel9 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jLayeredPane2 = new javax.swing.JLayeredPane();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jTextField5 = new javax.swing.JTextField();
		jComboBox3 = new javax.swing.JComboBox();
		jButton8 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jTextField6 = new javax.swing.JTextField();
		jLabel12 = new javax.swing.JLabel();
		jRadioButton3 = new javax.swing.JRadioButton();
		jRadioButton4 = new javax.swing.JRadioButton();
		jLabel13 = new javax.swing.JLabel();
		jTextField7 = new javax.swing.JTextField();
		jLabel14 = new javax.swing.JLabel();
		jTextField8 = new javax.swing.JTextField();
		jLabel15 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jComboBox4 = new javax.swing.JComboBox();
		jButton11 = new javax.swing.JButton();
		jButton12 = new javax.swing.JButton();
		jTextField9 = new javax.swing.JTextField();
		jButton13 = new javax.swing.JButton();
		jLabel18 = new javax.swing.JLabel();

		jTable1
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] {
								{ null, null, null, null, null, null },
								{ null, null, null, null, null, null },
								{ null, null, null, null, null, null },
								{ null, null, null, null, null, null },
								{ null, null, null, null, null, null } },
						new String[] { "编    号", "姓    名", "联系方式", "性    别",
								"会员类型", "会员期限" }));
		jScrollPane1.setViewportView(jTable1);

		jScrollPane1.setBounds(20, 50, 560, 190);
		jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton2.setText("\u4fee\u6539");
		jButton2.setBounds(440, 10, -1, -1);
		jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jTextField1.setBounds(20, 10, 100, -1);
		jLayeredPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"会员级别", "VIP 1", "VIP 2", "VIP 3", "VIP 4" }));
		jComboBox1.setBounds(140, 10, -1, -1);
		jLayeredPane1.add(jComboBox1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton3.setText("\u5220\u9664");
		jButton3.setBounds(510, 10, -1, -1);
		jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton4.setText("\u67e5\u8be2");
		jButton4.setBounds(240, 10, -1, -1);
		jLayeredPane1.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton1.setText("\u6dfb\u52a0");
		jButton1.setBounds(370, 10, -1, -1);
		jLayeredPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLabel1.setBounds(0, 0, 600, 250);
		jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel2.setText("\u7f16    \u53f7\uff1a");
		jLabel2.setBounds(50, 290, -1, -1);
		jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField2.setText("jTextField1");
		jTextField2.setBounds(110, 290, 90, -1);
		jLayeredPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel4.setText("\u6027    \u522b\uff1a");
		jLabel4.setBounds(410, 290, -1, -1);
		jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jRadioButton1.setText("\u7537");
		jRadioButton1.setBounds(470, 290, -1, -1);
		jLayeredPane1
				.add(jRadioButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jRadioButton2.setText("\u5973");
		jRadioButton2.setBounds(510, 290, -1, -1);
		jLayeredPane1
				.add(jRadioButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel3.setText("\u8054\u7cfb\u65b9\u5f0f\uff1a");
		jLabel3.setBounds(40, 340, -1, -1);
		jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField3.setText("jTextField3");
		jTextField3.setBounds(110, 340, 90, -1);
		jLayeredPane1.add(jTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel5.setText("\u59d3    \u540d\uff1a");
		jLabel5.setBounds(230, 290, -1, -1);
		jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField4.setText("jTextField2");
		jTextField4.setBounds(290, 290, 90, -1);
		jLayeredPane1.add(jTextField4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel6.setText("\u4f1a\u5458\u671f\u9650\uff1a");
		jLabel6.setBounds(410, 340, -1, -1);
		jLayeredPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel7.setText("15");
		jLabel7.setBounds(490, 340, 20, -1);
		jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel8.setText("\u4f1a\u5458\u7c7b\u578b\uff1a");
		jLabel8.setBounds(220, 340, -1, -1);
		jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Item 1", "Item 2", "Item 3", "Item 4" }));
		jComboBox2.setBounds(290, 340, 90, -1);
		jLayeredPane1.add(jComboBox2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton5.setText("\u91cd\u7f6e");
		jButton5.setBounds(190, 390, 80, -1);
		jLayeredPane1.add(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton6.setLabel("\u4fee\u6539");
		jButton6.setBounds(340, 390, 81, -1);
		jLayeredPane1.add(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLabel9.setBounds(10, 270, 600, 150);
		jLayeredPane1.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null } },
				new String[] { "编    号", "姓    名", "性    别", "联系方式", "会员折扣",
						"会员等级", "会员期限" }));
		jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jTable2MousePressed(evt);
			}
		});
		jScrollPane2.setViewportView(jTable2);

		jScrollPane2.setBounds(20, 50, 570, 190);
		jLayeredPane2.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jTextField5KeyPressed(evt);
			}

			public void keyTyped(java.awt.event.KeyEvent evt) {
				jTextField5KeyTyped(evt);
			}
		});
		jTextField5.setBounds(20, 10, 100, 23);
		jLayeredPane2.add(jTextField5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"会员级别", "初级", "中级", "高级" }));
		jComboBox3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jComboBox3MouseClicked(evt);
			}
		});
		jComboBox3.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jComboBox3ItemStateChanged(evt);
			}
		});
		jComboBox3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox3ActionPerformed(evt);
			}
		});
		jComboBox3
				.addInputMethodListener(new java.awt.event.InputMethodListener() {
					public void caretPositionChanged(
							java.awt.event.InputMethodEvent evt) {
						jComboBox3CaretPositionChanged(evt);
					}

					public void inputMethodTextChanged(
							java.awt.event.InputMethodEvent evt) {
					}
				});
		jComboBox3.setBounds(350, 10, 110, 23);
		jLayeredPane2.add(jComboBox3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton8.setText("\u5220\u9664");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});
		jButton8.setBounds(490, 10, 100, 25);
		jLayeredPane2.add(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton9.setText("\u67e5\u8be2");
		jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton9MouseClicked(evt);
			}
		});
		jButton9.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jButton9ItemStateChanged(evt);
			}
		});
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});
		jButton9.setBounds(140, 10, 80, 25);
		jLayeredPane2.add(jButton9, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLabel10.setBounds(0, 0, 600, 250);
		jLayeredPane2.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel11.setText("\u7f16    \u53f7\uff1a");
		jLabel11.setBounds(30, 270, 52, 17);
		jLayeredPane2.add(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField6.setText("jTextField1");
		jTextField6.setBounds(100, 270, 90, 23);
		jLayeredPane2.add(jTextField6, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel12.setText("\u6027    \u522b\uff1a");
		jLabel12.setBounds(410, 270, 52, 17);
		jLayeredPane2.add(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

		buttonGroup1.add(jRadioButton3);
		jRadioButton3.setSelected(true);
		jRadioButton3.setText("\u7537");
		jRadioButton3.setBounds(470, 270, 60, 25);
		jLayeredPane2
				.add(jRadioButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		buttonGroup1.add(jRadioButton4);
		jRadioButton4.setText("\u5973");
		jRadioButton4.setBounds(540, 270, 60, 25);
		jLayeredPane2
				.add(jRadioButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel13.setText("\u8054\u7cfb\u65b9\u5f0f\uff1a");
		jLabel13.setBounds(30, 320, 60, 17);
		jLayeredPane2.add(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField7.setText("jTextField3");
		jTextField7.setBounds(100, 320, 90, 23);
		jLayeredPane2.add(jTextField7, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel14.setText("\u59d3    \u540d\uff1a");
		jLabel14.setBounds(230, 270, 52, 17);
		jLayeredPane2.add(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField8.setText("jTextField2");
		jTextField8.setBounds(290, 270, 90, 23);
		jLayeredPane2.add(jTextField8, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel15.setText("\u4f1a\u5458\u671f\u9650\uff1a");
		jLabel15.setBounds(410, 320, 80, 17);
		jLayeredPane2.add(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel17.setText("\u4f1a\u5458\u7b49\u7ea7\uff1a");
		jLabel17.setBounds(220, 320, 60, 17);
		jLayeredPane2.add(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"顾客等级", "初级", "中级", "高级" }));
		jComboBox4.setBounds(290, 320, 100, 23);
		jLayeredPane2.add(jComboBox4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton11.setText("\u91cd\u7f6e");
		jButton11.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton11ActionPerformed(evt);
			}
		});
		jButton11.setBounds(160, 360, 100, 25);
		jLayeredPane2.add(jButton11, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton12.setText("\u6dfb\u52a0");
		jButton12.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton12ActionPerformed(evt);
			}
		});
		jButton12.setBounds(480, 360, 81, 25);
		jLayeredPane2.add(jButton12, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jTextField9.setText("jTextField9");
		jTextField9.setBounds(480, 320, 90, 23);
		jLayeredPane2.add(jTextField9, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jButton13.setLabel("\u4fee\u6539");
		jButton13.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton13ActionPerformed(evt);
			}
		});
		jButton13.setBounds(340, 360, 81, 25);
		jLayeredPane2.add(jButton13, javax.swing.JLayeredPane.DEFAULT_LAYER);
		jLabel18.setBounds(10, 250, 650, 170);
		jLayeredPane2.add(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 711,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 468,
				Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addComponent(jLayeredPane1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jPanel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482,
				Short.MAX_VALUE).addGroup(
				layout.createSequentialGroup().addGap(14, 14, 14).addComponent(
						jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)));
	}// </editor-fold>
	//GEN-END:initComponents

	private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {
		// TODO add your handling code here:
		Customer customer = new Customer();
		customer.setCus_name(this.jTextField5.getText());
		fillTable(customer, "cus_name");
	}

	private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {
		// TODO add your handling code here:
		Customer customer = new Customer();
		customer.setCus_name(this.jTextField5.getText());
		fillTable(customer, "cus_name");
	}

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		int row = jTable2.getSelectedRow();//取得表格选中行
		if(row>-1){
		String cus_id = jTable2.getValueAt(row, 0).toString();
		int n = JOptionPane.showConfirmDialog(null, "确定要删除这条记录吗？");
		if (n == 0) {
			Customer customer = new Customer(cus_id);
			int delecteNum = customerDao.delete(customer);
			if (delecteNum == 1) {
				JOptionPane.showMessageDialog(null, "删除成功！");
				resetValue();
				this.fillTable(new Customer(), "cus_name");
			} else {
				JOptionPane.showMessageDialog(null, "删除失败！");
			}
		}}else{
			JOptionPane.showMessageDialog(null, "请选择你要删除的记录！");
			return;
		}
	}

	private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		Customer customer = new Customer();
		customer.setCus_name(this.jTextField5.getText());
		fillTable(customer, "cus_name");
	}

	private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		resetValue();
	}

	private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		int row = jTable2.getSelectedRow();//取得表格选中行
		if(row>-1){
		
		
		String cus_id = this.jTextField6.getText();
		String cus_name = this.jTextField8.getText();
		String cus_sex;
		if (jRadioButton3.isSelected()) {
			cus_sex = "男";
		} else {
			cus_sex = "女";
		}
		String cus_phone = this.jTextField7.getText();
		String vip_discount = "0";
		String vip_id = this.jComboBox4.getSelectedItem().toString();
		String cus_viptime = this.jTextField9.getText();
		if (Bool.isEmpty(this.jTextField6.getText())) {
			JOptionPane.showMessageDialog(null, "顾客编号不能为空！");
			return;
		}
		if (Bool.isEmpty(this.jTextField8.getText())) {
			JOptionPane.showMessageDialog(null, "顾客名称不能为空！");
			return;
		}
		if (Bool.isEmpty(this.jTextField7.getText())) {
			JOptionPane.showMessageDialog(null, "手机号码不能为空！");
			return;
		}
		if (Bool.isEmpty(this.jTextField9.getText())) {
			JOptionPane.showMessageDialog(null, "会员到期天数不能为空！");
			return;
		}
		Customer customer = new Customer(cus_id, cus_name, cus_sex, cus_phone);
		Customer customer2 = new Customer(cus_id, vip_discount, vip_id,
				cus_viptime, 0);
		int modifyNum2 = customerDao.update(customer2, "vip");
		int modifyNum = customerDao.update(customer, "customer");
		if (modifyNum == 1 && modifyNum2 == 1) {
			JOptionPane.showMessageDialog(null, "修改成功！");
			resetValue();
			this.fillTable(new Customer(), "vip_id");
		} else {
			JOptionPane.showMessageDialog(null, "修改失败！");
		}
		}else{
			JOptionPane.showMessageDialog(null, "请选择要修改数据！");
		}
	}

	private void jTable2MousePressed(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		int row = this.jTable2.getSelectedRow();
		this.jTextField6.setText(this.jTable2.getValueAt(row, 0).toString());
		this.jTextField8.setText(this.jTable2.getValueAt(row, 1).toString());
		this.jTextField7.setText(this.jTable2.getValueAt(row, 3).toString());
		this.jTextField9.setText(this.jTable2.getValueAt(row, 6).toString());
		if (this.jTable2.getValueAt(row, 2).toString().equals("男")) {
			this.jRadioButton3.setSelected(true);
		} else {
			this.jRadioButton4.setSelected(true);
		}
		this.jComboBox4.setSelectedItem(this.jTable2.getValueAt(row, 5)
				.toString());
	}

	private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
		Customer customer = new Customer();
		String vipidselect = this.jComboBox3.getSelectedItem().toString();
		if (vipidselect == "会员级别") {
			vipidselect = "";
		}
		customer.setVip_id(vipidselect);
		fillTable(customer, "vip_id");
	}

	private void jButton9ItemStateChanged(java.awt.event.ItemEvent evt) {
		// TODO add your handling code here:
	}

	private void jComboBox3CaretPositionChanged(
			java.awt.event.InputMethodEvent evt) {
		// TODO add your handling code here:

	}

	private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		String cus_id = this.jTextField6.getText();
		String cus_name = this.jTextField8.getText();
		String cus_sex;
		if (jRadioButton3.isSelected()) {
			cus_sex = "男";
		} else {
			cus_sex = "女";
		}
		String cus_phone = this.jTextField7.getText();
		String vip_discount = "0";
		String vip_id = this.jComboBox4.getSelectedItem().toString();
		String cus_viptime = this.jTextField9.getText();
		if (Bool.isEmpty(this.jTextField6.getText())) {
			JOptionPane.showMessageDialog(null, "顾客编号不能为空！");
			return;
		}
		if (Bool.isEmpty(this.jTextField8.getText())) {
			JOptionPane.showMessageDialog(null, "顾客名称不能为空！");
			return;
		}
		if (Bool.isEmpty(this.jTextField7.getText())) {
			JOptionPane.showMessageDialog(null, "手机号码不能为空！");
			return;
		}
		if (Bool.isEmpty(this.jTextField9.getText())) {
			JOptionPane.showMessageDialog(null, "会员到期天数不能为空！");
			return;
		}
		Customer customer = new Customer(cus_id, cus_name, cus_sex, cus_phone);
		Customer customer2 = new Customer(cus_id, vip_discount, vip_id,cus_viptime, 0);
		int modifyNum = customerDao.add(customer, "customer");
		int modifyNum2 = customerDao.add(customer2, "vip");
		if (modifyNum == 1 && modifyNum2 == 1) {
			JOptionPane.showMessageDialog(null, "添加成功！");
			resetValue();
			this.fillTable(new Customer(), "vip_id");
		} 
//		else if (modifyNum == -2) {
//			JOptionPane.showMessageDialog(null, "添加失败！该用户编号已存在！");
//		}
		else {
			JOptionPane.showMessageDialog(null, "添加失败！");
		}

	}

	private void resetValue() {
		// TODO Auto-generated method stub
		this.jTextField6.setText("");
		this.jTextField8.setText("");
		this.jTextField7.setText("");
		this.jTextField9.setText("");
		this.jRadioButton3.setSelected(true);
		this.jComboBox4.setSelectedItem("顾客等级");
	}

	private void jComboBox3MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:

	}

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton12;
	private javax.swing.JButton jButton13;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JComboBox jComboBox3;
	private javax.swing.JComboBox jComboBox4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JLayeredPane jLayeredPane2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JRadioButton jRadioButton1;
	private javax.swing.JRadioButton jRadioButton2;
	private javax.swing.JRadioButton jRadioButton3;
	private javax.swing.JRadioButton jRadioButton4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	private javax.swing.JTextField jTextField7;
	private javax.swing.JTextField jTextField8;
	private javax.swing.JTextField jTextField9;
	// End of variables declaration//GEN-END:variables

}