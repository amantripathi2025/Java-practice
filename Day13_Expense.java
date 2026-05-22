import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Day13_Expense extends JFrame {
    DefaultTableModel model = new DefaultTableModel(
            new String[]{"Description","Category","Amount"}, 0);
    JTable table = new JTable(model);
    JTextField descField   = new JTextField(10);
    JTextField amountField = new JTextField(8);
    JComboBox<String> catBox = new JComboBox<>(
            new String[]{"Food","Travel","Shopping","Bills","Other"});
    JLabel totalLabel = new JLabel("Total: ₹0.00");

    Day13_Expense() {
        setTitle("Expense Tracker");
        setSize(520, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 6));
        JButton add = new JButton("Add");
        JButton del = new JButton("Delete");

        form.add(new JLabel("Desc:"));    form.add(descField);
        form.add(new JLabel("Category:")); form.add(catBox);
        form.add(new JLabel("Amount:₹")); form.add(amountField);
        form.add(add); form.add(del);

        add.addActionListener(e -> {
            String desc = descField.getText().trim();
            String cat  = (String) catBox.getSelectedItem();
            String amt  = amountField.getText().trim();
            if (!desc.isEmpty() && !amt.isEmpty()) {
                model.addRow(new Object[]{desc, cat, Double.parseDouble(amt)});
                descField.setText(""); amountField.setText("");
                updateTotal();
            }
        });

        del.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) { model.removeRow(row); updateTotal(); }
        });

        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setForeground(new Color(0xC0392B));

        add(form,                    BorderLayout.NORTH);
        add(new JScrollPane(table),  BorderLayout.CENTER);
        add(totalLabel,              BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void updateTotal() {
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++)
            total += (double) model.getValueAt(i, 2);
        totalLabel.setText(String.format("Total: ₹%.2f", total));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day13_Expense::new);
    }
}