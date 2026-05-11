import javax.swing.*;
import java.awt.*;

public class Day2_BMI extends JFrame {
    JTextField weightField = new JTextField();
    JTextField heightField = new JTextField();
    JLabel result = new JLabel("", SwingConstants.CENTER);

    Day2_BMI() {
        setTitle("BMI Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JButton calc = new JButton("Calculate BMI");
        calc.addActionListener(e -> {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText()) / 100;
            double bmi    = weight / (height * height);
            String cat    = bmi < 18.5 ? "Underweight" :
                    bmi < 25   ? "Normal"      :
                            bmi < 30   ? "Overweight"  : "Obese";
            result.setText(String.format("BMI: %.1f — %s", bmi, cat));
            result.setForeground(bmi < 18.5 ? Color.BLUE  :
                    bmi < 25   ? Color.GREEN :
                            bmi < 30   ? Color.ORANGE : Color.RED);
        });

        add(new JLabel("Weight (kg):")); add(weightField);
        add(new JLabel("Height (cm):")); add(heightField);
        add(calc); add(result);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day2_BMI::new);
    }
}