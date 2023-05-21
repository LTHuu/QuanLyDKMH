package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import BUS.ChuyenNganhBUS;
import BUS.GiangVienBUS;
import BUS.KhoaBUS;
import BUS.SinhVienBUS;
import BUS.TaiKhoanBUS;
import DTO.GiangVien;
import DTO.SinhVienDTO;
import DTO.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class TKGVGUI extends JPanel {
	private JTextField txtTenGV;
	private JTextField txtMaGV;
	private JTextField txtSDT;
	private JTextField txtKhoa;
	private JTextField txtCN;
	private JTextField txtTenDN;
	private JTextField txtEmail;
	private JTextField txtInfo2;
	private JTextField txtMaKhoa;
	private JTextField txtMaCN;
	private JPasswordField txtMatKhau;
	private JPanel panel_1;
	private JLabel lblDoiTT;
	private JLabel lblInfo1;
	private JLabel lblInfo2;
	private JLabel lblNgLap;
	private JPasswordField txtInfo1;
	private JButton btnDone;
	private JButton btnSuaE;
	private JButton btnSuaMK;
	private JButton btnSuaTDN;
	
	private int Sua = 0;

	/**
	 * Create the panel.
	 */
	public TKGVGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(219, 10, 899, 428);
		add(panel);

		JLabel lblThngTinGing = new JLabel("Thông Tin Giảng Viên");
		lblThngTinGing.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinGing.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThngTinGing.setBounds(229, 10, 419, 40);
		panel.add(lblThngTinGing);

		JLabel lblNewLabel_1 = new JLabel("Họ Tên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(142, 79, 127, 27);
		panel.add(lblNewLabel_1);

		txtTenGV = new JTextField();
		txtTenGV.setEnabled(false);
		txtTenGV.setEditable(false);
		txtTenGV.setColumns(10);
		txtTenGV.setBounds(336, 83, 349, 23);
		panel.add(txtTenGV);

		JLabel lblNewLabel_1_1 = new JLabel("Mã Giảng Viên:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(142, 129, 127, 27);
		panel.add(lblNewLabel_1_1);

		txtMaGV = new JTextField();
		txtMaGV.setEnabled(false);
		txtMaGV.setEditable(false);
		txtMaGV.setColumns(10);
		txtMaGV.setBounds(336, 133, 349, 23);
		panel.add(txtMaGV);

		JLabel lblNewLabel_1_1_1 = new JLabel("SDT:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(142, 178, 127, 27);
		panel.add(lblNewLabel_1_1_1);

		txtSDT = new JTextField();
		txtSDT.setEnabled(false);
		txtSDT.setEditable(false);
		txtSDT.setColumns(10);
		txtSDT.setBounds(336, 182, 349, 23);
		panel.add(txtSDT);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Khoa:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(142, 215, 127, 27);
		panel.add(lblNewLabel_1_1_1_1);

		txtKhoa = new JTextField();
		txtKhoa.setEnabled(false);
		txtKhoa.setEditable(false);
		txtKhoa.setColumns(10);
		txtKhoa.setBounds(336, 219, 175, 23);
		panel.add(txtKhoa);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Chuyên Ngành:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(142, 252, 127, 27);
		panel.add(lblNewLabel_1_1_1_1_1);

		txtCN = new JTextField();
		txtCN.setEnabled(false);
		txtCN.setEditable(false);
		txtCN.setColumns(10);
		txtCN.setBounds(336, 256, 169, 23);
		panel.add(txtCN);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Tên Đằng Nhập:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(142, 289, 127, 27);
		panel.add(lblNewLabel_1_1_1_1_1_1);

		txtTenDN = new JTextField();
		txtTenDN.setEditable(false);
		txtTenDN.setEnabled(false);
		txtTenDN.setColumns(10);
		txtTenDN.setBounds(336, 293, 349, 23);
		panel.add(txtTenDN);

		btnSuaTDN = new JButton("Đổi");
		btnSuaTDN.setBounds(695, 294, 85, 21);
		panel.add(btnSuaTDN);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Mật Khẩu:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(142, 326, 127, 27);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);

		btnSuaMK = new JButton("Đổi");
		btnSuaMK.setBounds(695, 331, 85, 21);
		panel.add(btnSuaMK);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Email:");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(142, 363, 127, 27);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);

		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(336, 367, 349, 23);
		panel.add(txtEmail);

		btnSuaE = new JButton("Đổi");
		btnSuaE.setBounds(695, 368, 85, 21);
		panel.add(btnSuaE);

		txtMaKhoa = new JTextField();
		txtMaKhoa.setEnabled(false);
		txtMaKhoa.setEditable(false);
		txtMaKhoa.setColumns(10);
		txtMaKhoa.setBounds(510, 219, 175, 23);
		panel.add(txtMaKhoa);

		txtMaCN = new JTextField();
		txtMaCN.setEnabled(false);
		txtMaCN.setEditable(false);
		txtMaCN.setColumns(10);
		txtMaCN.setBounds(515, 256, 169, 23);
		panel.add(txtMaCN);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setEditable(false);
		txtMatKhau.setEnabled(false);
		txtMatKhau.setBounds(336, 332, 349, 23);
		panel.add(txtMatKhau);

		lblNgLap = new JLabel("");
		lblNgLap.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgLap.setBounds(712, 79, 142, 27);
		panel.add(lblNgLap);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(219, 474, 899, 279);
		add(panel_1);

		lblDoiTT = new JLabel("TTTTTTTTTTTTTTTTTTTTTTTTTTT");
		lblDoiTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoiTT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDoiTT.setBounds(268, 10, 366, 31);
		panel_1.setVisible(false);
		panel_1.add(lblDoiTT);

		lblInfo1 = new JLabel("Mật Khẩu cũ:");
		lblInfo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo1.setBounds(190, 65, 124, 31);
		panel_1.add(lblInfo1);

		txtInfo2 = new JTextField();
		txtInfo2.setColumns(10);
		txtInfo2.setBounds(380, 120, 288, 24);
		panel_1.add(txtInfo2);

		lblInfo2 = new JLabel("Mật Khẩu cũ:");
		lblInfo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo2.setBounds(190, 115, 124, 31);
		panel_1.add(lblInfo2);

		btnDone = new JButton("XONG");
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDone.setBounds(380, 232, 170, 37);
		panel_1.add(btnDone);
		
		txtInfo1 = new JPasswordField();
		txtInfo1.setBounds(380, 70, 286, 24);
		panel_1.add(txtInfo1);
		
		TinhNang();
	}
	
	public void TinhNang() {

		btnSuaTDN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Sua = 1;
				panel_1.setVisible(true);
				lblDoiTT.setText("ĐỔI TÊN ĐĂNG NHẬP");
				lblInfo1.setText("Nhập mật khẩu: ");
				lblInfo2.setText("Nhập Tên Đăng Nhập Mới: ");
			}
		});

		btnSuaE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Sua = 3;
				panel_1.setVisible(true);
				lblDoiTT.setText("ĐỔI TÊN ĐĂNG NHẬP");
				lblInfo1.setText("Nhập mật khẩu: ");
				lblInfo2.setText("Nhập Email mới: ");
			}
		});

		btnSuaMK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Sua = 2;
				panel_1.setVisible(true);
				lblDoiTT.setText("ĐỔI TÊN MẬT KHẨU");
				lblInfo1.setText("Nhập mật khẩu cũ: ");
				lblInfo2.setText("Nhập mật khẩu mới: ");
			}
		});

		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch (Sua) {
				case 1: { // Đổi tên đăng nhập
					if (checkMatKhau()) {
						txtTenDN.setText(txtInfo2.getText());
						updateTK();
						JOptionPane.showMessageDialog(null, "Đổi tên đăng nhập thành công!");
						panel_1.setVisible(false);
					}
					break;
				}
				case 2: { // Đổi mật khẩu
					if (checkMatKhau()) {
						txtMatKhau.setText(txtInfo2.getText());
						updateTK();
						JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!");
						panel_1.setVisible(false);
					}
					break;
				}
				case 3: { // Đổi email
					if (checkMatKhau()) {
						txtEmail.setText(txtInfo2.getText());
						updateTK();
						JOptionPane.showMessageDialog(null, "Đổi email thành công!");
						panel_1.setVisible(false);
					}
					break;
				}
				}
			}
		});
	}
	
	public boolean checkMatKhau() {
		String mkcu = Arrays.toString(txtMatKhau.getPassword()).replaceAll(", ", "");
		mkcu = mkcu.substring(1, mkcu.length() - 1);
		String mknhap = Arrays.toString(txtInfo1.getPassword()).replaceAll(", ", "");
		mknhap = mknhap.substring(1, mknhap.length() - 1);
		if (mkcu.equals(mknhap)) {
			return true;
		}
		return false;
	}

	public void updateGV() {
		String magv = txtMaGV.getText();
		String tengv = txtTenGV.getText();
		String sdt = txtSDT.getText();
		String khoa = txtMaKhoa.getText();
		String email = txtEmail.getText();
		String cn = txtMaCN.getText();
		GiangVienBUS gv = new GiangVienBUS();
		gv.sua(cn, new GiangVien(magv, tengv, email, sdt, khoa, cn));
	}

	public void updateTK() {
		String matk = txtMaGV.getText();
		String tendn = txtTenDN.getText();
		String mk = Arrays.toString(txtMatKhau.getPassword());
		mk = mk.replaceAll(", ", "");
		mk = mk.substring(1, mk.length() - 1);
		String nglap = lblNgLap.getText();
		String email = txtEmail.getText();
		TaiKhoanBUS tkb = new TaiKhoanBUS();
		tkb.sua(matk, new TaiKhoan(matk, tendn, mk, nglap, email));
	}

	public void LetThongTinGV(String MaGV) {
		GiangVienBUS gvb = new GiangVienBUS();
		GiangVien tsv = gvb.timMaGV(MaGV);
		KhoaBUS kb = new KhoaBUS();
		txtTenGV.setText(tsv.getTenGV());
		txtMaGV.setText(MaGV);
		txtMaKhoa.setText(tsv.getKhoa());
		txtKhoa.setText(kb.timMaKhoa(tsv.getKhoa()).getTenKhoa());
		TaiKhoanBUS tkb = new TaiKhoanBUS();
		TaiKhoan ttk = tkb.timMaTK(MaGV);
		txtSDT.setText(tsv.getSDT());
		ChuyenNganhBUS cnb = new ChuyenNganhBUS();
		txtMaCN.setText(tsv.getChuyen());
		txtCN.setText(cnb.timMaCN(txtMaCN.getText()).getTenCn());
		txtTenDN.setText(ttk.getTenDN());
		txtMatKhau.setText(ttk.getMatKhau());
		txtEmail.setText(ttk.getEmail());
		lblNgLap.setText(ttk.getNgLap());
	}

	public void setMaGV(String masv) {
		LetThongTinGV(masv);
	}
}
