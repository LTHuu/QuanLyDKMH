package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.TietHocBUS;
import DTO.TietHoc;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JdialogThemTH extends JDialog {
	private JTextField txtMaTH;
	private JTextField txtMaLop;
	private JTextField txtMaPhong;
	private JTextField txtMaHP;
	private JButton btnXong;
	private JButton btnThem;
	private JComboBox BoxThu;
	private JComboBox BoxST;
	private JComboBox BoxLTH;
	private JComboBox BoxGioBD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JdialogThemTH dialog = new JdialogThemTH();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JdialogThemTH() {
		setBounds(100, 100, 450, 409);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("THÊM TIẾT HỌC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(65, 10, 283, 25);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã TH:");
		lblNewLabel_1.setBounds(75, 45, 66, 25);
		getContentPane().add(lblNewLabel_1);

		txtMaTH = new JTextField();
		txtMaTH.setBounds(151, 48, 166, 22);
		getContentPane().add(txtMaTH);
		txtMaTH.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Loại TH:");
		lblNewLabel_1_1.setBounds(75, 78, 66, 25);
		getContentPane().add(lblNewLabel_1_1);

		BoxLTH = new JComboBox();
		BoxLTH.setModel(new DefaultComboBoxModel(new String[] { "LY THUYET", "THUC HANH" }));
		BoxLTH.setBounds(151, 80, 166, 23);
		getContentPane().add(BoxLTH);

		JLabel lblNewLabel_1_1_1 = new JLabel("Giờ BD:");
		lblNewLabel_1_1_1.setBounds(75, 113, 66, 25);
		getContentPane().add(lblNewLabel_1_1_1);

		BoxGioBD = new JComboBox();
		BoxGioBD.setBounds(151, 115, 166, 23);
		BoxGioBD.setModel(new DefaultComboBoxModel(
				new String[] { "7:00", "7;50", "9:00", "9:50", "10:40", "13:00", "13:50", "15:00", "15:50", "16:40" }));
		getContentPane().add(BoxGioBD);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Giờ BD:");
		lblNewLabel_1_1_1_1.setBounds(75, 149, 66, 25);
		getContentPane().add(lblNewLabel_1_1_1_1);

		BoxThu = new JComboBox();
		BoxThu.setModel(new DefaultComboBoxModel(new String[] { "T2", "T3", "T4", "T5", "T6", "T7", "CN" }));
		BoxThu.setBounds(151, 151, 166, 23);
		getContentPane().add(BoxThu);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Số Tiết:");
		lblNewLabel_1_1_1_1_1.setBounds(75, 183, 66, 25);
		getContentPane().add(lblNewLabel_1_1_1_1_1);

		BoxST = new JComboBox();
		BoxST.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		BoxST.setBounds(151, 184, 59, 23);
		getContentPane().add(BoxST);

		JLabel lblNewLabel_2 = new JLabel("Mã lớp:");
		lblNewLabel_2.setBounds(75, 218, 66, 25);
		getContentPane().add(lblNewLabel_2);

		txtMaLop = new JTextField();
		txtMaLop.setColumns(10);
		txtMaLop.setBounds(151, 217, 166, 22);
		getContentPane().add(txtMaLop);

		JLabel lblNewLabel_2_1 = new JLabel("Mã phòng\r\n:");
		lblNewLabel_2_1.setBounds(75, 254, 66, 25);
		getContentPane().add(lblNewLabel_2_1);

		txtMaPhong = new JTextField();
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(151, 253, 166, 22);
		getContentPane().add(txtMaPhong);

		JLabel lblNewLabel_2_1_1 = new JLabel("Mã HP\r\n:");
		lblNewLabel_2_1_1.setBounds(75, 290, 66, 25);
		getContentPane().add(lblNewLabel_2_1_1);

		txtMaHP = new JTextField();
		txtMaHP.setColumns(10);
		txtMaHP.setBounds(151, 289, 166, 22);
		getContentPane().add(txtMaHP);

		btnThem = new JButton("THÊM");
		btnThem.setBounds(131, 330, 66, 32);
		getContentPane().add(btnThem);

		btnXong = new JButton("XONG");
		btnXong.setBounds(220, 330, 66, 32);
		getContentPane().add(btnXong);
	}

	public void TinhNang() {
		btnXong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				dispose();
			}
		});

		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String math = txtMaTH.getText();
				String lth = (String) BoxLTH.getSelectedItem();
				String gbd = (String) BoxGioBD.getSelectedItem();
				String ngay = (String) BoxThu.getSelectedItem();
				int st = Integer.parseInt((String) BoxST.getSelectedItem());
				String lop = txtMaLop.getText();
				String phong = txtMaPhong.getText();
				String mahp = txtMaHP.getText();

				TietHocBUS thb = new TietHocBUS();
				thb.them(new TietHoc(math, lth, gbd, ngay, st, lop, phong, mahp));
			}
		});
	}
}
