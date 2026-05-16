import javax.swing.*;
import java.awt.*;

public class Day7_Stopwatch extends JFrame {
    int seconds = 0;
    boolean running = false;
    JLabel display = new JLabel("00:00:00", SwingConstants.CENTER);
    Timer timer;

    Day7_Stopwatch() {
        setTitle("Stopwatch");
        setSize(300, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display.setFont(new Font("Monospaced", Font.BOLD, 48));
        display.setOpaque(true);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.GREEN);

        JButton start = new JButton("Start");
        JButton stop  = new JButton("Stop");
        JButton reset = new JButton("Reset");

        timer = new Timer(1000, e -> {
            seconds++;
            int h = seconds/3600, m = (seconds%3600)/60, s = seconds%60;
            display.setText(String.format("%02d:%02d:%02d", h, m, s));
        });

        start.addActionListener(e -> { if (!running) { timer.start(); running = true; } });
        stop .addActionListener(e -> { timer.stop(); running = false; });
        reset.addActionListener(e -> {
            timer.stop(); running = false;
            seconds = 0; display.setText("00:00:00");
        });

        JPanel btns = new JPanel();
        btns.add(start); btns.add(stop); btns.add(reset);

        add(display, BorderLayout.CENTER);
        add(btns,    BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day7_Stopwatch::new);
    }
}