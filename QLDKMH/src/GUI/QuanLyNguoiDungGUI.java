package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

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

	/**
	 * Create the panel.
	 */
	public QuanLyNguoiDungGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 797, 661);
		add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH GIẢNG VIÊN/SINH VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(135, 10, 578, 25);
		add(lblNewLabel);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBounds(10, 64, 85, 21);
		add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSua.setBounds(105, 65, 85, 21);
		add(btnSua);
		
		txtFind = new JTextField();
		txtFind.setBounds(195, 66, 284, 21);
		add(txtFind);
		txtFind.setColumns(10);
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton radAll = new JRadioButton("Tất cả");
		radAll.setSelected(true);
		radAll.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radAll.setBounds(492, 65, 59, 21);
		add(radAll);
		group.add(radAll);
		
		JRadioButton radGiangVien = new JRadioButton("Giảng Viên");
		radGiangVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radGiangVien.setBounds(563, 65, 85, 21);
		add(radGiangVien);
		group.add(radGiangVien);
		
		JRadioButton radSinhVien = new JRadioButton("Sinh Viên");
		radSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		radSinhVien.setBounds(660, 65, 85, 21);
		add(radSinhVien);
		group.add(radSinhVien);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(817, 95, 422, 339);
		add(panel);
		panel.setLayout(null);
		
		JLabel lbThongTin = new JLabel("THÔNG TIN");
		lbThongTin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbThongTin.setHorizontalAlignment(SwingConstants.CENTER);
		lbThongTin.setBounds(100, 10, 232, 33);
		panel.add(lbThongTin);
		
		JLabel lblInfo1 = new JLabel("Mã:");
		lblInfo1.setBounds(10, 63, 117, 27);
		panel.add(lblInfo1);
		
		txtInfo1 = new JTextField();
		txtInfo1.setBounds(137, 67, 232, 19);
		panel.add(txtInfo1);
		txtInfo1.setColumns(10);
		
		JLabel lblInfo2 = new JLabel("Mã:");
		lblInfo2.setBounds(10, 100, 117, 27);
		panel.add(lblInfo2);
		
		txtInfo2 = new JTextField();
		txtInfo2.setColumns(10);
		txtInfo2.setBounds(137, 104, 232, 19);
		panel.add(txtInfo2);
		
		JLabel lblInfo3 = new JLabel("Mã:");
		lblInfo3.setBounds(10, 137, 117, 27);
		panel.add(lblInfo3);
		
		txtInfo3 = new JTextField();
		txtInfo3.setColumns(10);
		txtInfo3.setBounds(137, 141, 232, 19);
		panel.add(txtInfo3);
		
		JLabel lblInfo4 = new JLabel("Mã:");
		lblInfo4.setBounds(10, 174, 117, 27);
		panel.add(lblInfo4);
		
		txtInfo4 = new JTextField();
		txtInfo4.setColumns(10);
		txtInfo4.setBounds(137, 178, 232, 19);
		panel.add(txtInfo4);
		
		JLabel lblInfo5 = new JLabel("Mã:");
		lblInfo5.setBounds(10, 211, 117, 27);
		panel.add(lblInfo5);
		
		txtInfo5 = new JTextField();
		txtInfo5.setColumns(10);
		txtInfo5.setBounds(137, 215, 232, 19);
		panel.add(txtInfo5);
		
		JLabel lblInfo6 = new JLabel("Mã:");
		lblInfo6.setBounds(10, 248, 117, 27);
		panel.add(lblInfo6);
		
		txtInfo6 = new JTextField();
		txtInfo6.setColumns(10);
		txtInfo6.setBounds(137, 252, 232, 19);
		panel.add(txtInfo6);
		
		JButton btnThemTT = new JButton("THÊM");
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
		txtMaTK.setColumns(10);
		txtMaTK.setBounds(137, 67, 232, 19);
		panel_1.add(txtMaTK);
		
		JLabel lblTnngNhp = new JLabel("Tên Đăng Nhập:");
		lblTnngNhp.setBounds(10, 100, 117, 27);
		panel_1.add(lblTnngNhp);
		
		txtTenDN = new JTextField();
		txtTenDN.setColumns(10);
		txtTenDN.setBounds(137, 104, 232, 19);
		panel_1.add(txtTenDN);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setBounds(10, 137, 117, 27);
		panel_1.add(lblMtKhu);
		
		txtMK = new JTextField();
		txtMK.setColumns(10);
		txtMK.setBounds(137, 141, 232, 19);
		panel_1.add(txtMK);
		
		JLabel lblNgyLp = new JLabel("Ngày lập:");
		lblNgyLp.setBounds(10, 211, 117, 27);
		panel_1.add(lblNgyLp);
		
		txtEmail = new JTextField();
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
		
		JButton btnThemTTTK = new JButton("THÊM");
		btnThemTTTK.setBounds(247, 244, 122, 39);
		panel_1.add(btnThemTTTK);
	}
}
