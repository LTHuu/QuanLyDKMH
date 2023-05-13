package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class LichThiADGUI extends JPanel {
	private JTextField txtFindHP;
	private JTextField txtMaKT;
	private JTextField txtMaHP;
	private JTextField txtTGBD;
	private JTextField txtLKT;

	/**
	 * Create the panel.
	 */
	public LichThiADGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH HỌC PHẦN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(105, 42, 440, 47);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 710, 579);
		add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 137, 43, 27);
		add(lblNewLabel_1);
		
		txtFindHP = new JTextField();
		txtFindHP.setBounds(63, 145, 241, 19);
		add(txtFindHP);
		txtFindHP.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(730, 117, 509, 260);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Thêm Lịch Kiểm Tra");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(162, 10, 186, 27);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mã Kiểm Tra:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 97, 81, 27);
		panel.add(lblNewLabel_4);
		
		txtMaKT = new JTextField();
		txtMaKT.setBounds(131, 97, 172, 22);
		panel.add(txtMaKT);
		txtMaKT.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mã Học Phần:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(10, 60, 81, 27);
		panel.add(lblNewLabel_4_1);
		
		txtMaHP = new JTextField();
		txtMaHP.setColumns(10);
		txtMaHP.setBounds(131, 60, 172, 22);
		panel.add(txtMaHP);
		
		JLabel lblNewLabel_4_2 = new JLabel("Ngày Kiểm Tra:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4_2.setBounds(10, 134, 111, 27);
		panel.add(lblNewLabel_4_2);
		
		JLabel lblNgKT = new JLabel("");
		lblNgKT.setBounds(131, 129, 172, 33);
		panel.add(lblNgKT);
		
		JButton btnGetDate = new JButton("....");
		btnGetDate.setBounds(312, 133, 36, 21);
		panel.add(btnGetDate);
		
		JLabel lblNewLabel_5 = new JLabel("Giờ Bắt Đầu:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 171, 111, 22);
		panel.add(lblNewLabel_5);
		
		txtTGBD = new JTextField();
		txtTGBD.setColumns(10);
		txtTGBD.setBounds(131, 172, 172, 22);
		panel.add(txtTGBD);
		
		JLabel lblNewLabel_5_1 = new JLabel("Loại Kiểm Tra:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_1.setBounds(10, 203, 111, 22);
		panel.add(lblNewLabel_5_1);
		
		txtLKT = new JTextField();
		txtLKT.setColumns(10);
		txtLKT.setBounds(131, 204, 172, 22);
		panel.add(txtLKT);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(351, 191, 132, 48);
		panel.add(btnThem);
		
		JLabel lblNewLabel_2 = new JLabel("DANH SÁCH LỊCH KIỂM TRA");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(959, 387, 280, 47);
		add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(730, 444, 509, 309);
		add(scrollPane_1);
		
		JButton btnXóa = new JButton("Xóa");
		btnXóa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXóa.setBounds(734, 411, 93, 27);
		add(btnXóa);
		
		JToggleButton btnSua = new JToggleButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(846, 411, 103, 27);
		add(btnSua);
		
		
	}

}
