package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TKGVGUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

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
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(336, 83, 349, 23);
		panel.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Giảng Viên:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(142, 129, 127, 27);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(336, 133, 349, 23);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SDT:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(142, 178, 127, 27);
		panel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(336, 182, 349, 23);
		panel.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Khoa:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(142, 215, 127, 27);
		panel.add(lblNewLabel_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(336, 219, 349, 23);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Chuyên Ngành:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(142, 252, 127, 27);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(336, 256, 349, 23);
		panel.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Tên Đằng Nhập:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(142, 289, 127, 27);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(336, 293, 349, 23);
		panel.add(textField_5);
		
		JButton btnSuaTDN = new JButton("Đổi");
		btnSuaTDN.setBounds(695, 294, 85, 21);
		panel.add(btnSuaTDN);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Mật Khẩu:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(142, 326, 127, 27);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(336, 330, 349, 23);
		panel.add(textField_6);
		
		JButton btnSuaMK = new JButton("Đổi");
		btnSuaMK.setBounds(695, 331, 85, 21);
		panel.add(btnSuaMK);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Email:");
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(142, 363, 127, 27);
		panel.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(336, 367, 349, 23);
		panel.add(textField_7);
		
		JButton btnSuaE = new JButton("Đổi");
		btnSuaE.setBounds(695, 368, 85, 21);
		panel.add(btnSuaE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(219, 474, 899, 279);
		add(panel_1);
		
		JLabel lblDoiTT = new JLabel("TTTTTTTTTTTTTTTTTTTTTTTTTTT");
		lblDoiTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoiTT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDoiTT.setBounds(268, 10, 366, 31);
		panel_1.add(lblDoiTT);
		
		JLabel lblInfo1 = new JLabel("Mật Khẩu cũ:");
		lblInfo1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo1.setBounds(190, 65, 124, 31);
		panel_1.add(lblInfo1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(389, 72, 288, 24);
		panel_1.add(textField_8);
		
		JLabel lblInfo2 = new JLabel("Mật Khẩu cũ:");
		lblInfo2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo2.setBounds(190, 115, 124, 31);
		panel_1.add(lblInfo2);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(389, 122, 288, 24);
		panel_1.add(textField_9);
		
		JLabel lblInfo3 = new JLabel("Mật Khẩu cũ:");
		lblInfo3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo3.setBounds(190, 164, 124, 31);
		panel_1.add(lblInfo3);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(389, 171, 288, 24);
		panel_1.add(textField_10);
		
		JButton btnDone = new JButton("XONG");
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDone.setBounds(380, 232, 170, 37);
		panel_1.add(btnDone);
	}

}
