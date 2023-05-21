package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import BUS.MonHocBUS;
import BUS.PhanCongBUS;
import DTO.MonHoc;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class MonHocGUI extends JPanel {
	private JTextField txtFind;
	private JTextField txtMaMH;
	private JTextField txtTenMH;
	private JTextField txtSTC;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnThem;
	private JToggleButton btnSua;
	private JButton btnXoa;
	
	private int choiceObj = -1;
	private JTextField txtMHtrc;

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

		createTable();
		JScrollPane scrollPane = new JScrollPane(table);
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

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(698, 129, 85, 21);
		add(btnXoa);

		btnSua = new JToggleButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(796, 131, 115, 21);
		add(btnSua);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(938, 160, 301, 282);
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

		btnThem = new JButton("THÊM");
		btnThem.setBounds(169, 222, 85, 50);
		panel.add(btnThem);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("MH trước:");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_1_1.setBounds(66, 163, 61, 13);
		panel.add(lblNewLabel_3_1_1_1);
		
		txtMHtrc = new JTextField();
		txtMHtrc.setColumns(10);
		txtMHtrc.setBounds(137, 161, 118, 19);
		panel.add(txtMHtrc);
		
		MonHocBUS mhb = new MonHocBUS();
		loadTable(MonHocBUS.getDsmh());
		
		TinhNang();
	}

	public void createTable() {
		model = new DefaultTableModel(null, new String[] { "Mã MH", "Tên MH", "Số TC", "Môn học trước" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return column != 0 && btnSua.isSelected();
			}
		};
		table = new JTable(model);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				choiceObj = table.getSelectedRow();
			}
		});
		
		model.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				String mamh = (String) model.getValueAt(choiceObj, 0);
				String tenmh = (String) model.getValueAt(choiceObj, 1);
				int stc = Integer.parseInt(model.getValueAt(choiceObj, 2).toString());
				String mhtrc = (String) model.getValueAt(choiceObj, 3);
				MonHocBUS mhb = new MonHocBUS();
				if(mhb.sua(new MonHoc(mamh, tenmh, stc, mhtrc))) {
					JOptionPane.showMessageDialog(null, "Sửa không thành công!");
					loadTable(MonHocBUS.getDsmh());
				}
			}
		});
	}
	
	public void TinhNang() {
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MonHocBUS pcb = new MonHocBUS();
				String mamh = (String) model.getValueAt(choiceObj, 0);
				pcb.xoa(mamh);
				choiceObj = -1;
			}
		});
		txtFind.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				MonHocBUS pc = new MonHocBUS();
				if (!txtFind.getText().isBlank()) {
					loadTable(pc.tim(txtFind.getText()));
				} else {
					loadTable(MonHocBUS.getDsmh());
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				MonHocBUS pc = new MonHocBUS();
				loadTable(pc.tim(txtFind.getText()));
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String mamh = txtMaMH.getText();
				String tenmh = txtTenMH.getText();
				int stc = Integer.parseInt(txtSTC.getText());
				String mhtrc = txtMHtrc.getText();
				MonHocBUS mhb = new MonHocBUS();
				if(mhb.them(new MonHoc(mamh, tenmh, stc, mhtrc))){
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
					loadTable(MonHocBUS.getDsmh());
					choiceObj=-1;
				} else {
					JOptionPane.showMessageDialog(null, "Thêm không thành công!");
				}
			}
		});
	}
	
	public void loadTable(ArrayList<MonHoc> obj) {
		while(model.getColumnCount()>0) {
			model.removeRow(0);
		}
		for(MonHoc temp : obj) {
			model.addRow(temp.toArray());
		}
	}
}
