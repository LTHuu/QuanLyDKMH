package GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import BUS.KetQuaKTBUS;
import BUS.LichThiBUS;
import DTO.KetQuaKT;
import DTO.LichThi;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

public class QuanLyDiemGUI extends JPanel {
	private JTextField txtTim;
	private JTextField txtMaKT;
	private JTextField txtNgKT;
	private JTextField txtMaHP;
	private JToggleButton btnSuaKQ;
	private JComboBox BoxLoaiKT;
	private JComboBox BoxGioBD;
	private JButton btnXoaLT;
	private JButton btnXoaKQ;
	private JButton btnTim;
	private DefaultTableModel model1;
	private DefaultTableModel model2;
	private JTable table1;
	private JTable table2;
	private JToggleButton btnSua;
	private JToggleButton btnThem;

	private int choiceObj = -1;
	private int choiceTable = -1;

	/**
	 * Create the panel.
	 */
	public QuanLyDiemGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);

		createTable();

		JScrollPane scrollPane = new JScrollPane(table1);
		scrollPane.setBounds(10, 107, 711, 288);
		add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane(table2);
		scrollPane_1.setBounds(252, 465, 711, 288);
		add(scrollPane_1);

		JLabel lblNewLabel = new JLabel("DANH SÁCH LỊCH THI");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(140, 34, 334, 29);
		add(lblNewLabel);

		JLabel lblDanhSchKt = new JLabel("DANH SÁCH KẾT QUẢ");
		lblDanhSchKt.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchKt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDanhSchKt.setBounds(336, 412, 334, 29);
		add(lblDanhSchKt);

		btnXoaLT = new JButton("XÓA");
		btnXoaLT.setBounds(10, 67, 71, 29);
		add(btnXoaLT);

		btnXoaKQ = new JButton("XÓA");
		btnXoaKQ.setBounds(155, 465, 71, 29);
		add(btnXoaKQ);

		txtTim = new JTextField();
		txtTim.setBounds(176, 73, 284, 19);
		add(txtTim);
		txtTim.setColumns(10);

		btnTim = new JButton("TÌM");
		btnTim.setBounds(469, 73, 85, 21);
		add(btnTim);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(731, 107, 508, 288);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("THÔNG TIN LỊCH THI");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(129, 10, 267, 33);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("MaKT: ");
		lblNewLabel_2.setBounds(100, 53, 57, 20);
		panel.add(lblNewLabel_2);

		txtMaKT = new JTextField();
		txtMaKT.setEnabled(false);
		txtMaKT.setBounds(199, 54, 219, 19);
		panel.add(txtMaKT);
		txtMaKT.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("NgKT:");
		lblNewLabel_2_1.setBounds(100, 97, 57, 20);
		panel.add(lblNewLabel_2_1);

		txtNgKT = new JTextField();
		txtNgKT.setEnabled(false);
		txtNgKT.setColumns(10);
		txtNgKT.setBounds(199, 98, 219, 19);
		panel.add(txtNgKT);

		JLabel lblNewLabel_2_1_1 = new JLabel("TG BD:");
		lblNewLabel_2_1_1.setBounds(100, 133, 57, 20);
		panel.add(lblNewLabel_2_1_1);

		BoxGioBD = new JComboBox();
		BoxGioBD.setEnabled(false);
		BoxGioBD.setModel(new DefaultComboBoxModel(
				new String[] { "7:00", "7;50", "9:00", "9:50", "10:40", "13:00", "13:50", "15:00", "15:50", "16:40" }));
		BoxGioBD.setBounds(199, 133, 219, 20);
		panel.add(BoxGioBD);

		JLabel lblNewLabel_2_1_2 = new JLabel("MaHP");
		lblNewLabel_2_1_2.setBounds(100, 163, 57, 20);
		panel.add(lblNewLabel_2_1_2);

		txtMaHP = new JTextField();
		txtMaHP.setEnabled(false);
		txtMaHP.setColumns(10);
		txtMaHP.setBounds(199, 164, 219, 19);
		panel.add(txtMaHP);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Loai KT:");
		lblNewLabel_2_1_1_1.setBounds(100, 197, 57, 20);
		panel.add(lblNewLabel_2_1_1_1);

		BoxLoaiKT = new JComboBox();
		BoxLoaiKT.setEnabled(false);
		BoxLoaiKT.setModel(new DefaultComboBoxModel(new String[] { "15p", "1 TIET", "CUOIKI" }));
		BoxLoaiKT.setBounds(199, 197, 219, 20);
		panel.add(BoxLoaiKT);

		btnSua = new JToggleButton("SỬA");
		btnSua.setBounds(249, 227, 74, 51);
		panel.add(btnSua);

		btnThem = new JToggleButton("THÊM");
		btnThem.setBounds(344, 227, 74, 51);
		panel.add(btnThem);

		btnSuaKQ = new JToggleButton("SỬA");
		btnSuaKQ.setBounds(154, 504, 72, 29);
		add(btnSuaKQ);

		LichThiBUS ltb = new LichThiBUS();
		loadTable1(LichThiBUS.getDsLT());
		KetQuaKTBUS ktb = new KetQuaKTBUS();
		loadTable2(KetQuaKTBUS.getDsKQ());

		TinhNang();
	}

	public void TinhNang() {
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnThem.isSelected()) {
					btnSua.setEnabled(false);
					txtMaKT.setEnabled(true);
					txtNgKT.setEnabled(true);
					txtMaHP.setEnabled(true);
					BoxGioBD.setEnabled(true);
					BoxLoaiKT.setEnabled(true);

				} else {
					try {
						String makt = txtMaKT.getText();
						String ngkt = txtNgKT.getText();
						String tgbd = (String) BoxGioBD.getSelectedItem();
						String mahp = txtMaHP.getText();
						String loaikt = (String) BoxLoaiKT.getSelectedItem();
						LichThiBUS ltb = new LichThiBUS();
						if (ltb.them(new LichThi(makt, ngkt, tgbd, mahp, loaikt))) {
							JOptionPane.showMessageDialog(null, "Thêm thành công!");
							loadTable1(LichThiBUS.getDsLT());
						} else {
							JOptionPane.showMessageDialog(null, "Thêm không thành công!");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}

					btnSua.setEnabled(true);
					txtMaKT.setEnabled(false);
					txtNgKT.setEnabled(false);
					txtMaHP.setEnabled(false);
					BoxGioBD.setEnabled(false);
					BoxLoaiKT.setEnabled(false);
				}
			}

		});

		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnSua.isSelected()) {
					btnThem.setEnabled(false);
					txtMaKT.setEnabled(false);
					txtNgKT.setEnabled(true);
					txtMaHP.setEnabled(true);
					BoxGioBD.setEnabled(true);
					BoxLoaiKT.setEnabled(true);

				} else {
					try {
						String makt = txtMaKT.getText();
						String ngkt = txtNgKT.getText();
						String tgbd = (String) BoxGioBD.getSelectedItem();
						String mahp = txtMaHP.getText();
						String loaikt = (String) BoxLoaiKT.getSelectedItem();
						LichThiBUS ltb = new LichThiBUS();
						ltb.sua(new LichThi(makt, ngkt, tgbd, mahp, loaikt), makt);
						loadTable1(LichThiBUS.getDsLT());
					} catch (Exception e2) {
						// TODO: handle exception
					}

					btnThem.setEnabled(true);
					txtMaKT.setEnabled(false);
					txtNgKT.setEnabled(false);
					txtMaHP.setEnabled(false);
					BoxGioBD.setEnabled(false);
					BoxLoaiKT.setEnabled(false);
				}
			}
		});

		btnTim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LichThiBUS ltb = new LichThiBUS();
				loadTable1(ltb.tim(txtTim.getText()));
			}
		});

		btnXoaLT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (choiceTable == 1) {
					if (JOptionPane.showConfirmDialog(null,
							"Việc này sẽ xóa các kết quả liên quan đến lịch thi này! Bạn có muốn thực hiện không?") == 0) {
						LichThiBUS ltb = new LichThiBUS();
						ltb.xoa((String) model1.getValueAt(choiceObj, 0));
						loadTable1(LichThiBUS.getDsLT());
					}
				}
			}
		});

		btnXoaKQ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (choiceTable == 2) {
					if (JOptionPane.showConfirmDialog(null, "Bạn có thật sự muốn thực hiện việc này?") == 0) {
						KetQuaKTBUS ltb = new KetQuaKTBUS();
						ltb.xoa((String) model1.getValueAt(choiceObj, 0), (String) model1.getValueAt(choiceObj, 1));
					}
				}
			}
		});

		btnSuaKQ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnSuaKQ.isSelected()) {

				}
			}
		});
	}

	public void createTable() {
		model1 = new DefaultTableModel(null, new String[] { "MaKT", "NgKT", "TG BD", "MaHP", "LoaiKT" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		model2 = new DefaultTableModel(null, new String[] { "MaKT", "MaSV", "Diem" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return column == 2 && btnSuaKQ.isSelected();
			}
		};

		table1 = new JTable(model1);
		table2 = new JTable(model2);

		table1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table1.getSelectedRow();
				String makt = (String) model1.getValueAt(row, 0);
				choiceObj = row;
				choiceTable = 1;
				KetQuaKTBUS kqb = new KetQuaKTBUS();
				loadTable2(kqb.timMaKT(makt));
			}
		});

		table2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = table2.getSelectedRow();
				String makt = (String) model2.getValueAt(row, 0);
				choiceObj = row;
				choiceTable = 2;
			}
		});

		model2.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				if (choiceTable == 2) {
					KetQuaKTBUS kqb = new KetQuaKTBUS();
					String makt = (String) (model2.getValueAt(choiceObj, 0));
					float diem = (Float.parseFloat(model2.getValueAt(choiceObj, 2).toString()));
					String masv = (String) model2.getValueAt(choiceObj, 1);
					KetQuaKT t = new KetQuaKT(makt, diem, masv);
					kqb.sua((String) model2.getValueAt(choiceObj, 1), (String) model2.getValueAt(choiceObj, 0), t);
				}
			}
		});
	}

	public void clearTable(DefaultTableModel model) {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	public void loadTable1(ArrayList<LichThi> obj) {
		clearTable(model1);
		for (LichThi temp : obj) {
			model1.addRow(temp.toArray());
		}
	}

	public void loadTable2(ArrayList<KetQuaKT> obj) {
		clearTable(model2);
		for (KetQuaKT temp : obj) {
			model2.addRow(temp.toArray());
		}
	}
}
