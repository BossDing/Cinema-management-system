/*
 * TicketMain.java
 *
 * Created on __DATE__, __TIME__
 */

package Main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Customer.TicketSee;
import Factory.JPanelFactory;
import Sale.SaleMain;
import User.LoginID;
import UserDao.CustomerDao;

/**
 *
 * @author  __USER__
 */
public class TicketMain extends javax.swing.JFrame {

	JPanel saleMain;
	JPanel ticketSee;

	/** Creates new form TicketMain */
	public TicketMain() {
		initComponents();
		this.setLayout(null);
		saleMain = JPanelFactory.GetJPanel("SaleMain");
		saleMain.setSize(600, 400);

		jPanel1.add(saleMain);
		this.setTitle(" €∆±");
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jButton1.setText("\u9996\u9875");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton1MouseClicked(evt);
			}
		});
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u67e5\u770b\u8ba2\u5355");
		jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton2MouseClicked(evt);
			}
		});
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("\u7528\u6237\u4e2d\u5fc3");

		jButton4.setText("\u9000\u51fa\u767b\u5f55");
		jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jButton4MouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 622,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 430,
				Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(30, 30, 30).addGroup(
						layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jButton1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										81,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton2).addComponent(jButton3)
								.addComponent(jButton4)).addGap(18, 18, 18)
						.addComponent(jPanel1,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addGap(49, 49, 49)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addGap(
																				89,
																				89,
																				89)
																		.addComponent(
																				jButton1)
																		.addGap(
																				56,
																				56,
																				56)
																		.addComponent(
																				jButton2)
																		.addGap(
																				55,
																				55,
																				55)
																		.addComponent(
																				jButton3)
																		.addGap(
																				64,
																				64,
																				64)
																		.addComponent(
																				jButton4))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jPanel1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(50, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jPanel1.removeAll();

		ticketSee = JPanelFactory.GetJPanel("TicketSee");
		ticketSee.setSize(600, 400);

		jPanel1.add(ticketSee);
		this.setTitle("∂©µ•");

		this.validate();
		this.repaint();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		this.setVisible(false);
		LoginID.getInstance().CusId = "000";
		Login login = new Login();
		login.setVisible(true);
		this.dispose();
	}

	private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		jPanel1.removeAll();

		saleMain = JPanelFactory.GetJPanel("SaleMain");
		saleMain.setSize(600, 400);

		jPanel1.add(saleMain);
		this.setTitle(" €∆±");

		this.validate();
		this.repaint();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TicketMain().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables

}