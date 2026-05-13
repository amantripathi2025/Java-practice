import javax.swing.*;
import java.awt.*;

public class Day4_GuessGame extends JFrame {
    int secret = (int)(Math.random() * 100) + 1;
    int attempts = 0;
    JTextField guessField = new JTextField();
    JLabel hint   = new JLabel("Guess a number between 1-100", SwingConstants.CENTER);
    JLabel attLbl = new JLabel("Attempts: 0", SwingConstants.CENTER);

    Day4_GuessGame() {
        setTitle("Number Guessing Game");
        setSize(350, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1, 10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        JButton guess = new JButton("Guess!");
        guess.addActionListener(e -> {
            try {
                int num = Integer.parseInt(guessField.getText());
                attempts++;
                attLbl.setText("Attempts: " + attempts);
                if (num == secret) {
                    hint.setText("Correct! You got it in " + attempts + " tries!");
                    hint.setForeground(Color.GREEN);
                    guess.setEnabled(false);
                } else if (num < secret) {
                    hint.setText("Too LOW! Try higher.");
                    hint.setForeground(Color.BLUE);
                } else {
                    hint.setText("Too HIGH! Try lower.");
                    hint.setForeground(Color.RED);
                }
                guessField.setText("");
            } catch (NumberFormatException ex) {
                hint.setText("Enter a valid number!");
            }
        });

        add(hint);
        add(guessField);
        add(guess);
        add(attLbl);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day4_GuessGame::new);
    }
}