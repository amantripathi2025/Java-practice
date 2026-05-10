import javax.swing.*;
import java.awt.*;

public class Day1_TempConverter extends JFrame {
    JTextField input = new JTextField();
    JLabel result = new JLabel("Result will appear here", SwingConstants.CENTER);
    JComboBox<String> from = new JComboBox<>(new String[]{"Celsius","Fahrenheit","Kelvin"});
    JComboBox<String> to   = new JComboBox<>(new String[]{"Celsius","Fahrenheit","Kelvin"});

    Day1_TempConverter() {
        setTitle("Temperature Converter");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JButton convert = new JButton("Convert");
        convert.addActionListener(e -> {
            double val = Double.parseDouble(input.getText());
            String f = (String) from.getSelectedItem();
            String t = (String) to.getSelectedItem();
            double celsius = f.equals("Fahrenheit") ? (val-32)*5/9 :
                    f.equals("Kelvin")      ? val - 273.15 : val;
            double out = t.equals("Fahrenheit") ? celsius*9/5+32 :
                    t.equals("Kelvin")      ? celsius + 273.15 : celsius;
            result.setText(String.format("%.2f %s = %.2f %s", val, f, out, t));
        });

        add(new JLabel("Enter Value:")); add(input);
        add(new JLabel("From:"));        add(from);
        add(new JLabel("To:"));          add(to);
        add(convert);
        add(result);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day1_TempConverter::new);
    }
}