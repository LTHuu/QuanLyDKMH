package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class PhanCongGUI extends JPanel {
	private JTextField txtFind;
	private JTextField txtMaPC;
	private JTextField txtLPC;
	private JTextField txtMaGV;

	/**
	 * Create the panel.
	 */
	public PhanCongGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH PHÂN CÔNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(165, 10, 346, 41);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 138, 710, 615);
		add(scrollPane);
		
		JButton btnNewButton = new JButton("XÓA");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 107, 85, 21);
		add(btnNewButton);
		
		txtFind = new JTextField();
		txtFind.setBounds(200, 109, 292, 19);
		add(txtFind);
		txtFind.setColumns(10);
		
		JToggleButton btnSua = new JToggleButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSua.setBounds(102, 108, 77, 21);
		add(btnSua);
		
		JPanel panel = new JPanel();
		panel.setBounds(730, 142, 509, 306);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("THÊM PHÂN CÔNG");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(107, 10, 300, 46);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã Phân Công:");
		lblNewLabel_2.setBounds(117, 64, 90, 28);
		panel.add(lblNewLabel_2);
		
		txtMaPC = new JTextField();
		txtMaPC.setBounds(242, 69, 193, 19);
		panel.add(txtMaPC);
		txtMaPC.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Loại Phân Công:");
		lblNewLabel_2_1.setBounds(117, 115, 90, 28);
		panel.add(lblNewLabel_2_1);
		
		txtLPC = new JTextField();
		txtLPC.setColumns(10);
		txtLPC.setBounds(242, 120, 193, 19);
		panel.add(txtLPC);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Mã GV:");
		lblNewLabel_2_1_1.setBounds(117, 174, 90, 28);
		panel.add(lblNewLabel_2_1_1);
		
		txtMaGV = new JTextField();
		txtMaGV.setColumns(10);
		txtMaGV.setBounds(242, 179, 193, 19);
		panel.add(txtMaGV);
		
		JButton btnThem = new JButton("THÊM");
		btnThem.setBounds(350, 234, 85, 46);
		panel.add(btnThem);
		
		
	}
}
