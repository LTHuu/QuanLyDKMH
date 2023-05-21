package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import BUS.PhanCongBUS;
import DTO.PhanCongDTO;

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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class PhanCongGUI extends JPanel {
	private JTextField txtFind;
	private JTextField txtMaPC;
	private JTextField txtLPC;
	private JTextField txtMaGV;
	private DefaultTableModel dspc;
	private JTable tablepc;
	private JButton btnXoa;
	private JToggleButton btnSua;
	private JButton btnThem;

	private Object tempObj = null;

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

		createTable();
		JScrollPane scrollPane = new JScrollPane(tablepc);
		scrollPane.setBounds(10, 138, 710, 615);
		add(scrollPane);

		btnXoa = new JButton("XÓA");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXoa.setBounds(10, 107, 85, 21);
		add(btnXoa);

		txtFind = new JTextField();
		txtFind.setBounds(200, 109, 292, 19);
		add(txtFind);
		txtFind.setColumns(10);

		btnSua = new JToggleButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSua.setBounds(102, 108, 77, 21);
		add(btnSua);

		JPanel panel = new JPanel();
		panel.setBounds(730, 142, 509, 286);
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

		btnThem = new JButton("THÊM");
		btnThem.setBounds(350, 223, 85, 46);
		panel.add(btnThem);

		TinhNang();

		PhanCongBUS pcb = new PhanCongBUS();
		loadTable(PhanCongBUS.getDsPC());
	}

	public void TinhNang() {
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		btnXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (tempObj != null) {
					PhanCongBUS pcb = new PhanCongBUS();
					pcb.xoa((PhanCongDTO) tempObj);
					JOptionPane.showMessageDialog(null, "Xóa thành công!");
				}
			}
		});

		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String magv = txtMaGV.getText();
				String loaipc = txtMaPC.getText();
				String mapc = txtMaPC.getText();
				PhanCongBUS pcb = new PhanCongBUS();
				if (pcb.them(new PhanCongDTO(magv, loaipc, mapc))) {
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
					loadTable(PhanCongBUS.getDsPC());
				} else {
					JOptionPane.showMessageDialog(null, "Thêm không thành công!");
				}
			}
		});

		txtFind.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				PhanCongBUS pc = new PhanCongBUS();
				if (!txtFind.getText().isBlank()) {
					loadTable(pc.findPC(txtFind.getText()));
				} else {
					loadTable(PhanCongBUS.getDsPC());
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				PhanCongBUS pc = new PhanCongBUS();
				loadTable(pc.findPC(txtFind.getText()));
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void createTable() {
		dspc = new DefaultTableModel(null, new String[] { "MaGV", "TenGV", "LoaiPC", "MaPC" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return btnSua.isSelected() && column != 1;
			}
		};
		tablepc = new JTable(dspc);
		tablepc.addMouseListener(new MouseListener() {

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
				tempObj = null;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tablepc.getSelectedRow();
				String magv = (String) dspc.getValueAt(row, 0);
				String loaipc = (String) dspc.getValueAt(row, 2);
				String mapc = (String) dspc.getValueAt(row, 3);
				tempObj = new PhanCongDTO(magv, loaipc, mapc);
			}
		});
		dspc.addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				int row = tablepc.getSelectedRow();
				if (tempObj != null) {
					String magv = (String) dspc.getValueAt(row, 0);
					String loaipc = (String) dspc.getValueAt(row, 2);
					String mapc = (String) dspc.getValueAt(row, 3);
					PhanCongBUS pcb = new PhanCongBUS();
					pcb.sua((PhanCongDTO) tempObj, new PhanCongDTO(magv, loaipc, mapc));
				}

			}
		});
	}

	public void clearTable(DefaultTableModel model) {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	public void loadTable(ArrayList<PhanCongDTO> obj) {
		clearTable(dspc);
		for (PhanCongDTO temp : obj) {
			dspc.addRow(temp.toArray());
		}
	}
}
