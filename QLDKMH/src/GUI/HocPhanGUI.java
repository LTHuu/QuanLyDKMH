package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JFormattedTextField;

public class HocPhanGUI extends JPanel {
	private JTextField textField;
	private JTextField txtNgBDFind;
	private JTextField txtNgKTFind;
	private JTextField txtMaHP;
	private JTextField txtTenHP;
	private JTextField txtNgBD;
	private JTextField txtNgKT;
	private JTextField txtHK;
	private JTextField txtMaMH;
	private JTextField txtMaGV;

	/**
	 * Create the panel.
	 */
	public HocPhanGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH HỌC PHẦN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(104, 36, 498, 49);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 183, 728, 570);
		add(scrollPane);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(10, 136, 85, 37);
		add(btnXoa);
		
		JToggleButton btnSua = new JToggleButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSua.setBounds(104, 136, 78, 37);
		add(btnSua);
		
		JRadioButton radConHL = new JRadioButton("Còn hiệu lực");
		radConHL.setBounds(276, 91, 103, 21);
		add(radConHL);
		
		JRadioButton radHetHL = new JRadioButton("Hết hiệu lực");
		radHetHL.setBounds(381, 91, 103, 21);
		add(radHetHL);
		
		JRadioButton radAll = new JRadioButton("Tất cả");
		radAll.setSelected(true);
		radAll.setActionCommand("Tát cả");
		radAll.setBounds(206, 91, 55, 21);
		add(radAll);
		
		textField = new JTextField();
		textField.setBounds(192, 136, 301, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("từ ngày:");
		lblNewLabel_1.setBounds(192, 160, 45, 13);
		add(lblNewLabel_1);
		
		txtNgBDFind = new JTextField();
		txtNgBDFind.setEditable(false);
		txtNgBDFind.setEnabled(false);
		txtNgBDFind.setBounds(236, 157, 96, 19);
		add(txtNgBDFind);
		txtNgBDFind.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("đến ngày:");
		lblNewLabel_1_1.setBounds(342, 160, 55, 13);
		add(lblNewLabel_1_1);
		
		txtNgKTFind = new JTextField();
		txtNgKTFind.setEditable(false);
		txtNgKTFind.setEnabled(false);
		txtNgKTFind.setColumns(10);
		txtNgKTFind.setBounds(397, 157, 96, 19);
		add(txtNgKTFind);
		
		JButton btnTim = new JButton("TÌM");
		btnTim.setBounds(517, 135, 62, 38);
		add(btnTim);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(748, 36, 473, 717);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("THÊM HỌC PHẦN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(108, 10, 263, 37);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mã Học Phần:");
		lblNewLabel_3.setBounds(23, 60, 79, 27);
		panel.add(lblNewLabel_3);
		
		txtMaHP = new JTextField();
		txtMaHP.setBounds(128, 64, 219, 23);
		panel.add(txtMaHP);
		txtMaHP.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tên Học Phần:");
		lblNewLabel_3_1.setBounds(23, 107, 79, 27);
		panel.add(lblNewLabel_3_1);
		
		txtTenHP = new JTextField();
		txtTenHP.setColumns(10);
		txtTenHP.setBounds(128, 111, 219, 23);
		panel.add(txtTenHP);
		
		JLabel lblNewLabel_3_2 = new JLabel("Ngày Bắt Đầu:");
		lblNewLabel_3_2.setBounds(23, 148, 79, 27);
		panel.add(lblNewLabel_3_2);
		
		txtNgBD = new JTextField();
		txtNgBD.setEnabled(false);
		txtNgBD.setEditable(false);
		txtNgBD.setColumns(10);
		txtNgBD.setBounds(128, 152, 219, 23);
		panel.add(txtNgBD);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Ngày Kết Thúc:");
		lblNewLabel_3_2_1.setBounds(23, 185, 79, 27);
		panel.add(lblNewLabel_3_2_1);
		
		txtNgKT = new JTextField();
		txtNgKT.setEnabled(false);
		txtNgKT.setEditable(false);
		txtNgKT.setColumns(10);
		txtNgKT.setBounds(128, 189, 219, 23);
		panel.add(txtNgKT);
		
		JLabel lblNewLabel_4 = new JLabel("Học Kì:");
		lblNewLabel_4.setBounds(23, 222, 79, 23);
		panel.add(lblNewLabel_4);
		
		txtHK = new JTextField();
		txtHK.setEnabled(false);
		txtHK.setEditable(false);
		txtHK.setHorizontalAlignment(SwingConstants.CENTER);
		txtHK.setBounds(128, 224, 178, 21);
		panel.add(txtHK);
		txtHK.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Mã Môn Học:");
		lblNewLabel_5.setBounds(23, 265, 91, 21);
		panel.add(lblNewLabel_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 296, 424, 154);
		panel.add(scrollPane_1);
		
		txtMaMH = new JTextField();
		txtMaMH.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaMH.setEnabled(false);
		txtMaMH.setEditable(false);
		txtMaMH.setColumns(10);
		txtMaMH.setBounds(128, 266, 178, 21);
		panel.add(txtMaMH);
		
		JButton btnThem = new JButton("THÊM");
		btnThem.setBounds(361, 648, 91, 45);
		panel.add(btnThem);
		
		JLabel lblNewLabel_6 = new JLabel("Tiết học:");
		lblNewLabel_6.setBounds(23, 511, 62, 27);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Thêm Tiết Học");
		btnNewButton.setBounds(112, 514, 148, 23);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(23, 548, 424, 81);
		panel.add(scrollPane_2);
		
		JLabel lblNewLabel_5_1 = new JLabel("Mã GV:");
		lblNewLabel_5_1.setBounds(23, 471, 91, 21);
		panel.add(lblNewLabel_5_1);
		
		txtMaGV = new JTextField();
		txtMaGV.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaGV.setEnabled(false);
		txtMaGV.setEditable(false);
		txtMaGV.setColumns(10);
		txtMaGV.setBounds(128, 472, 178, 21);
		panel.add(txtMaGV);
		
		JButton btnNewButton_1 = new JButton("Thêm Phân Công");
		btnNewButton_1.setBounds(314, 471, 133, 21);
		panel.add(btnNewButton_1);
	}
}
