package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import BUS.KhoaBUS;
import BUS.SinhVienBUS;
import BUS.TaiKhoanBUS;
import DTO.SinhVienDTO;
import DTO.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;

public class TKSVGUI extends JPanel {
	private JTextField txtTenSV;
	private JTextField txtMaSV;
	private JTextField txtSDT;
	private JTextField txtKhoa;
	private JTextField txtDC;
	private JTextField txtTenDN;
	private JTextField txtEmail;
	private JTextField txtInfo2;
	private JLabel lblInfo1;
	private JPasswordField txtInfo1;
	private JPasswordField txtMatKhau;
	private JPanel panel_1;
	private JButton btnSuaTDN;
	private JButton btnSuaMK;
	private JButton btnSuaE;
	private JButton btnDone;
	private JToggleButton btnSuaDC;
	private JTextField txtMaKhoa;
	private JLabel lblNgLap;
	private JLabel lblInfo2;

	private int Sua = 0;
	private JLabel lblDoiTT;

	/**
	 * Create the panel.
	 */
	public TKSVGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(192, 26, 899, 428);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thông Tin Sinh Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(229, 10, 419, 40);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Họ Tên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(142, 79, 127, 27);
		panel.add(lblNewLabel_1);

		txtTenSV = new JTextField();
		txtTenSV.setEditable(false);
		txtTenSV.setEnabled(false);
		txtTenSV.setBounds(336, 83, 349, 23);
		panel.add(txtTenSV);
		txtTenSV.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Mã Sinh Viên:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(142, 129, 127, 27);
		panel.add(lblNewLabel_1_1);

		txtMaSV = new JTextField();
		txtMaSV.setEnabled(false);
		txtMaSV.setEditable(false);
		txtMaSV.setColumns(10);
		txtMaSV.setBounds(336, 133, 349, 23);
		panel.add(txtMaSV);

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
		txtKhoa.setBounds(336, 219, 172, 23);
		panel.add(txtKhoa);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(142, 252, 127, 27);
		panel.add(lblNewLabel_1_1_1_1_1);

		txtDC = new JTextField();
		txtDC.setEnabled(false);
		txtDC.setColumns(10);
		txtDC.setBounds(336, 256, 349, 23);
		panel.add(txtDC);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Tên Đằng Nhập:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(142, 289, 127, 27);
		panel.add(lblNewLabel_1_1_1_1_1_1);

		txtTenDN = new JTextField();
		txtTenDN.setEnabled(false);
		txtTenDN.setEditable(false);
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

		txtMatKhau = new JPasswordField();
		txtMatKhau.setEditable(false);
		txtMatKhau.setEnabled(false);
		txtMatKhau.setBounds(336, 332, 349, 23);
		panel.add(txtMatKhau);

		btnSuaDC = new JToggleButton("Sửa");
		btnSuaDC.setBounds(696, 258, 85, 21);
		panel.add(btnSuaDC);

		txtMaKhoa = new JTextField();
		txtMaKhoa.setEnabled(false);
		txtMaKhoa.setEditable(false);
		txtMaKhoa.setColumns(10);
		txtMaKhoa.setBounds(513, 219, 172, 23);
		panel.add(txtMaKhoa);

		lblNgLap = new JLabel("");
		lblNgLap.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgLap.setBounds(717, 81, 172, 27);
		panel.add(lblNgLap);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(192, 474, 899, 279);
		add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);

		lblDoiTT = new JLabel("TTTTTTTTTTTTTTTTTTTTTTTTTTT");
		lblDoiTT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDoiTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoiTT.setBounds(268, 10, 366, 31);
		panel_1.add(lblDoiTT);

		lblInfo1 = new JLabel("Mật Khẩu cũ:");
		lblInfo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo1.setBounds(190, 65, 124, 31);
		panel_1.add(lblInfo1);

		lblInfo2 = new JLabel("Mật Khẩu cũ:");
		lblInfo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo2.setBounds(190, 115, 124, 31);
		panel_1.add(lblInfo2);

		txtInfo2 = new JTextField();
		txtInfo2.setColumns(10);
		txtInfo2.setBounds(389, 122, 288, 24);
		panel_1.add(txtInfo2);

		btnDone = new JButton("XONG");
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDone.setBounds(380, 232, 170, 37);
		panel_1.add(btnDone);

		txtInfo1 = new JPasswordField();
		txtInfo1.setHorizontalAlignment(SwingConstants.CENTER);
		txtInfo1.setBounds(389, 72, 288, 24);
		panel_1.add(txtInfo1);

		TinhNang();
	}

	public void TinhNang() {
		btnSuaDC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel_1.setVisible(false);
				if (btnSuaDC.isSelected()) {
					txtDC.setEnabled(true);
				} else {
					updateSV();
					txtDC.setEnabled(false);
				}
			}
		});

		btnSuaTDN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSuaDC.setSelected(false);
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
				btnSuaDC.setSelected(false);
				Sua = 2;
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
				btnSuaDC.setSelected(false);
				Sua = 3;
				panel_1.setVisible(true);
				lblDoiTT.setText("ĐỔI TÊN MẬT KHẨU");
				lblInfo1.setText("Nhập mật khẩu cũ: ");
				lblInfo2.setText("Nhập mật khẩu mới: ");
			}
		});

		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("vào   22");
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
		System.out.println(mkcu);
		String mknhap = Arrays.toString(txtInfo1.getPassword()).replaceAll(", ", "");
		mknhap = mknhap.substring(1, mknhap.length() - 1);
		System.out.println(mknhap);
		if (mkcu.equals(mknhap)) {
			return true;
		}
		return false;
	}

	public void updateSV() {
		String masv = txtMaSV.getText();
		String tensv = txtTenSV.getText();
		String sdt = txtSDT.getText();
		String khoa = txtMaKhoa.getText();
		String dc = txtDC.getText();
		System.out.println(dc);
		SinhVienBUS temp = new SinhVienBUS();
		temp.sua(masv, new SinhVienDTO(masv, tensv, sdt, khoa, dc));
	}

	public void updateTK() {
		String matk = txtMaSV.getText();
		String tendn = txtTenDN.getText();
		String mk = Arrays.toString(txtMatKhau.getPassword());
		mk = mk.replaceAll(", ", "");
		mk = mk.substring(1, mk.length() - 1);
		String nglap = lblNgLap.getText();
		String email = txtEmail.getText();
		TaiKhoanBUS tkb = new TaiKhoanBUS();
		tkb.sua(matk, new TaiKhoan(matk, tendn, mk, nglap, email));
	}

	public void LetThongTinSV(String MaSV) {
		SinhVienBUS svb = new SinhVienBUS();
		SinhVienDTO tsv = svb.timMaSV(MaSV);
		KhoaBUS kb = new KhoaBUS();
		txtTenSV.setText(tsv.getTenSV());
		txtMaSV.setText(MaSV);
		txtMaKhoa.setText(tsv.getKhoa());
		txtKhoa.setText(kb.timMaKhoa(tsv.getKhoa()).getTenKhoa());
		TaiKhoanBUS tkb = new TaiKhoanBUS();
		TaiKhoan ttk = tkb.timMaTK(MaSV);
		txtSDT.setText(tsv.getSoDT());
		txtDC.setText(tsv.getDiaChi());
		txtTenDN.setText(ttk.getTenDN());
		txtMatKhau.setText(ttk.getMatKhau());
		txtEmail.setText(ttk.getEmail());
		lblNgLap.setText(ttk.getNgLap());
	}

	public void setMaSV(String masv) {
		LetThongTinSV(masv);
	}
}
