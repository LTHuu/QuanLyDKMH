package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import BUS.TaiKhoanBUS;
import main.jpSlideBar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class DangNhapGUI extends JPanel {
	private JTextField txtTenDN;
	private JPasswordField txtPass;

	JPanel temp = this;
	/**
	 * Create the panel.
	 */
	public DangNhapGUI() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(291, 0, 1249, 763);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(159, 105, 939, 481);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(199, 20, 538, 36);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên Đăng Nhập:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(199, 82, 143, 36);
		panel.add(lblNewLabel_1);

		txtTenDN = new JTextField();
		txtTenDN.setBounds(353, 92, 242, 26);
		panel.add(txtTenDN);
		txtTenDN.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(199, 139, 143, 36);
		panel.add(lblNewLabel_1_1);

		txtPass = new JPasswordField();
		txtPass.setBounds(353, 149, 242, 26);
		panel.add(txtPass);

		JButton btnDN = new JButton("Đăng Nhập");
		btnDN.setBounds(353, 260, 125, 36);
		panel.add(btnDN);

		btnDN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TaiKhoanBUS tk = new TaiKhoanBUS();
				String pass = (Arrays.toString(txtPass.getPassword())).replaceAll(",", "");
				pass = pass.replaceAll(" ", "");
				pass = pass.substring(1, pass.length() - 1);
				if (tk.DangNhap(txtTenDN.getText(), pass)) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
					jpSlideBar.setChoice(0);
					System.out.println("hoàn thành");
					temp.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu!");
				}
			}
		});
	}
}
