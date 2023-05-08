package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import GUI.HocPhiGUI;
import GUI.KetQuaKTGUI;

public class jpSlideBar extends JPanel implements Runnable {

	private String Role = "SV";

	private int MouseX = 0;
	private int MouseY = 0;
	private boolean click = false;
	private int choice = 0;
	private String ChoiceObj[];
	private String ImgObj[];

	mainGUI mGUI;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (Role.equals("SV")) {
				Role = "GV";
			} else {
				if (Role.equals("GV")) {
					Role = "AD";
				} else {
					if (Role.equals("AD")) {
						Role = "";
					} else {
						if (Role.equals("")) {
							Role = "SV";
						}
					}
				}

			}
			System.out.println(Role);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}

	/**
	 * Create the panel.
	 */
	public jpSlideBar(mainGUI obj) {
		setLayout(null);
//		Thread thread = new Thread(this);
//		thread.start();
		init();
		mGUI = obj;
	}

	public void init() {
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				MouseX = e.getX();
				MouseY = e.getY();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		this.addMouseListener(new MouseListener() {

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
				click = e.getButton() == 1;
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.gray);
		g.fillRect(0, 0, 250, 763);

		switch (Role) {
		case "SV": {
			g.setFont(new Font("", Font.BOLD, 20));
			g.setColor(Color.red);
			g.drawString("Sinh viên", 10, 50);
			g.setColor(Color.black);
			g.drawString("Lê Tiến Hữu", 10, 100);
			g.drawString("3121560041", 10, 150);
			SlideBarSV(g);
			break;
		}
		case "GV": {
			g.setFont(new Font("", Font.BOLD, 20));
			g.setColor(Color.red);
			g.drawString("giảng viên", 10, 50);
			g.setColor(Color.black);
			g.drawString("Lê Tiến Hữu", 10, 100);
			g.drawString("3121560041", 10, 150);
			SlideBarGV(g);
			break;
		}
		case "AD": {
			g.setFont(new Font("", Font.BOLD, 20));
			g.setColor(Color.red);
			g.drawString("admin", 10, 50);
			g.setColor(Color.black);
			g.drawString("Lê Tiến Hữu", 10, 100);
			g.drawString("3121560041", 10, 150);
			SlideBarAD(g);
			break;
		}
		default:
			SlideBarBegin(g);
			break;
		}

	}

	public void SlideBarBegin(Graphics g) {
		ChoiceObj = new String[] { "Thời khóa biểu", "Học phí" };
		ImgObj = new String[] { "D:/javaAPP/QLDKMH/src/img/calendar.png", "D:/javaAPP/QLDKMH/src/img/bill.png" };
		DrawSlideBar(g);
	}

	public void SlideBarSV(Graphics g) {
		ChoiceObj = new String[] { "Thời khóa biểu", "Học phí", "Đăng ký môn học", "Điểm" };
		ImgObj = new String[] { "D:/javaAPP/QLDKMH/src/img/calendar.png", "D:/javaAPP/QLDKMH/src/img/bill.png","D:/javaAPP/QLDKMH/src/img/approval.png","D:/javaAPP/QLDKMH/src/img/grade.png" };
		DrawSlideBar(g);
	}

	public void SlideBarGV(Graphics g) {
		ChoiceObj = new String[] { "Lịch dạy", "Xem phân công" };
		ImgObj = new String[] { "D:/javaAPP/QLDKMH/src/img/calendar.png", "D:/javaAPP/QLDKMH/src/img/approval.png" };
		DrawSlideBar(g);
	}

	public void SlideBarAD(Graphics g) {
		ChoiceObj = new String[] { "QL SV/GV", "QL môn học", "QL học phần", "QL phòng học", "QL phân công",
				"QL tài khoản", };
		ImgObj = new String[] { "", "","","","","" };
		DrawSlideBar(g);
	}

	public void DrawSlideBar(Graphics g) {
		// vẽ viền
		g.setColor(Color.pink);
		g.fillRect(5, 300 + 50 * choice - 30, 230, 50);
		g.setColor(Color.red);
		g.drawRect(5, 300 + 50 * choice - 30, 230, 50);

		int y = 300;

		for (int i = 0; i < ChoiceObj.length; i++) {
			g.setColor(Color.orange);
			g.setFont(new Font("", Font.BOLD, 20));
			g.drawString(ChoiceObj[i], 50, y);
			Image img = new ImageIcon(ImgObj[i]).getImage();
			g.drawImage(img, 10, y - 25, null);
			y += 50;
		}
		// đăng nhập
		y = 763 - 10;
		g.setColor(Color.blue);
		g.drawString("Đăng Nhập", 50, y);
		Image dangNhap = new ImageIcon("D:/javaAPP/QL_TraSua/src/img/dangnhap_icon.png").getImage();
		g.drawImage(dangNhap, 10, y - 25, null);
		drawChoice(g);
	}

	public void drawChoice(Graphics g) {
		int i = 0;
		if (MouseY >= 300) {
			i = (MouseY - 300 + 30) / 50;
			if (click && (i >= 0 && i <= ChoiceObj.length - 1 || i == 9)) {
				choice = i;
				click = false;
				changeJpWork();
			}
		}
		if (i >= 0 && i <= ChoiceObj.length - 1 || i == 9) {
			g.setColor(Color.red);
			g.drawRect(5, 300 + 50 * i - 30, 230, 50);
		}

		repaint();
	}

	public void changeJpWork() {
		if (choice == 9) {

		} else {
			switch (Role) {
			case "SV": {
				switch (choice) {
				case 0: {

					break;
				}
				case 1: {
					mGUI.setJpWork(new HocPhiGUI());
					break;

				}
				case 2: {
					break;

				}
				case 3: {
					mGUI.setJpWork(new KetQuaKTGUI());
					break;

				}
				}
				break;
			}
			case "GV": {
				switch (choice) {
				case 0: {

					break;
				}
				case 1: {

					break;

				}
				}
				break;
			}
			case "AD": {
				switch (choice) {
				case 0: {

					break;
				}
				case 1: {

					break;

				}
				}
				break;
			}
			default:
				switch (choice) {
				case 0: {
					// chạy giao diện thời khóa biểu
					break;
				}
				case 1: {
					// chạy giao diện thời khóa biểu
					mGUI.setJpWork(new HocPhiGUI());
					break;

				}
				}
				break;
			}

		}
	}

}
