package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import BUS.PhanCongBUS;
import DTO.PhanCongDTO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class XemPCGUI extends JPanel {

	private DefaultTableModel model;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public XemPCGUI(String magv) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LỊCH PHÂN CÔNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(218, 20, 751, 93);
		add(lblNewLabel);
		
		createTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(256, 139, 663, 601);
		add(scrollPane);
		
		loadTable(magv);
	}
	
	public void createTable() {
		model = new DefaultTableModel(null,new String[] {"Loại PC","Mã HP","Mã MH","Tên MH"}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table = new JTable(model);
	}
	
	public void loadTable(String magv) {
		while(model.getRowCount()>0)
			model.removeRow(0);
		PhanCongBUS pcb = new PhanCongBUS();
		for(PhanCongDTO temp : pcb.timMaGV(magv)) {
			model.addRow(temp.toArray1());
		}
	}
}
