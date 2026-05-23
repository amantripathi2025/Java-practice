  import javax.swing.*;
        import java.awt.*;

public class Day14_UnitConverter extends JFrame {
    JTextField input  = new JTextField();
    JLabel result     = new JLabel("", SwingConstants.CENTER);
    JComboBox<String> type = new JComboBox<>(
            new String[]{"Length","Weight","Speed"});
    JComboBox<String> from = new JComboBox<>();
    JComboBox<String> to   = new JComboBox<>();

    String[][] units = {
            {"Meter","Kilometer","Mile","Foot","Inch"},
            {"Kilogram","Gram","Pound","Ounce"},
            {"m/s","km/h","mph","knot"}
    };

    double[][] toBase = {
            {1, 1000, 1609.34, 0.3048, 0.0254},
            {1, 0.001, 0.453592, 0.0283495},
            {1, 1.0/3.6, 0.44704, 0.514444}
    };

    Day14_UnitConverter() {
        setTitle("Unit Converter");
        setSize(420, 240);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        type.addActionListener(e -> loadUnits());
        loadUnits();

        JButton convert = new JButton("Convert");
        convert.addActionListener(e -> {
            int t  = type.getSelectedIndex();
            int fi = from.getSelectedIndex();
            int ti = to.getSelectedIndex();
            double val    = Double.parseDouble(input.getText());
            double inBase = val * toBase[t][fi];
            double out    = inBase / toBase[t][ti];
            result.setText(String.format("%.4f %s", out, to.getSelectedItem()));
        });

        add(new JLabel("Type:"));    add(type);
        add(new JLabel("Value:"));   add(input);
        add(new JLabel("From:"));    add(from);
        add(new JLabel("To:"));      add(to);
        add(convert);                add(result);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void loadUnits() {
        int t = type.getSelectedIndex();
        from.removeAllItems(); to.removeAllItems();
        for (String u : units[t]) { from.addItem(u); to.addItem(u); }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day14_UnitConverter::new);
    }
}
