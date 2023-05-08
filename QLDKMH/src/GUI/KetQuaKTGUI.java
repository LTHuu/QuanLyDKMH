package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class KetQuaKTGUI extends JPanel {
	private DefaultTableModel model2;
	private DefaultTableModel model1;
	private JTable table1;
	private JTable table2;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public KetQuaKTGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Điểm tổng kết");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(293, 54, 633, 27);
		add(lblNewLabel);
		
		createTable();
		JScrollPane scrollPane = new JScrollPane(table1);
		scrollPane.setBounds(125, 91, 1014, 318);
		add(scrollPane);
		
		JScrollPane scrollPane1 = new JScrollPane(table2);
		scrollPane1.setBounds(125, 419, 1014, 334);
		add(scrollPane1);
		
		JLabel lblNewLabel_1 = new JLabel("Mã SV:");
		lblNewLabel_1.setBounds(125, 17, 51, 27);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setColumns(10);
		textField.setBounds(171, 17, 144, 27);
		add(textField);
		
		JComboBox cBoxHocKy = new JComboBox();
		cBoxHocKy.setBounds(325, 20, 349, 24);
		add(cBoxHocKy);
		
		JLabel lblNewLabel_2 = new JLabel("Tên SV:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(689, 17, 296, 33);
		add(lblNewLabel_2);
	}
	
	public void createTable() {
		model1 = new DefaultTableModel(null,new String[] {"Mã HP","Tên HP","STC","Điểm(40%)","Điểm(60%)","Tổng Kết"});
		model2 = new DefaultTableModel(null,new String[] {"Mã HP","Tên HP","khác(10%)","giữa kì(30%)","cuối kì(60%)"});
		
		table1 = new JTable(model1);
		table2 = new JTable(model2);
	}
}
