package Thread;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FirstSwingProject {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First Window");
        frame.setSize(500,600);
        frame.setVisible(true);
        frame.setLayout(null);
        JLabel fname = new JLabel("First Name");
        JLabel lname = new JLabel("Last Name");
        JTextField fnameField = new JTextField("Enter first name: ");
        JTextField lnameField = new JTextField("Enter last name: ");
        JButton close = new JButton("Submit");
        frame.add(fname);
        frame.add(lname);
        frame.add(fnameField);
        frame.add(lnameField);
        frame.add(close);

        frame.setBounds(50,50,100,30);
        fnameField.setBounds(150,50,150,30);

        lnameField.setBounds(150,80,150,30);
        close.setBounds(150,120,150,30);

        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fname = fnameField.getText();
                String lname = lnameField.getText();

                JOptionPane.showMessageDialog(frame,
                        "First Name: " + fname + "\nLast Name: " + lname);
            }
        });

    }
}
