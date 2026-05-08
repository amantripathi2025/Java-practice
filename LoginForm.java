import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {

    LoginForm() {
        setTitle("Login");
        setSize(350, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton login = new JButton("Login");
        JButton clear = new JButton("Clear");

        add(new JLabel("Username:")); add(user);
        add(new JLabel("Password:")); add(pass);
        add(login); add(clear);

        login.addActionListener(e -> {
            if (user.getText().equals("admin") &&
                    new String(pass.getPassword()).equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        clear.addActionListener(e -> {
            user.setText(""); pass.setText("");
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginForm::new);
    }
}