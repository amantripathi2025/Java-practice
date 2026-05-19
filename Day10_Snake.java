
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;          // ← explicit Swing Timer
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Random;

public class Day10_Snake extends JPanel implements ActionListener, KeyListener {

    static final int SIZE = 400, UNIT = 20, DELAY = 150;

    LinkedList<Point> snake = new LinkedList<>();
    Point food;
    int dx = UNIT, dy = 0;
    boolean running = true;
    Timer timer;

    Day10_Snake() {
        setPreferredSize(new Dimension(SIZE, SIZE));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        snake.add(new Point(SIZE / 2, SIZE / 2));
        spawnFood();

        timer = new Timer(DELAY, this);
        timer.start();

        JFrame f = new JFrame("Snake Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    void spawnFood() {
        Random r = new Random();
        // Make sure food doesn't spawn on snake
        do {
            food = new Point(
                    r.nextInt(SIZE / UNIT) * UNIT,
                    r.nextInt(SIZE / UNIT) * UNIT
            );
        } while (snake.contains(food));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!running) return;

        Point head = snake.getFirst();
        Point next = new Point(head.x + dx, head.y + dy);

        // Check wall collision
        if (next.x < 0 || next.x >= SIZE || next.y < 0 || next.y >= SIZE) {
            running = false;
            timer.stop();
            repaint();
            return;
        }

        // Check self collision
        if (snake.contains(next)) {
            running = false;
            timer.stop();
            repaint();
            return;
        }

        snake.addFirst(next);

        if (next.equals(food)) {
            spawnFood(); // eat food → grow (don't remove tail)
        } else {
            snake.removeLast();
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!running) {
            // Game Over screen
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            FontMetrics fm = g.getFontMetrics();
            String msg = "GAME OVER";
            g.drawString(msg,
                    (SIZE - fm.stringWidth(msg)) / 2,
                    SIZE / 2 - 20);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.PLAIN, 18));
            fm = g.getFontMetrics();
            String score = "Score: " + (snake.size() - 1);
            g.drawString(score,
                    (SIZE - fm.stringWidth(score)) / 2,
                    SIZE / 2 + 20);

            g.setFont(new Font("Arial", Font.PLAIN, 14));
            String restart = "Close and run again to restart";
            fm = g.getFontMetrics();
            g.setColor(Color.GRAY);
            g.drawString(restart,
                    (SIZE - fm.stringWidth(restart)) / 2,
                    SIZE / 2 + 50);
            return;
        }

        // Draw grid (optional, looks nice)
        g.setColor(new Color(30, 30, 30));
        for (int x = 0; x < SIZE; x += UNIT)
            g.drawLine(x, 0, x, SIZE);
        for (int y = 0; y < SIZE; y += UNIT)
            g.drawLine(0, y, SIZE, y);

        // Draw food
        g.setColor(Color.RED);
        g.fillOval(food.x + 2, food.y + 2, UNIT - 4, UNIT - 4);

        // Draw snake
        for (int i = 0; i < snake.size(); i++) {
            Point p = snake.get(i);
            if (i == 0) {
                // Head
                g.setColor(Color.YELLOW);
                g.fillRoundRect(p.x + 1, p.y + 1, UNIT - 2, UNIT - 2, 8, 8);
            } else {
                // Body gradient effect
                int green = Math.max(100, 200 - i * 3);
                g.setColor(new Color(0, green, 0));
                g.fillRoundRect(p.x + 1, p.y + 1, UNIT - 2, UNIT - 2, 6, 6);
            }
        }

        // Draw score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Score: " + (snake.size() - 1), 8, 18);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP    && dy == 0) { dx = 0;     dy = -UNIT; }
        if (key == KeyEvent.VK_DOWN  && dy == 0) { dx = 0;     dy =  UNIT; }
        if (key == KeyEvent.VK_LEFT  && dx == 0) { dx = -UNIT; dy =  0;    }
        if (key == KeyEvent.VK_RIGHT && dx == 0) { dx =  UNIT; dy =  0;    }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day10_Snake::new);
    }
}