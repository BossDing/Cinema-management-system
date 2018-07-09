/*
 * TicketSee.java
 *
 * Created on __DATE__, __TIME__
 */

package Customer;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import User.LoginID;
import User.Play;
import User.Ticket;
import UserDao.PlayDao;
import UserDao.TicketDao;
import UserDao.VipDao;

/**
 *
 * @author  __USER__
 */
public class TicketSee extends javax.swing.JPanel {
	PlayDao pdao = new PlayDao();
	List<Play> listPlays = null;

	/** Creates new form TicketSee */
	public TicketSee() {
		initComponents();
		fillTable();
	}

	private void fillTable() {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
		dtm.setRowCount(0);
		listPlays = pdao.userList(LoginID.getInstance().CusId);
		if (listPlays.size() != 0) {
			for (int i = 0; i < listPlays.size(); i++) {
				Play play = listPlays.get(i);
				Vector v = new Vector();
				v.add(play.getMov_name());
				v.add(play.getHal_name());
				v.add(play.getPla_starttime());
				v.add(play.getMov_time());
				v.add(play.getTic_price());
				v.add(play.getHal_count());
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

		jLayeredPane1 = new javax.swing.JLayeredPane();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null },
						{ null, null, null, null, null, null } }, new String[] {
						"电影名称", "影厅名称", "放映时间", "放映时长", "电影票价", "座位号" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(jTable1);

		jScrollPane1.setBounds(50, 70, 490, 310);
		jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430,
				Short.MAX_VALUE));
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	// End of variables declaration//GEN-END:variables

}