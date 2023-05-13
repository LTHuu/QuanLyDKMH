package GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.DangKiBUS;
import BUS.HocPhanBUS;
import BUS.TietHocBUS;
import DTO.HocPhan;
import DTO.TietHoc;
import main.jpSlideBar;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DangKyMHGUI extends JPanel {
	private JTextField txtFind;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private DefaultTableModel dsdkmh;
	private DefaultTableModel dsDaDK;
	private DefaultTableModel tkb;
	private JTable tableDkmh;
	private JTable tableDaDK;
	private JTable tableTkb;
	private JButton btnDK;

	private DangKiBUS dkb = new DangKiBUS();

	private int[][] TKB = new int[7][13];
	private JButton btnFind;

	/**
	 * Create the panel.
	 */
	public DangKyMHGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);

		createTable();

		JLabel lblNewLabel = new JLabel("Tìm Môn Học:");
		lblNewLabel.setBounds(131, 80, 101, 22);
		add(lblNewLabel);

		txtFind = new JTextField();
		txtFind.setBounds(256, 82, 343, 22);
		add(txtFind);
		txtFind.setColumns(10);

		scrollPane = new JScrollPane(tableDkmh);
		scrollPane.setBounds(30, 124, 788, 371);
		add(scrollPane);

		scrollPane_1 = new JScrollPane(tableDaDK);
		scrollPane_1.setBounds(30, 558, 1194, 195);
		add(scrollPane_1);

		JButton btnNewButton = new JButton("Xóa");
		btnNewButton.setBounds(1100, 516, 122, 30);
		add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("MÔN HỌC ĐÃ ĐĂNG KÝ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(298, 505, 563, 40);
		add(lblNewLabel_1);

		scrollPane_2 = new JScrollPane(tableTkb);
		scrollPane_2.setBounds(828, 174, 394, 319);
		add(scrollPane_2);

		btnDK = new JButton("ĐĂNG KÝ");
		btnDK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDK.setBounds(828, 124, 101, 40);
		add(btnDK);

		btnFind = new JButton("TÌM");
		btnFind.setBounds(611, 81, 85, 21);
		add(btnFind);
		loadTable2(dkb.timMaSV(jpSlideBar.getMaTK()));
		TinhNang();
	}

	public void createTable() {
		dsdkmh = new DefaultTableModel(null,
				new String[] { "MaMH", "LopHP", "TenHP", "TinChi", "SiSo", "ToiDa", "GV" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		dsDaDK = new DefaultTableModel(null, new String[] { "MaMH", "TenHP", "LopHP", "TinChi" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		;
		tkb = new DefaultTableModel(null, new String[] { "T2", "T3", "T4", "T5", "T6", "T7", "CN" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		;
		tkb.setNumRows(13);

		tableDkmh = new JTable(dsdkmh);
		tableDaDK = new JTable(dsDaDK);
		tableTkb = new JTable(tkb);

		tableTkb.setCellSelectionEnabled(false);
		tableTkb.setRowSelectionAllowed(false);
		tableTkb.setColumnSelectionAllowed(false);

		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				// Lấy đối tượng Component mặc định từ lớp cha
				Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);

				// Thiết lập màu nền và màu văn bản của ô
				if (TKB[column][row] == 1) {
					component.setBackground(Color.yellow);
				}
				if (TKB[column][row] == 2) {
					component.setBackground(Color.green);
				}
				if (TKB[column][row] == 3) {
					component.setBackground(Color.red);
				}

				return component;
			}
		};
	}

	public void TinhNang() {
		btnFind.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HocPhanBUS temp = new HocPhanBUS();
				loadTable1(temp.timMaMH(txtFind.getText()));
			}
		});
		
		btnDK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DangKiBUS dkb = new DangKiBUS();
			}
		});
	}

	public void clearTable(DefaultTableModel model) {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	public void loadTable1(ArrayList<HocPhan> hp) {
		clearTable(dsdkmh);
		for (HocPhan temp : hp) {
			dsdkmh.addRow(temp.toArrayDKMH());
		}
	}

	public void loadTable2(ArrayList<HocPhan> hp) {
		TKB = new int[7][13];
		clearTable(dsDaDK);
		for (HocPhan temp : hp) {
			dsDaDK.addRow(temp.toArrayDaDK());
			TietHocBUS thb = new TietHocBUS();
			for (TietHoc t : thb.timMaMH(temp.getMaHP())) {
				int col = 0;
				switch (t.getNgay()) {
				case "T2": {
					col = 0;
					break;
				}
				case "T3": {
					col = 1;
					break;
				}
				case "T4": {
					col = 2;
					break;
				}
				case "T5": {
					col = 3;
					break;
				}
				case "T6": {
					col = 4;
					break;
				}
				case "T7": {
					col = 5;
					break;
				}
				case "CN": {
					col = 6;
					break;
				}
				}
				int row = 0;
				switch (t.getGioBD()) {
				case "7:00": {
					row = 0;
					break;
				}
				case "7:50": {
					row = 1;
					break;
				}
				case "9:00": {
					row = 2;
					break;
				}
				case "9:50": {
					row = 3;
					break;
				}
				case "10:40": {
					row = 4;
					break;
				}
				case "13:00": {
					row = 5;
					break;
				}
				case "13:50": {
					row = 6;
					break;
				}
				case "15:00": {
					row = 7;
					break;
				}
				case "15:50": {
					row = 8;
					break;
				}
				case "16:40": {
					row = 9;
					break;
				}
				case "17:40": {
					row = 10;
					break;
				}
				case "18:30": {
					row = 11;
					break;
				}
				case "19:20": {
					row = 12;
					break;
				}
				}
				TKB[col][row] = 1;
			}
		}
	}

}
