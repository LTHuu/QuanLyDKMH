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

public class TietHocGUI extends JPanel {
	private JTextField txtFind;

	/**
	 * Create the panel.
	 */
	public TietHocGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH TIẾT HỌC");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(369, 41, 544, 61);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 177, 1017, 484);
		add(scrollPane);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(117, 132, 85, 35);
		add(btnXoa);
		
		txtFind = new JTextField();
		txtFind.setBounds(229, 140, 412, 26);
		add(txtFind);
		txtFind.setColumns(10);
	}

}
