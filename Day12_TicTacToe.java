import javax.swing.*;
import java.awt.*;

public class Day12_TicTacToe extends JFrame {
    JButton[] cells = new JButton[9];
    String turn = "X";
    JLabel status = new JLabel("Player X's turn", SwingConstants.CENTER);

    Day12_TicTacToe() {
        setTitle("Tic Tac Toe");
        setSize(360, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        JPanel grid = new JPanel(new GridLayout(3, 3, 4, 4));
        grid.setBackground(Color.DARK_GRAY);
        for (int i = 0; i < 9; i++) {
            int idx = i;
            cells[i] = new JButton("");
            cells[i].setFont(new Font("Arial", Font.BOLD, 48));
            cells[i].setBackground(Color.WHITE);
            cells[i].addActionListener(e -> {
                if (!cells[idx].getText().isEmpty()) return;
                cells[idx].setText(turn);
                cells[idx].setForeground(turn.equals("X") ? Color.BLUE : Color.RED);
                if (checkWin()) {
                    status.setText("Player " + turn + " wins!");
                    disableAll();
                } else if (isFull()) {
                    status.setText("It's a Draw!");
                } else {
                    turn = turn.equals("X") ? "O" : "X";
                    status.setText("Player " + turn + "'s turn");
                }
            });
            grid.add(cells[i]);
        }

        JButton reset = new JButton("New Game");
        reset.addActionListener(e -> resetGame());

        status.setFont(new Font("Arial", Font.BOLD, 16));
        add(status, BorderLayout.NORTH);
        add(grid,   BorderLayout.CENTER);
        add(reset,  BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    boolean checkWin() {
        int[][] wins = {{0,1,2},{3,4,5},{6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}};
        for (int[] w : wins) {
            if (!cells[w[0]].getText().isEmpty() &&
                    cells[w[0]].getText().equals(cells[w[1]].getText()) &&
                    cells[w[1]].getText().equals(cells[w[2]].getText())) return true;
        }
        return false;
    }

    boolean isFull() {
        for (JButton c : cells) if (c.getText().isEmpty()) return false;
        return true;
    }

    void disableAll() { for (JButton c : cells) c.setEnabled(false); }

    void resetGame() {
        turn = "X";
        status.setText("Player X's turn");
        for (JButton c : cells) { c.setText(""); c.setEnabled(true); }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day12_TicTacToe::new);
    }
}
