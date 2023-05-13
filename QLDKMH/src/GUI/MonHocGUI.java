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

public class MonHocGUI extends JPanel {
	private JTextField txtFind;
	private JTextField txtMaMH;
	private JTextField txtTenMH;
	private JTextField txtSTC;

	/**
	 * Create the panel.
	 */
	public MonHocGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH MÔN HỌC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(334, 48, 462, 41);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(247, 160, 681, 593);
		add(scrollPane);
		
		txtFind = new JTextField();
		txtFind.setBounds(383, 132, 259, 19);
		add(txtFind);
		txtFind.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(247, 134, 72, 13);
		add(lblNewLabel_1);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(698, 129, 85, 21);
		add(btnXoa);
		
		JToggleButton btnSua = new JToggleButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(796, 131, 115, 21);
		add(btnSua);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(938, 160, 301, 250);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("THÊM MÔN HỌC");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(58, 10, 197, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mã MH:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(68, 59, 45, 13);
		panel.add(lblNewLabel_3);
		
		txtMaMH = new JTextField();
		txtMaMH.setBounds(139, 57, 118, 19);
		panel.add(txtMaMH);
		txtMaMH.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tên MH:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(66, 97, 61, 13);
		panel.add(lblNewLabel_3_1);
		
		txtTenMH = new JTextField();
		txtTenMH.setColumns(10);
		txtTenMH.setBounds(137, 95, 118, 19);
		panel.add(txtTenMH);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Số TC:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_1.setBounds(68, 134, 61, 13);
		panel.add(lblNewLabel_3_1_1);
		
		txtSTC = new JTextField();
		txtSTC.setColumns(10);
		txtSTC.setBounds(139, 132, 118, 19);
		panel.add(txtSTC);
		
		JButton btnThem = new JButton("THÊM");
		btnThem.setBounds(170, 182, 85, 50);
		panel.add(btnThem);
	}

}
