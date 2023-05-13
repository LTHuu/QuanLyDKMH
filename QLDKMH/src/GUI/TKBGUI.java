package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TKBGUI extends JPanel {
	private JTextField txtFind;

	/**
	 * Create the panel.
	 */
	public TKBGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỜI KHÓA BIỂU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(355, 39, 583, 54);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 180, 867, 282);
		add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(454, 149, 323, 21);
		add(comboBox);
		
		txtFind = new JTextField();
		txtFind.setBounds(431, 120, 346, 19);
		add(txtFind);
		txtFind.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.setBounds(787, 119, 85, 21);
		add(btnNewButton);
	}

}
