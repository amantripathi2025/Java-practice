package Thread;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrameDemo extends JFrame implements ActionListener {
    JButton close;
    MyFrameDemo(){
        super("My First Frame");
        setSize(500,600);
        setLayout(null);
        close = new JButton("Close");

        add(close);
        close.setBounds(200,300,100,30);
        close.addActionListener(this); //Registration of event

    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand() == "Close") {
            System.exit(0); // Close application
        }
    }

    public static void main(String[] args) {

        MyFrameDemo mfd = new MyFrameDemo();
        mfd.setVisible(true);

    }
}
