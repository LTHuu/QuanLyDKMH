package main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class te {
    public static void main(String[] args) {
    	JFrame frame = new JFrame("My Frame");
    	frame.setSize(400, 300);

    	// Tạo một JButton để mở JDialog
    	JButton button = new JButton("Open Dialog");

    	button.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        // Vô hiệu hóa tất cả các thành phần trên JFrame
    	        Component[] components = frame.getContentPane().getComponents();
    	        for (Component component : components) {
    	            component.setEnabled(false);
    	        }
    	        

    	        // Tạo một đối tượng JDialog mới
    	        JDialog dialog = new JDialog(frame, "My Dialog", true);
    	        dialog.setSize(200, 100);
    	        dialog.setLocationRelativeTo(frame);
    	        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    	        // Hiển thị JDialog
    	        dialog.setVisible(true);

    	        // Khi JDialog được đóng, cho phép tương tác lại với các thành phần trên JFrame
    	        for (Component component : components) {
    	            component.setEnabled(true);
    	        }
    	    }
    	});

    	frame.add(button);
    	frame.setVisible(true);

    }
}

