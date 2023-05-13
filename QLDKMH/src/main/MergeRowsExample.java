package main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MergeRowsExample extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public MergeRowsExample() {
        setTitle("Merge Rows Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo đối tượng DefaultTableModel
        tableModel = new DefaultTableModel(0, 3);
        tableModel.addRow(new Object[] { "Data 1", "Data 2", "Data 3" });
        tableModel.addRow(new Object[] { "Data 4", "Data 5", "Data 6" });
        tableModel.addRow(new Object[] { "Data 7", "Data 8", "Data 9" });

        // Tạo JTable với DefaultTableModel
        table = new JTable(tableModel);

        // Gộp dòng 1 và dòng 2 thành một dòng
        Object[] mergedRow = new Object[table.getColumnCount()];
        for (int column = 0; column < table.getColumnCount(); column++) {
            mergedRow[column] = tableModel.getValueAt(1, column);
        }
        tableModel.setValueAt(mergedRow, 1, 0);
        tableModel.removeRow(2);

        add(new JScrollPane(table));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MergeRowsExample();
            }
        });
    }
}
