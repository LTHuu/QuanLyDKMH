package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class LichThiGUI extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public LichThiGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(401, 10, 584, 308);
		add(panel);
		
		JLabel lblNewLable_0 = new JLabel("Mã SV:");
		lblNewLable_0.setBounds(135, 54, 83, 20);
		panel.add(lblNewLable_0);
		
		JLabel lblTnSv = new JLabel("Tên SV:");
		lblTnSv.setBounds(135, 84, 83, 20);
		panel.add(lblTnSv);
		
		JLabel lblMaSV_1_1 = new JLabel("Giới Tính:");
		lblMaSV_1_1.setBounds(135, 114, 83, 20);
		panel.add(lblMaSV_1_1);
		
		JLabel lblMaSV_1_1_1 = new JLabel("Khoa:");
		lblMaSV_1_1_1.setBounds(135, 144, 83, 20);
		panel.add(lblMaSV_1_1_1);
		
		JLabel lblMaSV_1_1_1_1 = new JLabel("Số Tín Chỉ::");
		lblMaSV_1_1_1_1.setBounds(135, 174, 83, 20);
		panel.add(lblMaSV_1_1_1_1);
		
		JLabel lblMaSV_1_1_1_1_1 = new JLabel("Số Tiền/Tín Chỉ::");
		lblMaSV_1_1_1_1_1.setBounds(135, 204, 97, 20);
		panel.add(lblMaSV_1_1_1_1_1);
		
		JLabel lblMaSV_1_1_1_1_1_1 = new JLabel("Tổng Số Tiền::");
		lblMaSV_1_1_1_1_1_1.setBounds(135, 234, 83, 20);
		panel.add(lblMaSV_1_1_1_1_1_1);
		
		JLabel lblMaSV_1_1_1_1_1_1_1 = new JLabel("Ngày Đóng:");
		lblMaSV_1_1_1_1_1_1_1.setBounds(135, 264, 83, 20);
		panel.add(lblMaSV_1_1_1_1_1_1_1);
		
		JLabel lblMaSV = new JLabel("");
		lblMaSV.setBounds(228, 54, 238, 20);
		panel.add(lblMaSV);
		
		JLabel lblTenSV = new JLabel("");
		lblTenSV.setBounds(228, 84, 238, 20);
		panel.add(lblTenSV);
		
		JLabel lblGioiTinh = new JLabel("");
		lblGioiTinh.setBounds(228, 114, 238, 20);
		panel.add(lblGioiTinh);
		
		JLabel lblKhoa = new JLabel("");
		lblKhoa.setBounds(228, 144, 238, 20);
		panel.add(lblKhoa);
		
		JLabel lblSTC = new JLabel("");
		lblSTC.setBounds(228, 174, 238, 20);
		panel.add(lblSTC);
		
		JLabel lblTienTC = new JLabel("");
		lblTienTC.setBounds(228, 204, 238, 20);
		panel.add(lblTienTC);
		
		JLabel lblTongTien = new JLabel("");
		lblTongTien.setBounds(228, 234, 238, 20);
		panel.add(lblTongTien);
		
		JLabel lblNgDong = new JLabel("");
		lblNgDong.setBounds(228, 264, 238, 20);
		panel.add(lblNgDong);
		
		JLabel lblNewLabel_8 = new JLabel("Học kì: . Năm học: ");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(57, 10, 466, 34);
		panel.add(lblNewLabel_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(99, 367, 1082, 386);
		add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Mã SV:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(110, 325, 73, 33);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(193, 334, 356, 25);
		add(textField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(559, 336, 267, 21);
		add(comboBox);
		
		JButton btnTK = new JButton("Tìm");
		btnTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTK.setBounds(829, 328, 60, 33);
		add(btnTK);
	}

}
