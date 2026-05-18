import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Day9_ContactBook extends JFrame {
    Map<String, String> contacts = new LinkedHashMap<>();
    DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> list = new JList<>(model);
    JTextField nameField  = new JTextField();
    JTextField phoneField = new JTextField();

    Day9_ContactBook() {
        setTitle("Contact Book");
        setSize(420, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel form = new JPanel(new GridLayout(3, 2, 5, 5));
        JButton add = new JButton("Add");
        JButton del = new JButton("Delete");

        form.add(new JLabel("Name:"));  form.add(nameField);
        form.add(new JLabel("Phone:")); form.add(phoneField);
        form.add(add); form.add(del);

        add.addActionListener(e -> {
            String n = nameField.getText().trim();
            String p = phoneField.getText().trim();
            if (!n.isEmpty() && !p.isEmpty()) {
                contacts.put(n, p);
                refreshList();
                nameField.setText(""); phoneField.setText("");
            }
        });

        del.addActionListener(e -> {
            String sel = list.getSelectedValue();
            if (sel != null) {
                contacts.remove(sel.split(" — ")[0]);
                refreshList();
            }
        });

        list.addListSelectionListener(e -> {
            String sel = list.getSelectedValue();
            if (sel != null) {
                String[] parts = sel.split(" — ");
                nameField .setText(parts[0]);
                phoneField.setText(parts[1]);
            }
        });

        add(form,                   BorderLayout.NORTH);
        add(new JScrollPane(list),  BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void refreshList() {
        model.clear();
        contacts.forEach((n, p) -> model.addElement(n + " — " + p));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day9_ContactBook::new);
    }
}