import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Day5_Notepad extends JFrame {
    JTextArea area = new JTextArea();

    Day5_Notepad() {
        setTitle("Notepad");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar mb  = new JMenuBar();
        JMenu file   = new JMenu("File");
        JMenu format = new JMenu("Format");

        JMenuItem open  = new JMenuItem("Open");
        JMenuItem save  = new JMenuItem("Save");
        JMenuItem clear = new JMenuItem("Clear");
        JMenuItem bold  = new JMenuItem("Bold");
        JMenuItem exit  = new JMenuItem("Exit");

        open.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                try (BufferedReader br = new BufferedReader(
                        new FileReader(fc.getSelectedFile()))) {
                    area.read(br, null);
                } catch (IOException ex) { ex.printStackTrace(); }
            }
        });

        save.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                try (BufferedWriter bw = new BufferedWriter(
                        new FileWriter(fc.getSelectedFile()))) {
                    area.write(bw);
                } catch (IOException ex) { ex.printStackTrace(); }
            }
        });

        clear.addActionListener(e -> area.setText(""));
        bold .addActionListener(e -> area.setFont(
                area.getFont().isBold()
                        ? new Font("Arial", Font.PLAIN, 14)
                        : new Font("Arial", Font.BOLD,  14)));
        exit .addActionListener(e -> System.exit(0));

        file.add(open); file.add(save); file.add(clear);
        file.addSeparator(); file.add(exit);
        format.add(bold);
        mb.add(file); mb.add(format);
        setJMenuBar(mb);

        area.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(area));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day5_Notepad::new);
    }
}