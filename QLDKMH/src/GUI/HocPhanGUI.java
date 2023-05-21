package GUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import BUS.GiangVienBUS;
import BUS.HocKyBUS;
import BUS.HocPhanBUS;
import BUS.MonHocBUS;
import BUS.TietHocBUS;
import DTO.GiangVien;
import DTO.HocKy;
import DTO.HocPhan;
import DTO.MonHoc;
import DTO.TietHoc;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;

public class HocPhanGUI extends JPanel {
	private JTextField txtTim;
	private JTextField txtMaHP;
	private JTextField txtTenHP;
	private JTextField txtNgBD;
	private JTextField txtNgKT;
	private JTextField txtHK;
	private JTextField txtMaMH;
	private JTextField txtMaGV;

	private DefaultTableModel dshp;
	private DefaultTableModel dshk;
	private DefaultTableModel dsmh;
	private JTable tableDshp;
	private JTable tableChoice;
	private DefaultTableModel dsth;
	private JButton btnThemPC;
	private JButton btnThem;
	private JButton btnTim;
	private JButton btnXoa;
	private JButton btnNgBD;
	private JButton btnNgKT;
	private JButton btnMH;
	private JButton btnNgBDFind;
	private JButton btnNgKTFind;
	private Component scrollPane_1;
	private DefaultTableModel dsgv;
	private JTextField txtSL;
	private JButton btnHK;

	private int choiceObj = -1;
	private JTable tableTH;
	private JButton btnXoaTH;
	private JButton btnTietHoc;

	/**
	 * Create the panel.
	 */
	public HocPhanGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);

		createTable();

		JLabel lblNewLabel = new JLabel("DANH SÁCH HỌC PHẦN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(104, 36, 498, 49);
		add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane(tableDshp);
		scrollPane.setBounds(10, 183, 728, 570);
		add(scrollPane);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(10, 136, 85, 37);
		add(btnXoa);

		txtTim = new JTextField();
		txtTim.setBounds(104, 133, 301, 19);
		add(txtTim);
		txtTim.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("từ ngày:");
		lblNewLabel_1.setBounds(104, 157, 46, 13);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("đến ngày:");
		lblNewLabel_1_1.setBounds(254, 157, 55, 13);
		add(lblNewLabel_1_1);

		btnTim = new JButton("TÌM");
		btnTim.setBounds(429, 132, 62, 38);
		add(btnTim);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(748, 36, 473, 717);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("THÊM HỌC PHẦN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(108, 10, 263, 37);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Mã Học Phần:");
		lblNewLabel_3.setBounds(23, 60, 79, 27);
		panel.add(lblNewLabel_3);

		txtMaHP = new JTextField();
		txtMaHP.setBounds(128, 64, 219, 23);
		panel.add(txtMaHP);
		txtMaHP.setColumns(10);

		JLabel lblNewLabel_3_1 = new JLabel("Tên Học Phần:");
		lblNewLabel_3_1.setBounds(23, 107, 79, 27);
		panel.add(lblNewLabel_3_1);

		txtTenHP = new JTextField();
		txtTenHP.setColumns(10);
		txtTenHP.setBounds(128, 111, 219, 23);
		panel.add(txtTenHP);

		JLabel lblNewLabel_3_2 = new JLabel("Ngày Bắt Đầu:");
		lblNewLabel_3_2.setBounds(23, 148, 79, 27);
		panel.add(lblNewLabel_3_2);

		txtNgBD = new JTextField();
		txtNgBD.setEnabled(false);
		txtNgBD.setColumns(10);
		txtNgBD.setBounds(128, 152, 219, 23);
		panel.add(txtNgBD);

		JLabel lblNewLabel_3_2_1 = new JLabel("Ngày Kết Thúc:");
		lblNewLabel_3_2_1.setBounds(23, 185, 79, 27);
		panel.add(lblNewLabel_3_2_1);

		txtNgKT = new JTextField();
		txtNgKT.setEnabled(false);
		txtNgKT.setColumns(10);
		txtNgKT.setBounds(128, 189, 219, 23);
		panel.add(txtNgKT);

		JLabel lblNewLabel_4 = new JLabel("Học Kì:");
		lblNewLabel_4.setBounds(23, 222, 79, 23);
		panel.add(lblNewLabel_4);

		txtHK = new JTextField();
		txtHK.setEnabled(false);
		txtHK.setHorizontalAlignment(SwingConstants.CENTER);
		txtHK.setBounds(128, 224, 178, 21);
		panel.add(txtHK);
		txtHK.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Mã Môn Học:");
		lblNewLabel_5.setBounds(23, 265, 91, 21);
		panel.add(lblNewLabel_5);

		scrollPane_1 = new JScrollPane(tableChoice);
		scrollPane_1.setBounds(23, 296, 424, 154);
		panel.add(scrollPane_1);

		txtMaMH = new JTextField();
		txtMaMH.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaMH.setEnabled(false);
		txtMaMH.setColumns(10);
		txtMaMH.setBounds(128, 266, 178, 21);
		panel.add(txtMaMH);

		btnThem = new JButton("THÊM");
		btnThem.setBounds(361, 648, 91, 45);
		panel.add(btnThem);

		JLabel lblNewLabel_5_1 = new JLabel("Mã GV:");
		lblNewLabel_5_1.setBounds(23, 471, 91, 21);
		panel.add(lblNewLabel_5_1);

		txtMaGV = new JTextField();
		txtMaGV.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaGV.setEnabled(false);
		txtMaGV.setEditable(false);
		txtMaGV.setColumns(10);
		txtMaGV.setBounds(128, 472, 178, 21);
		panel.add(txtMaGV);

		btnThemPC = new JButton("Thêm Phân Công");
		btnThemPC.setBounds(314, 471, 133, 21);
		panel.add(btnThemPC);

		btnNgBD = new JButton("...");
		btnNgBD.setBounds(357, 151, 36, 21);
		panel.add(btnNgBD);

		btnNgKT = new JButton("...");
		btnNgKT.setBounds(357, 188, 36, 21);
		panel.add(btnNgKT);

		btnMH = new JButton("...");
		btnMH.setBounds(316, 265, 36, 21);
		panel.add(btnMH);

		JLabel lblNewLabel_6 = new JLabel("Số lượng tối đa: ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(21, 502, 105, 27);
		panel.add(lblNewLabel_6);

		txtSL = new JTextField();
		txtSL.setBounds(128, 503, 96, 19);
		panel.add(txtSL);
		txtSL.setColumns(10);

		btnHK = new JButton("...");
		btnHK.setBounds(316, 223, 36, 21);
		panel.add(btnHK);

		JScrollPane scrollPane_2 = new JScrollPane(tableTH);
		scrollPane_2.setBounds(23, 551, 424, 80);
		panel.add(scrollPane_2);

		btnTietHoc = new JButton("Thêm tiêt học");
		btnTietHoc.setBounds(265, 521, 96, 23);
		panel.add(btnTietHoc);

		btnXoaTH = new JButton("Xóa");
		btnXoaTH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaTH.setBounds(371, 519, 68, 27);
		panel.add(btnXoaTH);

		btnNgBDFind = new JButton("");
		btnNgBDFind.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNgBDFind.setBounds(160, 153, 84, 20);
		add(btnNgBDFind);

		btnNgKTFind = new JButton("");
		btnNgKTFind.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNgKTFind.setBounds(312, 153, 84, 20);
		add(btnNgKTFind);

		HocPhanBUS hpb = new HocPhanBUS();
		loadTableDshp(HocPhanBUS.getDshp());
		TinhNang();
	}

	public void TinhNang() {
		// Nhập ngày

		btnNgBDFind.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField temp = new JTextField();
				JdialogDate date = new JdialogDate(temp);
				date.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						super.windowClosed(e);
						btnNgBDFind.setText(temp.getText());
					}
				});
				date.setVisible(true);
			}
		});

		btnNgKTFind.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField temp = new JTextField();
				JdialogDate date = new JdialogDate(temp);
				date.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						super.windowClosed(e);
						btnNgKTFind.setText(temp.getText());
					}
				});
				date.setVisible(true);
			}
		});

		btnNgBD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField temp = new JTextField();
				JdialogDate date = new JdialogDate(temp);
				date.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						super.windowClosed(e);
						txtNgBD.setText(temp.getText());
					}
				});
				date.setVisible(true);
			}
		});

		btnNgKT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField temp = new JTextField();
				JdialogDate date = new JdialogDate(temp);
				date.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						super.windowClosed(e);
						txtNgKT.setText(temp.getText());
					}
				});
				date.setVisible(true);
			}
		});

		// tính năng tìm kiếm

		btnTim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HocPhanBUS temp = new HocPhanBUS();
				loadTableDshp(temp.tim(txtTim.getText(), btnNgBDFind.getText(), btnNgKTFind.getText()));
			}
		});

		btnMH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tableChoice.setModel(dsmh);
				tableChoice.repaint();
				loadTableDsmh();
			}
		});

		btnHK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tableChoice.setModel(dshk);
				tableChoice.repaint();
				loadTableDshk();
			}
		});

		btnThemPC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tableChoice.setModel(dsgv);
				tableChoice.repaint();
				loadTableDsgv();
			}
		});

		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String mahp = txtMaHP.getText();
					String tenhp = txtTenHP.getText();
					String ngbd = txtNgBD.getText();
					String ngkt = txtNgKT.getText();
					String mahk = txtHK.getText();
					String mamh = txtMaMH.getText();
					String magv = txtMaGV.getText();
					int sl = Integer.parseInt(txtSL.getText());
					HocPhanBUS temp = new HocPhanBUS();
					if (temp.them(new HocPhan(mahp, tenhp, ngbd, ngkt, mahk, mamh, 0, sl, magv))) {
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
					} else {
						JOptionPane.showMessageDialog(null, "Thêm không thành công!");
					}
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Dữ liệu nhập sai!");
				}

			}
		});

		btnXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HocPhanBUS hpb = new HocPhanBUS();
				hpb.xoa((String) dshp.getValueAt(choiceObj, 0));
			}
		});

		btnTietHoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JdialogThemTH dialog = new JdialogThemTH();
				dialog.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						loadTableTH(txtMaHP.getText());
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	public void createTable() {
		dshp = new DefaultTableModel(null,
				new String[] { "MaHP", "TenHP", "MaMH", "NgBD", "NgKT", "MaGV", "SiSo", "SiSoToiDa" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		dshk = new DefaultTableModel(null, new String[] { "MaHK", "TenHK", "NgBD", "NgKT" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		dsmh = new DefaultTableModel(null, new String[] { "MaMH", "TenMH", "SoTC", "MonHTrc" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		dsgv = new DefaultTableModel(null, new String[] { "MaGV", "TenGV" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};

		dsth = new DefaultTableModel(null, new String[] { "MaTH", "LoaiTH", "GioBD", "ST", "Phong" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};

		tableDshp = new JTable(dshp);
		tableChoice = new JTable();
		tableTH = new JTable(dsth);

		tableDshp.addMouseListener(new MouseListener() {

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
				int row = tableDshp.getSelectedRow();
				choiceObj = row;
			}
		});

		tableChoice.addMouseListener(new MouseListener() {

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
				int row = tableChoice.getSelectedRow();
				if (tableChoice.getModel().equals(dsmh)) {
					txtMaMH.setText((String) dsmh.getValueAt(row, 0));
				}
				if (tableChoice.getModel().equals(dshk)) {
					txtHK.setText((String) dshk.getValueAt(row, 0));
				}
				if (tableChoice.getModel().equals(dsgv)) {
					txtMaGV.setText((String) dsgv.getValueAt(row, 0));
				}
			}
		});
	}

	public void clearTable(DefaultTableModel model) {
		while (model.getRowCount() > 0)
			model.removeRow(0);
	}

	public void loadTableDshp(ArrayList<HocPhan> obj) {
		clearTable(dshp);
		for (HocPhan temp : obj) {
			dshp.addRow(temp.toArray());
		}
	}

	public void loadTableDshk() {
		HocKyBUS hk = new HocKyBUS();
		clearTable(dshk);
		for (HocKy temp : HocKyBUS.getDsHK()) {
			dshk.addRow(temp.toArray());
		}
	}

	public void loadTableDsmh() {
		MonHocBUS mh = new MonHocBUS();
		clearTable(dsmh);
		for (MonHoc temp : MonHocBUS.getDsmh()) {
			dsmh.addRow(temp.toArray());
		}
	}

	public void loadTableDsgv() {
		GiangVienBUS gvb = new GiangVienBUS();
		clearTable(dsgv);
		for (GiangVien temp : GiangVienBUS.getDsGV()) {
			dsgv.addRow(temp.toArray());
		}
	}

	public void loadTableTH(String mahp) {
		TietHocBUS th = new TietHocBUS();
		clearTable(dsth);
		for (TietHoc temp : th.timMaHP(mahp)) {
			dsth.addRow(temp.toArray());
		}
	}
}
