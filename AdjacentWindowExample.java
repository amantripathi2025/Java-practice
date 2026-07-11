import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdjacentWindowExample {

    public static void main(String[] args) {
        // Run the GUI construction on the Event Dispatch Thread
        SwingUtilities.invokeLater(AdjacentWindowExample::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // 1. Setup the Parent Window
        JFrame parentFrame = new JFrame("Parent Window");
        parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parentFrame.setSize(350, 250);
        parentFrame.setLocationRelativeTo(null); // Centers the window on your screen

        // 2. Setup the Button and add it to the Frame
        JPanel panel = new JPanel();
        JButton openButton = new JButton("Open Adjacent Window");
        panel.add(openButton);
        parentFrame.add(panel);

        // 3. Add the Click Event
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAdjacentWindow(parentFrame);
            }
        });

        // 4. Display the Parent Window
        parentFrame.setVisible(true);
    }

    private static void openAdjacentWindow(JFrame parentFrame) {
        // Create the new Child Window
        JFrame childFrame = new JFrame("Adjacent Window");
        // Use DISPOSE_ON_CLOSE so closing this doesn't kill the whole app
        childFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        childFrame.setSize(300, 250);

        // Calculate the adjacent position (Immediately to the right)
        int parentX = parentFrame.getX();
        int parentY = parentFrame.getY();
        int parentWidth = parentFrame.getWidth();

        // Set the new location and make it visible
        childFrame.setLocation(parentX + parentWidth, parentY);
        childFrame.setVisible(true);
    }
}
