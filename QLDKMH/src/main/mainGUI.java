package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainGUI {

	private JFrame frame;
	private JPanel jpWork;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainGUI window = new mainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("vào");
		frame = new JFrame();
		frame.setBounds(0, 0, 1800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Quản lý đăng ký môn học");

		JPanel jpSlideBar = new jpSlideBar(this);
		jpSlideBar.setBounds(0, 0, 250, 763);
		frame.getContentPane().add(jpSlideBar);

		jpWork = new JPanel();
		jpWork.setBounds(291, 0, 1249, 763);
		frame.getContentPane().add(jpWork);
	}
	
	public void setJpWork(JPanel obj) {
		jpWork.removeAll();

		// Đặt kích thước ưu tiên cho newPanel
		obj.setPreferredSize(jpWork.getSize());

		// Thêm newPanel vào panelB
		jpWork.add(obj);

		// Cập nhật giao diện
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
	}
	
}
