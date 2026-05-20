import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Day11_ImageViewer extends JFrame {
    JLabel imageLabel = new JLabel("No image loaded", SwingConstants.CENTER);
    JLabel nameLabel  = new JLabel("",                SwingConstants.CENTER);

    Day11_ImageViewer() {
        setTitle("Image Viewer");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        JButton open = new JButton("Open Image");
        open.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                ImageIcon icon = new ImageIcon(f.getAbsolutePath());
                Image img = icon.getImage().getScaledInstance(
                        560, 400, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(img));
                imageLabel.setText("");
                nameLabel.setText("File: " + f.getName());
            }
        });

        JPanel top = new JPanel();
        top.add(open);

        add(top,         BorderLayout.NORTH);
        add(imageLabel,  BorderLayout.CENTER);
        add(nameLabel,   BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day11_ImageViewer::new);
    }
}