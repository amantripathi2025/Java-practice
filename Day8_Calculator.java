import javax.swing.*;
import java.awt.*;

public class Day8_Calculator extends JFrame {
    JTextField display = new JTextField("0");
    double memory = 0; String op = ""; boolean fresh = true;

    Day8_Calculator() {
        setTitle("Calculator");
        setSize(280, 380);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        display.setFont(new Font("Monospaced", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        add(display, BorderLayout.NORTH);

        String[] labels = {
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0",".","=","+"
        };

        JPanel grid = new JPanel(new GridLayout(4, 4, 4, 4));
        for (String lbl : labels) {
            JButton b = new JButton(lbl);
            b.setFont(new Font("Arial", Font.BOLD, 18));
            if ("+-*/".contains(lbl)) b.setBackground(new Color(0xE67E22));
            if ("=".equals(lbl))     b.setBackground(new Color(0x27AE60));
            b.setForeground(Color.WHITE);
            b.setOpaque(true);
            b.addActionListener(e -> handleButton(lbl));
            grid.add(b);
        }

        JButton clear = new JButton("C");
        clear.setBackground(new Color(0xE74C3C));
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Arial", Font.BOLD, 18));
        clear.addActionListener(e -> { display.setText("0"); memory=0; op=""; fresh=true; });

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(grid, BorderLayout.CENTER);
        bottom.add(clear, BorderLayout.SOUTH);
        add(bottom, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void handleButton(String lbl) {
        if ("0123456789.".contains(lbl)) {
            if (fresh) { display.setText(lbl); fresh = false; }
            else display.setText(display.getText() + lbl);
        } else if ("+-*/".contains(lbl)) {
            memory = Double.parseDouble(display.getText());
            op = lbl; fresh = true;
        } else if ("=".equals(lbl)) {
            double cur = Double.parseDouble(display.getText());
            double res = op.equals("+") ? memory+cur : op.equals("-") ? memory-cur :
                    op.equals("*") ? memory*cur : memory/cur;
            display.setText(String.valueOf(res));
            fresh = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day8_Calculator::new);
    }
}