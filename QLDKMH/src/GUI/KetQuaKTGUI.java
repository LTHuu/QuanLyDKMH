package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import BUS.DangKiBUS;
import BUS.HocPhanBUS;
import BUS.KetQuaKTBUS;
import BUS.MonHocBUS;
import BUS.SinhVienBUS;
import DTO.DangKiDTO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class KetQuaKTGUI extends JPanel {
	private DefaultTableModel model2;
	private DefaultTableModel model1;
	private JTable table1;
	private JTable table2;
	private JTextField txtMaSV;
	private JButton btnTim;
	private JLabel lblTenSV;

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

		txtMaSV = new JTextField();
		txtMaSV.setHorizontalAlignment(SwingConstants.RIGHT);
		txtMaSV.setColumns(10);
		txtMaSV.setBounds(171, 17, 144, 27);
		add(txtMaSV);

		JComboBox cBoxHocKy = new JComboBox();
		cBoxHocKy.setBounds(325, 20, 349, 24);
		add(cBoxHocKy);

		lblTenSV = new JLabel("Tên SV:");
		lblTenSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTenSV.setBounds(779, 17, 296, 33);
		add(lblTenSV);
		
		btnTim = new JButton("TÌM");
		btnTim.setBounds(684, 23, 85, 21);
		add(btnTim);
		
		TinhNang();
	}
	
	public void TinhNang() {
		btnTim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadTableAll(txtMaSV.getText());
				loadTableTK(txtMaSV.getText());
				SinhVienBUS svb = new SinhVienBUS();
				try {
					lblTenSV.setText(svb.timMaSV(txtMaSV.getText()).getTenSV());
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
	}

	public void createTable() {
		model1 = new DefaultTableModel(null,
				new String[] { "Mã MH", "Tên MH", "STC", "Giữa kì(40%)", "Cuối kì(60%)", "Tổng Kết" });
		model2 = new DefaultTableModel(null,
				new String[] { "Mã MH", "Tên MH", "15p(10%)", "1 tiết(30%)", "cuối kì(60%)" });

		table1 = new JTable(model1);
		table2 = new JTable(model2);
	}

	public void clearTable(DefaultTableModel model) {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	public void loadTableTK(String masv) {
		clearTable(model1);
		Object[] obj = new Object[6];
		DangKiBUS dkb = new DangKiBUS();
		KetQuaKTBUS kqb = new KetQuaKTBUS();
		HocPhanBUS hpb = new HocPhanBUS();
		MonHocBUS mhb = new MonHocBUS();
		for (DangKiDTO temp : dkb.timMaSVDK(masv)) {
			String mamh = hpb.timMaHP(temp.getMaHP()).getMaMH();
			obj[0] = mamh;
			obj[1] = mhb.timMaMH(mamh).getTenMH();
			obj[2] = mhb.timMaMH(mamh).getSoTC();
			// Điểm hệ số 40%
			float[] diem = kqb.getDiemLoaiKT(temp.getMaHP(), masv, "15p"); // Hệ số 10%
			float Sum = 0;
			for (float i : diem) {
				Sum += i;
			}
			float heso10 = (float) ((Sum / diem.length) * 0.1);
			System.out.println(heso10);
			diem = kqb.getDiemLoaiKT(temp.getMaHP(), masv, "1 TIET"); // Hệ số 40%
			Sum = 0;
			for (float i : diem) {
				Sum += i;
			}
			float heso30 = (Sum / diem.length);
			float heso40 = (float) (heso10 + heso30);
			obj[3] = heso40;
			// Điểm hệ số 60%
			diem = kqb.getDiemLoaiKT(temp.getMaHP(), masv, "CUOIKI"); // Hệ số 40%
			Sum = 0;
			for (float i : diem) {
				Sum += i;
			}
			float heso60 = (Sum / diem.length);
			obj[4] = heso60;
			// Tổng kết
			float TK = (float) ((heso10 + heso30 * 3 + heso60 * 6) / 10);
			obj[5] = TK;
			model1.addRow(obj);
		}
	}

	public void loadTableAll(String masv) {
		clearTable(model2);
		Object[] obj = new Object[6];
		DangKiBUS dkb = new DangKiBUS();
		KetQuaKTBUS kqb = new KetQuaKTBUS();
		HocPhanBUS hpb = new HocPhanBUS();
		MonHocBUS mhb = new MonHocBUS();
		for (DangKiDTO temp : dkb.timMaSVDK(masv)) {
			String mamh = hpb.timMaHP(temp.getMaHP()).getMaMH();
			obj[0] = mamh;
			obj[1] = mhb.timMaMH(mamh).getTenMH();
			// Điểm hệ số 40%
			float[] diem = kqb.getDiemLoaiKT(temp.getMaHP(), masv, "15p"); // Hệ số 10%
			obj[2] = Arrays.toString(diem);
			diem = kqb.getDiemLoaiKT(temp.getMaHP(), masv, "1 TIET"); // Hệ số 30%
			obj[3] = Arrays.toString(diem);
			diem = kqb.getDiemLoaiKT(temp.getMaHP(), masv, "CUOIKI"); // Hệ số 60%
			obj[4] = Arrays.toString(diem);
			model2.addRow(obj);
		}
	}
}
