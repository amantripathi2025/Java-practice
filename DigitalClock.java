 import javax.swing.*;
        import java.awt.*;
        import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalClock extends JFrame {

    DigitalClock() {
        setTitle("Digital Clock");
        setSize(320, 120);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel clock = new JLabel("", SwingConstants.CENTER);
        clock.setFont(new Font("Monospaced", Font.BOLD, 48));
        clock.setForeground(new Color(0x27AE60));
        clock.setOpaque(true);
        clock.setBackground(Color.BLACK);
        add(clock);

        // Timer updates every second
        new Timer(1000, e -> {
            clock.setText(LocalTime.now()
                    .format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }).start();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DigitalClock::new);
    }
}