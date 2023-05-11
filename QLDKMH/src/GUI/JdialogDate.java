package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import java.util.Calendar;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.YearMonth;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JSeparator;

public class JdialogDate extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;

	private Calendar cal = Calendar.getInstance();
	private LocalDate today = LocalDate.now();
	private String date = null;
	private int D = -1;
	private int M = -1;
	private int Y = -1;
	private JSpinner jSpinD;
	private JSpinner jSpinM;
	private JSpinner jSpinY;
	private JLabel lblDate;	

	/**
	 * Create the dialog.
	 */
	public JdialogDate(JTextField txt) {
		setBounds(100, 100, 450, 276);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 204, 436, 35);
		contentPanel.add(panel);
		panel.setLayout(null);

		JButton btnPrev = new JButton("<<");
		btnPrev.setBounds(0, 0, 75, 35);
		panel.add(btnPrev);

		JButton btnNext = new JButton(">>");
		btnNext.setBounds(361, 0, 75, 35);
		panel.add(btnNext);

		JButton btnDone = new JButton("Xong");
		btnDone.setBounds(170, 0, 75, 35);
		panel.add(btnDone);

		jSpinD = new JSpinner();
		jSpinD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jSpinD.setBounds(180, 0, 50, 27);
		contentPanel.add(jSpinD);

		jSpinM = new JSpinner();
		jSpinM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jSpinM.setBounds(227, 0, 50, 27);
		contentPanel.add(jSpinM);

		jSpinY = new JSpinner(new SpinnerNumberModel(2000, 0, 10000, 1));
		jSpinY.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jSpinY.setBounds(324, 0, 18, 27);
		contentPanel.add(jSpinY);

		createTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 33, 436, 172);
		contentPanel.add(scrollPane);

		txtY = new JTextField();
		txtY.setBounds(277, 0, 50, 27);
		contentPanel.add(txtY);
		txtY.setColumns(10);

		lblDate = new JLabel("");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(0, 9, 164, 14);
		contentPanel.add(lblDate);
		D = today.getDayOfMonth();
		M = today.getMonthValue();
		Y = today.getYear();
		LoadTable(D, M, Y);

		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoadTable(D, ++M, Y);
			}
		});

		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoadTable(D, --M, Y);
			}
		});

		jSpinD.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				D = (int) jSpinD.getValue();
				if (D > YearMonth.of(Y, M).lengthOfMonth() || D <= 0)
					D = 1;
				LoadTable(D, M, Y);
			}
		});

		jSpinM.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				M = (int) jSpinM.getValue();
				if (M > 12) {
					M = 1;
					D = 1;
					Y++;
				}
				if (M < 0) {
					M = 12;
					D = 1;
					Y--;
				}
				LoadTable(D, M, Y);
			}
		});

		jSpinY.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				Y = (int) jSpinY.getValue();
				if (Y < 1000) {
					Y = today.getYear();
				}
				txtY.setText(String.valueOf(Y));
				LoadTable(D, M, Y);
			}
		});

		txtY.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					Y = Integer.parseInt(txtY.getText());
					jSpinY.setValue(Y);
					LoadTable(D, M, Y);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				try {
					Y = Integer.parseInt(txtY.getText());
					jSpinY.setValue(Y);
					LoadTable(D, M, Y);
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txt.setText(date);
				setVisible(false);
				dispose();
			}
		});
	}

	public class CenterTableCellRenderer extends DefaultTableCellRenderer {
		public CenterTableCellRenderer() {
			setHorizontalAlignment(JLabel.CENTER); // set căn giữa cho label
		}
	}

	DefaultTableCellRenderer center = new CenterTableCellRenderer();
	private JTextField txtY;

	public void createTable() {
		model = new DefaultTableModel(null, new String[] { "CN", "T2", "T3", "T4", "T5", "T6", "T7" });
		table = new JTable(model);
		table.setDefaultEditor(Object.class, null); // Không cho phép chỉnh sửa bằng cách khóa Editor
		table.setAlignmentX(CENTER_ALIGNMENT);
		table.setCellSelectionEnabled(true); // cho phép chọn một ô duy nhất
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();

				D = Integer.parseInt((String) model.getValueAt(row, col));
				if (row == 0 && D > 7) {
					if (M == 1) {
						M = 12;
						Y--;
					} else {
						M--;
					}
					LoadTable(D, M, Y);
				}
				if (row == table.getRowCount() - 1 && D < 7) {
					System.out.println("vào");
					if (M == 12) {
						M = 1;
						Y++;
					} else {
						M++;
					}
					LoadTable(D, M, Y);
				}
				LoadTable(D, M, Y);
			}
		});
	}

	public void LoadTable(int day, int month, int year) {
		clearTable();
		D = day;
		M = month;
		Y = year;

		cal.set(Calendar.YEAR, year);
		switch (month) {
		case 1: {
			cal.set(Calendar.MONTH, Calendar.JANUARY);
			break;
		}
		case 2: {
			cal.set(Calendar.MONTH, Calendar.FEBRUARY);
			break;
		}
		case 3: {
			cal.set(Calendar.MONTH, Calendar.MARCH);
			break;
		}
		case 4: {
			cal.set(Calendar.MONTH, Calendar.APRIL);
			break;
		}
		case 5: {
			cal.set(Calendar.MONTH, Calendar.MAY);
			break;
		}
		case 6: {
			cal.set(Calendar.MONTH, Calendar.JUNE);
			break;
		}
		case 7: {
			cal.set(Calendar.MONTH, Calendar.JULY);
			break;
		}
		case 8: {
			cal.set(Calendar.MONTH, Calendar.AUGUST);
			break;
		}
		case 9: {
			cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
			break;
		}
		case 10: {
			cal.set(Calendar.MONTH, Calendar.OCTOBER);
			break;
		}
		case 11: {
			cal.set(Calendar.MONTH, Calendar.NOVEMBER);
			break;
		}
		case 12: {
			cal.set(Calendar.MONTH, Calendar.DECEMBER);
			break;
		}
		}
		cal.set(Calendar.DAY_OF_MONTH, 1);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int dayInMonth = YearMonth.of(year, month).lengthOfMonth();
		int dayInLastMonth = -1;
		if (month == 1) {
			dayInLastMonth = YearMonth.of(year - 1, 12).lengthOfMonth();
		} else {
			dayInLastMonth = YearMonth.of(year, month - 1).lengthOfMonth();
		}
		int dayInNextMonth = -1;
		if (month == 12) {
			dayInNextMonth = YearMonth.of(year + 1, 1).lengthOfMonth();
		} else {
			dayInNextMonth = YearMonth.of(year, month + 1).lengthOfMonth();
		}

		String[] row = new String[7];

		Font f = new Font("", Font.BOLD, 10);

		// xử lý các ngày tháng trước
		for (int i = dayOfWeek - 1; 1 <= i; i--) {
			row[i - 1] = Integer.toString(dayInLastMonth--);
			// màu xanh
		}
		int r = -1;
		int c = -1;
		int t = dayOfWeek;
		;
		// xử lý các ngày trong tháng đó
		for (int i = 1; i <= dayInMonth; i++) {
			if (i == day) {
				c = dayOfWeek - 1;
				r = ((t + i - 2) / 7);
			}
			if (dayOfWeek != 7) {
				row[dayOfWeek++ - 1] = Integer.toString(i);
			} else {
				row[dayOfWeek++ - 1] = Integer.toString(i);
				dayOfWeek = 1;
				model.addRow(new Object[] { row[0], row[1], row[2], row[3], row[4], row[5], row[6] });
			}

		}
		// xử lý các ngày tháng sau đó
		day = 1;
		for (int i = dayOfWeek; i <= 7; i++) {
			row[i - 1] = Integer.toString(day++);
			// màu xanh
		}
		model.addRow(new Object[] { row[0], row[1], row[2], row[3], row[4], row[5], row[6] });

		TableColumnModel columnModel = table.getColumnModel();
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setCellRenderer(center);
		}

		final int rw = r;
		final int cl = c;

		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component cc = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				cc.setBackground(Color.yellow);
				int v = Integer.parseInt(((String) model.getValueAt(row, column)));
				if (row == 0 && v > 7) {
					cc.setBackground(Color.white);
				}
				if (row == table.getRowCount() - 1 && v < 7) {
					cc.setBackground(Color.white);
				}
				if (row == rw && column == cl) {
					cc.setBackground(Color.BLUE);
				}
				return cc;
			}
		};

		table.getColumnModel().getColumn(0).setCellRenderer(renderer);
		table.getColumnModel().getColumn(1).setCellRenderer(renderer);
		table.getColumnModel().getColumn(2).setCellRenderer(renderer);
		table.getColumnModel().getColumn(3).setCellRenderer(renderer);
		table.getColumnModel().getColumn(4).setCellRenderer(renderer);
		table.getColumnModel().getColumn(5).setCellRenderer(renderer);
		table.getColumnModel().getColumn(6).setCellRenderer(renderer);

		jSpinD.setValue(D);
		jSpinM.setValue(M);
		jSpinY.setValue(Y);
		txtY.setText(String.valueOf(Y));

		lblDate.setText(D + "/" + M + "/" + Y);
		date = lblDate.getText();
	}

	public void clearTable() {
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
	}

	public String getDate() {
		return date;
	}
}
