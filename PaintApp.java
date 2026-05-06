import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class PaintApp extends JFrame {
    List<Point> points = new ArrayList<>();
    Color brushColor = Color.BLACK;
    int brushSize = 5;

    PaintApp() {
        setTitle("Paint App");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel canvas = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(brushColor);
                for (Point p : points) {
                    g.fillOval(p.x, p.y, brushSize, brushSize);
                }
            }
        };
        canvas.setBackground(Color.WHITE);
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                points.add(e.getPoint());
                canvas.repaint();
            }
        });

        JPanel toolbar = new JPanel();
        JButton red   = new JButton("Red");
        JButton blue  = new JButton("Blue");
        JButton green = new JButton("Green");
        JButton clear = new JButton("Clear");

        red  .addActionListener(e -> brushColor = Color.RED);
        blue .addActionListener(e -> brushColor = Color.BLUE);
        green.addActionListener(e -> brushColor = Color.GREEN);
        clear.addActionListener(e -> { points.clear(); canvas.repaint(); });

        toolbar.add(red); toolbar.add(blue);
        toolbar.add(green); toolbar.add(clear);

        add(toolbar, BorderLayout.NORTH);
        add(canvas,  BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PaintApp::new);
    }
}