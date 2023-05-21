package GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.DangKiBUS;
import BUS.TietHocBUS;
import DTO.HocPhan;
import DTO.TietHoc;
import main.jpSlideBar;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TKBGUI extends JPanel {
	private JTextField txtFind;
	private DefaultTableModel dsmh;
	private DefaultTableModel tkb;
	private JTable tableTKB;
	private JTable tableDsmh;

	private int[][] TKB = new int[8][13];

	DangKiBUS dkb = new DangKiBUS();

	/**
	 * Create the panel.
	 */
	public TKBGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);
		createTable();
		JLabel lblNewLabel = new JLabel("THỜI KHÓA BIỂU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(355, 39, 583, 54);
		add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane(tableTKB);
		scrollPane.setBounds(225, 180, 867, 282);
		add(scrollPane);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(454, 149, 323, 21);
		add(comboBox);

		txtFind = new JTextField();
		txtFind.setBounds(431, 120, 346, 19);
		add(txtFind);
		txtFind.setColumns(10);

		JButton btnEnter = new JButton("ENTER");
		btnEnter.setBounds(787, 119, 85, 21);
		add(btnEnter);

		JScrollPane scrollPane_1 = new JScrollPane(tableDsmh);
		scrollPane_1.setBounds(225, 514, 867, 239);
		add(scrollPane_1);

		JLabel lblNewLabel_1 = new JLabel("DANH SÁCH MÔN HỌC");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(454, 472, 408, 29);
		add(lblNewLabel_1);

		loadTable2(dkb.timMaSV(txtFind.getText()));
		
		btnEnter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadTable2(dkb.timMaSV(txtFind.getText()));
			}
		});
	}

	public void createTable() {
		tkb = new DefaultTableModel(null, new String[] { "GioBD", "T2", "T3", "T4", "T5", "T6", "T7", "CN" });
		tkb.setRowCount(13);
		tkb.setValueAt("7:00-7:50", 0, 0);
		tkb.setValueAt("7:50-8:40", 1, 0);
		tkb.setValueAt("9:00-9:50", 2, 0);
		tkb.setValueAt("9:50-10:40", 3, 0);
		tkb.setValueAt("10:40-11:30", 4, 0);
		tkb.setValueAt("13:00-13:50", 5, 0);
		tkb.setValueAt("13:50-14:40", 6, 0);
		tkb.setValueAt("15:00-15:50", 7, 0);
		tkb.setValueAt("15:50-16:40", 8, 0);
		tkb.setValueAt("16:40-17:30", 9, 0);
		tkb.setValueAt("17:40-18:30", 10, 0);
		tkb.setValueAt("18:30-19:20", 11, 0);
		tkb.setValueAt("19:20-20:10", 12, 0);
		dsmh = new DefaultTableModel(null, new String[] { "MaMH", "TenMH", "LopHP", "STC", "DS" });

		tableTKB = new JTable(tkb);
		tableDsmh = new JTable(dsmh);
	}

	public void clearTable(DefaultTableModel model) {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	public void loadTable2(ArrayList<HocPhan> hp) {
		TKB = new int[8][13];
		int value = 1;
		clearTable(dsmh);
		for (HocPhan temp : hp) {
			dsmh.addRow(temp.toArrayDaDK());
			TietHocBUS thb = new TietHocBUS();
			createTKB(thb.timMaHP(temp.getMaHP()), value++);
		}
		setTKBRender();
		setTableDSRender();
	}

	public void createTKB(ArrayList<TietHoc> obj, int value) {
		System.out.println("vào createTKB");
		TietHocBUS thb = new TietHocBUS();
		for (TietHoc t : obj) {

//			System.out.println("vao roi");
//			System.out.println("Thu : " + t.getNgay());

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
//			System.out.println("Gio BD: " + t.getGioBD());
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
			for (int i = 0; i < t.getSoTiet(); i++) {
//				System.out.println("col: " + col + " row: " + (row + i));
				TKB[col + 1][row + i] = value;
			}
			
		}
	}

	public void setTKBRender() {
		System.out.println("vào setTKBRender");
		tableTKB.repaint();
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				// Lấy đối tượng Component mặc định từ lớp cha
				Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				component.setBackground(Color.white);
//				System.out.println("vào");
				if (TKB[column][row] == 1) {
					component.setBackground(Color.yellow);
				}
				if (TKB[column][row] == 2) {
					component.setBackground(Color.orange);
				}
				if (TKB[column][row] == 3) {
					component.setBackground(Color.cyan);
				}
				if (TKB[column][row] == 4) {
					component.setBackground(Color.gray);
				}
				if (TKB[column][row] == 5) {
					component.setBackground(Color.green);
				}
				if (TKB[column][row] == 6) {
					component.setBackground(Color.PINK);
				}
				if (TKB[column][row] == 7) {
					component.setBackground(Color.red);
				}
				if (TKB[column][row] == 8) {
					component.setBackground(Color.darkGray);
				}
				if (TKB[column][row] == 9) {
					component.setBackground(Color.lightGray);
				}

				return component;
			}
		};
		
		tableTKB.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		tableTKB.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		tableTKB.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		tableTKB.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		tableTKB.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
		tableTKB.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);
		tableTKB.getColumnModel().getColumn(6).setCellRenderer(cellRenderer);
		tableTKB.getColumnModel().getColumn(7).setCellRenderer(cellRenderer);
	}

	public void setTableDSRender() {
		System.out.println("vào setTablDSRender");
		tableDsmh.repaint();
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				// Lấy đối tượng Component mặc định từ lớp cha
				Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				component.setBackground(Color.white);
//					System.out.println("vào");
				if (row == 0) {
					component.setBackground(Color.yellow);
				}
				if (row == 1) {
					component.setBackground(Color.orange);
				}
				if (row == 2) {
					component.setBackground(Color.cyan);
				}
				if (row == 3) {
					component.setBackground(Color.gray);
				}
				if (row == 4) {
					component.setBackground(Color.green);
				}
				if (row == 5) {
					component.setBackground(Color.PINK);
				}
				if (row == 6) {
					component.setBackground(Color.red);
				}
				if (row == 7) {
					component.setBackground(Color.darkGray);
				}
				if (row == 8) {
					component.setBackground(Color.lightGray);
				}

				return component;
			}
		};

		cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		tableDsmh.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		tableDsmh.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
		tableDsmh.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
		tableDsmh.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
		tableDsmh.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);

	}

	public String getTxtFind() {
		return txtFind.getText();
	}

	public void setTxtFind(String txtFind) {
		this.txtFind.setText(txtFind);
		loadTable2(dkb.timMaSV(txtFind));
	}
}
