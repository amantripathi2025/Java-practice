import javax.swing.*;
import java.awt.*;

public class Day3_TodoList extends JFrame {
    DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> list = new JList<>(model);
    JTextField taskField = new JTextField();

    Day3_TodoList() {
        setTitle("To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        list.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton add    = new JButton("Add");
        JButton done   = new JButton("Mark Done");
        JButton delete = new JButton("Delete");

        add.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                model.addElement("[ ] " + task);
                taskField.setText("");
            }
        });

        done.addActionListener(e -> {
            int i = list.getSelectedIndex();
            if (i != -1) {
                String t = model.get(i).replace("[ ]","[✓]");
                model.set(i, t);
            }
        });

        delete.addActionListener(e -> {
            int i = list.getSelectedIndex();
            if (i != -1) model.remove(i);
        });

        JPanel top = new JPanel(new BorderLayout(5, 0));
        top.add(new JLabel("Task:"), BorderLayout.WEST);
        top.add(taskField,           BorderLayout.CENTER);
        top.add(add,                 BorderLayout.EAST);

        JPanel btnPanel = new JPanel(new GridLayout(1, 2, 5, 0));
        btnPanel.add(done); btnPanel.add(delete);

        add(top,                  BorderLayout.NORTH);
        add(new JScrollPane(list),BorderLayout.CENTER);
        add(btnPanel,             BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day3_TodoList::new);
    }
}
