import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleSwingApp {
    public static void main(String[] args) {
        // Create the frame (window)
        JFrame frame = new JFrame("GitHub Upload Demo");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a button
        JButton button = new JButton("Click Me!");

        // Add action to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Hello! This code is now on GitHub.");
            }
        });

        // Add button to frame and make it visible
        frame.add(button);
        frame.setVisible(true);
    }
}