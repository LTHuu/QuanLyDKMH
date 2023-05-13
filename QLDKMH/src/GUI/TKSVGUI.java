package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TKSVGUI extends JPanel {
	private JTextField txtTenSV;
	private JTextField txtMaSV;
	private JTextField txtSDT;
	private JTextField txtKhoa;
	private JTextField txtDC;
	private JTextField txtTenDN;
	private JTextField txtMatKhau;
	private JTextField txtEmail;
	private JTextField txtMKCu;
	private JTextField txtInfo2;
	private JTextField txtInfo3;
	private JLabel lblInfo1;

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
		txtKhoa.setBounds(336, 219, 349, 23);
		panel.add(txtKhoa);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(142, 252, 127, 27);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		txtDC = new JTextField();
		txtDC.setEnabled(false);
		txtDC.setEditable(false);
		txtDC.setColumns(10);
		txtDC.setBounds(336, 256, 349, 23);
		panel.add(txtDC);
		
		JButton btnSuaDC = new JButton("Sửa");
		btnSuaDC.setBounds(695, 257, 85, 21);
		panel.add(btnSuaDC);
		
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
		
		JButton btnSuaTDN = new JButton("Đổi");
		btnSuaTDN.setBounds(695, 294, 85, 21);
		panel.add(btnSuaTDN);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Mật Khẩu:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(142, 326, 127, 27);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setEnabled(false);
		txtMatKhau.setEditable(false);
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(336, 330, 349, 23);
		panel.add(txtMatKhau);
		
		JButton btnSuaMK = new JButton("Đổi");
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
		
		JButton btnSuaE = new JButton("Đổi");
		btnSuaE.setBounds(695, 368, 85, 21);
		panel.add(btnSuaE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(192, 474, 899, 279);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDoiTT = new JLabel("TTTTTTTTTTTTTTTTTTTTTTTTTTT");
		lblDoiTT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDoiTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoiTT.setBounds(268, 10, 366, 31);
		panel_1.add(lblDoiTT);
		
		lblInfo1 = new JLabel("Mật Khẩu cũ:");
		lblInfo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo1.setBounds(190, 65, 124, 31);
		panel_1.add(lblInfo1);
		
		txtMKCu = new JTextField();
		txtMKCu.setBounds(389, 72, 288, 24);
		panel_1.add(txtMKCu);
		txtMKCu.setColumns(10);
		
		JLabel lblInfo2 = new JLabel("Mật Khẩu cũ:");
		lblInfo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo2.setBounds(190, 115, 124, 31);
		panel_1.add(lblInfo2);
		
		txtInfo2 = new JTextField();
		txtInfo2.setColumns(10);
		txtInfo2.setBounds(389, 122, 288, 24);
		panel_1.add(txtInfo2);
		
		JLabel lblInfo3 = new JLabel("Mật Khẩu cũ:");
		lblInfo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo3.setBounds(190, 164, 124, 31);
		panel_1.add(lblInfo3);
		
		txtInfo3 = new JTextField();
		txtInfo3.setColumns(10);
		txtInfo3.setBounds(389, 171, 288, 24);
		panel_1.add(txtInfo3);
		
		JButton btnDone = new JButton("XONG");
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDone.setBounds(380, 232, 170, 37);
		panel_1.add(btnDone);
	}

}
