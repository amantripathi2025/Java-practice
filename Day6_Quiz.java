import javax.swing.*;
import java.awt.*;

public class Day6_Quiz extends JFrame {
    String[][] qa = {
            {"Capital of India?",         "Mumbai","Delhi","Chennai","Kolkata",  "2"},
            {"2 + 2 * 2 = ?",             "6","8","4","10",                      "1"},
            {"Java runs on?",             "Browser","JVM","OS","CPU",            "2"},
            {"Which is not OOP?",         "Java","C++","C","Python",             "3"},
            {"float size in bytes?",      "2","8","4","16",                      "3"},
    };
    int current = 0, score = 0;
    JLabel questionLabel = new JLabel("", SwingConstants.CENTER);
    JLabel scoreLabel    = new JLabel("Score: 0", SwingConstants.RIGHT);
    JRadioButton[] opts  = new JRadioButton[4];
    ButtonGroup bg       = new ButtonGroup();

    Day6_Quiz() {
        setTitle("Quiz App");
        setSize(450, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        questionLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel optPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        for (int i = 0; i < 4; i++) {
            opts[i] = new JRadioButton();
            bg.add(opts[i]);
            optPanel.add(opts[i]);
        }

        JButton next = new JButton("Next →");
        next.addActionListener(e -> {
            for (int i = 0; i < 4; i++) {
                if (opts[i].isSelected() &&
                        String.valueOf(i+1).equals(qa[current][5])) score++;
            }
            current++;
            if (current < qa.length) {
                loadQuestion();
                scoreLabel.setText("Score: " + score);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Quiz Over!\nScore: " + score + "/" + qa.length);
                System.exit(0);
            }
        });

        add(questionLabel,                     BorderLayout.NORTH);
        add(optPanel,                          BorderLayout.CENTER);
        add(next,                              BorderLayout.SOUTH);
        add(scoreLabel,                        BorderLayout.EAST);

        loadQuestion();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void loadQuestion() {
        bg.clearSelection();
        questionLabel.setText("Q" + (current+1) + ": " + qa[current][0]);
        for (int i = 0; i < 4; i++)
            opts[i].setText(qa[current][i+1]);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day6_Quiz::new);
    }
}