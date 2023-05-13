package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class KhoaGUI extends JPanel {

	private JTextField txtFind;
	private JTextField txtInfo1;
	private JTextField txtInfo2;
	private JTextField txInfo3;

	/**
	 * Create the panel.
	 */
	public KhoaGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("DANH SÁCH KHOA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(165, 10, 346, 30);
		add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 86, 710, 264);
		add(scrollPane);

		JButton btnXoaK = new JButton("XÓA");
		btnXoaK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoaK.setBounds(10, 45, 85, 21);
		add(btnXoaK);

		txtFind = new JTextField();
		txtFind.setBounds(192, 47, 292, 19);
		add(txtFind);
		txtFind.setColumns(10);

		JToggleButton btnSuaK = new JToggleButton("Sửa");
		btnSuaK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSuaK.setBounds(105, 45, 77, 21);
		add(btnSuaK);

		JPanel panel = new JPanel();
		panel.setBounds(730, 44, 509, 306);
		add(panel);
		panel.setLayout(null);

		JLabel lblTieuDe = new JLabel("THÊM KHOA:");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setBounds(107, 10, 300, 46);
		panel.add(lblTieuDe);

		JLabel lblInfo1 = new JLabel("Mã Khoa:");
		lblInfo1.setBounds(117, 64, 90, 28);
		panel.add(lblInfo1);

		txtInfo1 = new JTextField();
		txtInfo1.setBounds(242, 69, 193, 19);
		panel.add(txtInfo1);
		txtInfo1.setColumns(10);

		JLabel lblInfo2 = new JLabel("Tên Khoa:");
		lblInfo2.setBounds(117, 115, 90, 28);
		panel.add(lblInfo2);

		txtInfo2 = new JTextField();
		txtInfo2.setColumns(10);
		txtInfo2.setBounds(242, 120, 193, 19);
		panel.add(txtInfo2);

		JLabel lblInfo3 = new JLabel("Năm TL:");
		lblInfo3.setBounds(117, 174, 90, 28);
		panel.add(lblInfo3);

		txInfo3 = new JTextField();
		txInfo3.setColumns(10);
		txInfo3.setBounds(242, 179, 193, 19);
		panel.add(txInfo3);

		JButton btnThem = new JButton("THÊM");
		btnThem.setBounds(350, 234, 85, 46);
		panel.add(btnThem);
		
		JLabel lblDanhSchChuyn = new JLabel("DANH SÁCH CHUYÊN NGÀNH");
		lblDanhSchChuyn.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchChuyn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDanhSchChuyn.setBounds(418, 360, 346, 30);
		add(lblDanhSchChuyn);
		
		JButton btnXoaCN = new JButton("XÓA");
		btnXoaCN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoaCN.setBounds(203, 366, 85, 21);
		add(btnXoaCN);
		
		JToggleButton btnSuaCN = new JToggleButton("Sửa");
		btnSuaCN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSuaCN.setBounds(301, 366, 77, 21);
		add(btnSuaCN);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(203, 400, 710, 342);
		add(scrollPane_1);

	}
}
