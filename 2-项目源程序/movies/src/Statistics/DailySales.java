/*
 * DailySales.java
 *
 * Created on __DATE__, __TIME__
 */

package Statistics;

import java.awt.GridLayout;

import Chat.BarChart;

/**
 *
 * @author  __USER__
 */
public class DailySales extends javax.swing.JPanel {

	/** Creates new form DailySales */
	public DailySales() {
		initComponents();
		this.setLayout(new GridLayout(2, 2, 10, 10));
		this.add(new BarChart().getChartPanel());
		this.setBounds(0, 0, 600, 450);
		this.setVisible(true);

	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLayeredPane1 = new javax.swing.JLayeredPane();
		jLabel2 = new javax.swing.JLabel();

		setPreferredSize(new java.awt.Dimension(400, 230));

		jLabel2.setBounds(0, 0, 400, 230);
		jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318,
				Short.MAX_VALUE));
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLayeredPane jLayeredPane1;
	// End of variables declaration//GEN-END:variables

}