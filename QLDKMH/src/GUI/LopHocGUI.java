package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class LopHocGUI extends JPanel {
	private JTextField txtFind;
	private JTextField txtMaLop;
	private JTextField txtTenLop;
	private JTextField txtNam;

	/**
	 * Create the panel.
	 */
	public LopHocGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh sách lớp học");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(297, 153, 297, 57);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 304, 1182, 449);
		add(scrollPane);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBounds(248, 259, 85, 21);
		add(btnXoa);
		
		JToggleButton btnSua = new JToggleButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSua.setBounds(343, 259, 79, 21);
		add(btnSua);
		
		txtFind = new JTextField();
		txtFind.setBounds(463, 256, 211, 24);
		add(txtFind);
		txtFind.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(784, 10, 408, 283);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thêm Lớp Học");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(63, 10, 271, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã lớp:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 55, 65, 15);
		panel.add(lblNewLabel_2);
		
		txtMaLop = new JTextField();
		txtMaLop.setBounds(98, 50, 177, 19);
		panel.add(txtMaLop);
		txtMaLop.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên lớp:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(10, 87, 65, 15);
		panel.add(lblNewLabel_2_1);
		
		txtTenLop = new JTextField();
		txtTenLop.setColumns(10);
		txtTenLop.setBounds(98, 82, 177, 19);
		panel.add(txtTenLop);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Năm học:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1.setBounds(10, 123, 65, 15);
		panel.add(lblNewLabel_2_1_1);
		
		txtNam = new JTextField();
		txtNam.setColumns(10);
		txtNam.setBounds(98, 118, 177, 19);
		panel.add(txtNam);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Hệ đào tạo:");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1.setBounds(10, 154, 71, 15);
		panel.add(lblNewLabel_2_1_1_1);
		
		JComboBox cBoxHDT = new JComboBox();
		cBoxHDT.setBounds(98, 147, 177, 30);
		panel.add(cBoxHDT);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Khoa:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1_1.setBounds(10, 194, 71, 15);
		panel.add(lblNewLabel_2_1_1_1_1);
		
		JComboBox cBoxKhoa = new JComboBox();
		cBoxKhoa.setBounds(98, 187, 177, 30);
		panel.add(cBoxKhoa);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBounds(162, 227, 115, 30);
		panel.add(btnNewButton);
	}
}
