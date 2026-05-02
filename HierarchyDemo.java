// Demonstrating Swing Hierarchy programmatically
import javax.swing.*;
import java.awt.*;

public class HierarchyDemo extends JFrame {

    public HierarchyDemo() {
        setTitle("Swing Hierarchy Demo");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // JFrame → ContentPane (JPanel by default)
        // We replace it with our own
        JPanel contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // JMenuBar → JMenu → JMenuItem (top-level)
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // NORTH: Toolbar (JPanel → JButtons)
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toolbar.setBorder(BorderFactory.createEtchedBorder());
        toolbar.add(new JButton("New"));
        toolbar.add(new JButton("Save"));
        toolbar.add(new JButton("Print"));
        contentPane.add(toolbar, BorderLayout.NORTH);

        // CENTER: Main content (JPanel → JScrollPane → JTable)
        String[] cols = {"ID", "Name", "Marks"};
        Object[][] data = {
                {1, "Alice", 95},
                {2, "Bob",   82},
                {3, "Carol", 91}
        };
        JTable table = new JTable(data, cols);
        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // SOUTH: Status bar
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBorder(BorderFactory.createLoweredBevelBorder());
        statusBar.add(new JLabel("Ready | Total students: 3"));
        contentPane.add(statusBar, BorderLayout.SOUTH);

        // EAST: Side panel (nested JPanel with GridLayout)
        JPanel sidePanel = new JPanel(new GridLayout(4, 1, 5, 5));
        sidePanel.setBorder(BorderFactory.createTitledBorder("Actions"));
        sidePanel.add(new JButton("Add"));
        sidePanel.add(new JButton("Edit"));
        sidePanel.add(new JButton("Delete"));
        sidePanel.add(new JButton("Export"));
        contentPane.add(sidePanel, BorderLayout.EAST);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HierarchyDemo::new);
    }
}