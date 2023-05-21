package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import BUS.GiangVienBUS;
import BUS.SinhVienBUS;
import BUS.TaiKhoanBUS;
import DTO.GiangVien;
import DTO.SinhVienDTO;
import DTO.TaiKhoan;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class QuanLyNguoiDungGUI extends JPanel {
	private JTextField txtFind;
	private JTextField txtInfo1;
	private JTextField txtInfo2;
	private JTextField txtInfo3;
	private JTextField txtInfo4;
	private JTextField txtInfo5;
	private JTextField txtInfo6;
	private JTextField txtMaTK;
	private JTextField txtTenDN;
	private JTextField txtMK;
	private JTextField txtEmail;
	private JTextField txtNgLap;

	private int choiceObj = -1;
	private DefaultTableModel modelsv;
	private DefaultTableModel modelgv;
	private JTable tableDS;
	private JToggleButton btnSua;
	private JButton btnThemTT;
	private JRadioButton radGiangVien;
	private JRadioButton radSinhVien;
	private JButton btnXoa;
	private JLabel lbThongTin;
	private JLabel lblInfo1;
	private JLabel lblInfo2;
	private JLabel lblInfo3;
	private JLabel lblInfo4;
	private JLabel lblInfo5;
	private JLabel lblInfo6;
	private JToggleButton btnThemTK;
	private JToggleButton btnSuaTK;

	/**
	 * Create the panel.
	 */
	public QuanLyNguoiDungGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);

		createTable();
		JScrollPane scrollPane = new JScrollPane(tableDS);
		scrollPane.setBounds(10, 95, 797, 661);
		add(scrollPane);

		JLabel lblNewLabel = new JLabel("DANH SÁCH GIẢNG VIÊN/SINH VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(135, 10, 578, 25);
		add(lblNewLabel);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBounds(10, 64, 85, 21);
		add(btnXoa);

		txtFind = new JTextField();
		txtFind.setBounds(195, 66, 284, 21);
		add(txtFind);
		txtFind.setColumns(10);

		ButtonGroup group = new ButtonGroup();

		radGiangVien = new JRadioButton("Giảng Viên");
		radGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radGiangVien.setBounds(563, 65, 85, 21);
		add(radGiangVien);
		group.add(radGiangVien);

		radSinhVien = new JRadioButton("Sinh Viên");
		radSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radSinhVien.setBounds(660, 65, 85, 21);
		add(radSinhVien);
		radSinhVien.setSelected(true);
		group.add(radSinhVien);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(817, 95, 422, 339);
		add(panel);
		panel.setLayout(null);

		lbThongTin = new JLabel("THÔNG TIN SINH VIÊN");
		lbThongTin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbThongTin.setHorizontalAlignment(SwingConstants.CENTER);
		lbThongTin.setBounds(100, 10, 232, 33);
		panel.add(lbThongTin);

		lblInfo1 = new JLabel("Mã SV:");
		lblInfo1.setBounds(10, 63, 117, 27);
		panel.add(lblInfo1);

		txtInfo1 = new JTextField();
		txtInfo1.setBounds(137, 67, 232, 19);
		panel.add(txtInfo1);
		txtInfo1.setColumns(10);

		lblInfo2 = new JLabel("Tên SV:");
		lblInfo2.setBounds(10, 100, 117, 27);
		panel.add(lblInfo2);

		txtInfo2 = new JTextField();
		txtInfo2.setColumns(10);
		txtInfo2.setBounds(137, 104, 232, 19);
		panel.add(txtInfo2);

		lblInfo3 = new JLabel("Số DT:");
		lblInfo3.setBounds(10, 137, 117, 27);
		panel.add(lblInfo3);

		txtInfo3 = new JTextField();
		txtInfo3.setColumns(10);
		txtInfo3.setBounds(137, 141, 232, 19);
		panel.add(txtInfo3);

		lblInfo4 = new JLabel("Khoa:");
		lblInfo4.setBounds(10, 174, 117, 27);
		panel.add(lblInfo4);

		txtInfo4 = new JTextField();
		txtInfo4.setColumns(10);
		txtInfo4.setBounds(137, 178, 232, 19);
		panel.add(txtInfo4);

		lblInfo5 = new JLabel("Địa chỉ:");
		lblInfo5.setBounds(10, 211, 117, 27);
		panel.add(lblInfo5);

		txtInfo5 = new JTextField();
		txtInfo5.setColumns(10);
		txtInfo5.setBounds(137, 215, 232, 19);
		panel.add(txtInfo5);

		lblInfo6 = new JLabel("Mã:");
		lblInfo6.setBounds(10, 248, 117, 27);
		panel.add(lblInfo6);
		lblInfo6.setVisible(false);

		txtInfo6 = new JTextField();
		txtInfo6.setColumns(10);
		txtInfo6.setBounds(137, 252, 232, 19);
		panel.add(txtInfo6);

		btnThemTT = new JButton("THÊM");
		btnThemTT.setBounds(247, 290, 122, 39);
		panel.add(btnThemTT);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(817, 457, 422, 299);
		add(panel_1);

		JLabel lbTTTK = new JLabel("THÔNG TIN TÀI KHOẢN");
		lbTTTK.setHorizontalAlignment(SwingConstants.CENTER);
		lbTTTK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbTTTK.setBounds(97, 10, 232, 33);
		panel_1.add(lbTTTK);

		JLabel lblMTiKhon = new JLabel("Mã Tài Khoản:");
		lblMTiKhon.setBounds(10, 63, 117, 27);
		panel_1.add(lblMTiKhon);

		txtMaTK = new JTextField();
		txtMaTK.setEnabled(false);
		txtMaTK.setColumns(10);
		txtMaTK.setBounds(137, 67, 232, 19);
		panel_1.add(txtMaTK);

		JLabel lblTnngNhp = new JLabel("Tên Đăng Nhập:");
		lblTnngNhp.setBounds(10, 100, 117, 27);
		panel_1.add(lblTnngNhp);

		txtTenDN = new JTextField();
		txtTenDN.setEnabled(false);
		txtTenDN.setColumns(10);
		txtTenDN.setBounds(137, 104, 232, 19);
		panel_1.add(txtTenDN);

		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setBounds(10, 137, 117, 27);
		panel_1.add(lblMtKhu);

		txtMK = new JTextField();
		txtMK.setEnabled(false);
		txtMK.setColumns(10);
		txtMK.setBounds(137, 141, 232, 19);
		panel_1.add(txtMK);

		JLabel lblNgyLp = new JLabel("Ngày lập:");
		lblNgyLp.setBounds(10, 211, 117, 27);
		panel_1.add(lblNgyLp);

		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(137, 178, 232, 19);
		panel_1.add(txtEmail);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 174, 117, 27);
		panel_1.add(lblEmail);

		txtNgLap = new JTextField();
		txtNgLap.setEnabled(false);
		txtNgLap.setColumns(10);
		txtNgLap.setBounds(137, 215, 232, 19);
		panel_1.add(txtNgLap);

		btnThemTK = new JToggleButton("THÊM");
		btnThemTK.setBounds(284, 256, 85, 33);
		panel_1.add(btnThemTK);

		btnSuaTK = new JToggleButton("SỬA");
		btnSuaTK.setBounds(180, 256, 85, 33);
		panel_1.add(btnSuaTK);

		btnSua = new JToggleButton("SỬA");
		btnSua.setBounds(100, 65, 85, 21);
		add(btnSua);

		tableDS.setModel(modelsv);
		tableDS.repaint();
		SinhVienBUS temp = new SinhVienBUS();
		loadTableSV(SinhVienBUS.getDsSV());

		TinhNang();
	}

	public void TinhNang() {
		radSinhVien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (radSinhVien.isSelected()) {
					tableDS.setModel(modelsv);
					tableDS.repaint();
					SinhVienBUS temp = new SinhVienBUS();
					loadTableSV(SinhVienBUS.getDsSV());
					lbThongTin.setText("THÔNG TIN SINH VIÊN");
					lblInfo1.setText("Mã SV:");
					lblInfo2.setText("Tên SV:");
					lblInfo3.setText("Số DT:");
					lblInfo4.setText("Khoa:");
					lblInfo5.setText("Địa chỉ:");
					lblInfo6.setVisible(false);
					;
				}
			}
		});

		radGiangVien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (radGiangVien.isSelected()) {
					tableDS.setModel(modelgv);
					tableDS.repaint();
					GiangVienBUS temp = new GiangVienBUS();
					loadTableGV(GiangVienBUS.getDsGV());
					lbThongTin.setText("THÔNG TIN GIẢNG VIÊN");
					lblInfo1.setText("Mã GV:");
					lblInfo2.setText("Tên GV:");
					lblInfo3.setText("Email:");
					lblInfo4.setText("Số DT:");
					lblInfo5.setText("Khoa:");
					lblInfo6.setVisible(true);
					lblInfo6.setText("Chuyên:");
				}
			}
		});

		txtFind.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if (radSinhVien.isSelected()) {
					SinhVienBUS svb = new SinhVienBUS();
					loadTableSV(svb.tim(txtFind.getText()));
				}
				if (radGiangVien.isSelected()) {
					GiangVienBUS svb = new GiangVienBUS();
					loadTableGV(svb.tim(txtFind.getText()));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (radSinhVien.isSelected()) {
					SinhVienBUS svb = new SinhVienBUS();
					svb.xoa((String) modelsv.getValueAt(choiceObj, 0));
					loadTableSV(SinhVienBUS.getDsSV());
				}
				if (radGiangVien.isSelected()) {
					GiangVienBUS gvb = new GiangVienBUS();
					gvb.xoa((String) modelgv.getValueAt(choiceObj, 0));
					loadTableGV(GiangVienBUS.getDsGV());
				}
			}
		});

		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!btnSua.isSelected()) {
				}
			}
		});

		btnThemTK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnThemTK.isSelected()) {
					btnSuaTK.setEnabled(false);
					txtMaTK.setEnabled(true);
					txtTenDN.setEnabled(true);
					txtMK.setEnabled(true);
					txtEmail.setEnabled(true);
					txtNgLap.setEnabled(true);
				} else {
					TaiKhoanBUS tkb = new TaiKhoanBUS();
					String matk = txtMaTK.getText();
					String tendn = txtMaTK.getText();
					String mk = txtMaTK.getText();
					String email = txtMaTK.getText();
					LocalDate date = LocalDate.now();
					String nglap = date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
					tkb.addTaiKhoan(new TaiKhoan(matk, tendn, matk, nglap, email));
					btnSuaTK.setEnabled(true);
					txtMaTK.setEnabled(false);
					txtTenDN.setEnabled(false);
					txtMK.setEnabled(false);
					txtEmail.setEnabled(false);
					txtNgLap.setEnabled(false);
				}
			}
		});

		btnSuaTK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnSuaTK.isSelected()) {
					btnThemTK.setEnabled(false);
					txtMaTK.setEnabled(true);
					txtTenDN.setEnabled(true);
					txtMK.setEnabled(true);
					txtEmail.setEnabled(true);
					txtNgLap.setEnabled(true);
				} else {
					TaiKhoanBUS tkb = new TaiKhoanBUS();
					String matk = txtMaTK.getText();
					String tendn = txtMaTK.getText();
					String mk = txtMaTK.getText();
					String email = txtMaTK.getText();
					String nglap = txtNgLap.getText();
					tkb.sua(matk, new TaiKhoan(matk, tendn, matk, nglap, email));
					btnThemTK.setEnabled(true);
					txtMaTK.setEnabled(false);
					txtTenDN.setEnabled(false);
					txtMK.setEnabled(false);
					txtEmail.setEnabled(false);
					txtNgLap.setEnabled(false);
				}
			}
		});
	}

	public void createTable() {
		modelsv = new DefaultTableModel(null, new String[] { "MaSV", "TenSV", "SDT", "Khoa", "DiaChi" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return column > 0 && btnSua.isSelected();
			}
		};
		modelgv = new DefaultTableModel(null, new String[] { "MaGV", "TenGV", "Email", "SDT", "Khoa", "Chuyen" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return column > 0 && btnSua.isSelected();
			}
		};

		tableDS = new JTable();

		tableDS.addMouseListener(new MouseListener() {

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
				int row = tableDS.getSelectedRow();
				choiceObj = row;
				if (!btnThemTK.isSelected() && !btnSuaTK.isSelected()) {
					if (tableDS.getModel().equals(modelsv)) {
						SinhVienBUS svb = new SinhVienBUS();
						SinhVienDTO sv = svb.timMaSV((String) modelsv.getValueAt(row, 0));
						txtInfo1.setText(sv.getMaSV());
						txtInfo2.setText(sv.getTenSV());
						txtInfo3.setText(sv.getSoDT());
						txtInfo4.setText(sv.getKhoa());
						txtInfo5.setText(sv.getDiaChi());
						LetThongTinTK(sv.getMaSV());
					}
					if (tableDS.getModel().equals(modelgv)) {
						GiangVienBUS gvb = new GiangVienBUS();
						GiangVien gv = gvb.timMaGV((String) modelgv.getValueAt(row, 0));
						txtInfo1.setText(gv.getMaGV());
						txtInfo2.setText(gv.getTenGV());
						txtInfo3.setText(gv.getEmail());
						txtInfo4.setText(gv.getSDT());
						txtInfo5.setText(gv.getKhoa());
						txtInfo6.setText(gv.getChuyen());
						LetThongTinTK(gv.getMaGV());
					}
				}
			}
		});

		modelsv.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				SinhVienBUS svb = new SinhVienBUS();
				if(choiceObj>=0) {
					String masv = (String) modelgv.getValueAt(choiceObj, 0);
					String tensv = (String) modelgv.getValueAt(choiceObj, 1);
					String sdt = (String) modelgv.getValueAt(choiceObj, 2);
					String khoa = (String) modelgv.getValueAt(choiceObj, 3);
					String dc = (String) modelgv.getValueAt(choiceObj, 4);
					svb.sua(masv, new SinhVienDTO(masv, tensv, sdt, khoa, dc));
				}
				
			}
		});

		modelsv.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				GiangVienBUS svb = new GiangVienBUS();
				if (choiceObj >= 0) {
					String magv = (String) modelsv.getValueAt(choiceObj, 0);
					String tengv = (String) modelsv.getValueAt(choiceObj, 1);
					String email = (String) modelsv.getValueAt(choiceObj, 2);
					String sdt = (String) modelsv.getValueAt(choiceObj, 3);
					String khoa = (String) modelsv.getValueAt(choiceObj, 4);
					String chuyen = (String) modelsv.getValueAt(choiceObj, 5);
					svb.sua(magv, new GiangVien(magv, tengv, email, sdt, khoa, chuyen));
				}
			}
		});
	}

	public void LetThongTinTK(String matk) {
		TaiKhoanBUS tkb = new TaiKhoanBUS();
		TaiKhoan tk = tkb.timMaTK(matk);
		txtMaTK.setText(tk.getMaTK());
		txtTenDN.setText(tk.getTenDN());
		txtMK.setText(tk.getMatKhau());
		txtEmail.setText(tk.getEmail());
		txtNgLap.setText(tk.getNgLap());

	}

	public void clearTable(DefaultTableModel model) {
		while (model.getRowCount() > 0)
			model.removeRow(0);
	}

	public void loadTableSV(ArrayList<SinhVienDTO> obj) {
		clearTable(modelsv);
		for (SinhVienDTO temp : obj) {
			modelsv.addRow(temp.toArray());
		}
	}

	public void loadTableGV(ArrayList<GiangVien> obj) {
		clearTable(modelgv);
		for (GiangVien temp : obj) {
			modelgv.addRow(temp.toArrayInfo());
		}
	}
}
