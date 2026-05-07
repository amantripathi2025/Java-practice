import javax.swing.*;
import java.awt.*;

public class TrafficLight extends JFrame {
    String[] colors = {"Red", "Yellow", "Green"};
    int current = 0;
    JLabel light = new JLabel("RED", SwingConstants.CENTER);

    TrafficLight() {
        setTitle("Traffic Light");
        setSize(200, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        light.setFont(new Font("Arial", Font.BOLD, 24));
        light.setOpaque(true);
        light.setBackground(Color.RED);
        light.setForeground(Color.WHITE);
        add(light, BorderLayout.CENTER);

        JButton next = new JButton("Next");
        next.addActionListener(e -> {
            current = (current + 1) % 3;
            light.setText(colors[current].toUpperCase());
            light.setBackground(
                    current == 0 ? Color.RED :
                            current == 1 ? Color.YELLOW : Color.GREEN);
            light.setForeground(current == 1 ? Color.BLACK : Color.WHITE);
        });
        add(next, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TrafficLight::new);
    }
}
