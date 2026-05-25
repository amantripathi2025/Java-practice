import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Day15_BankSystem extends JFrame {
    Map<String, Double> accounts = new HashMap<>();
    JTextField accField  = new JTextField(12);
    JTextField amtField  = new JTextField(10);
    JTextArea  log       = new JTextArea(10, 30);
    JLabel     balance   = new JLabel("Balance: —");

    Day15_BankSystem() {
        setTitle("Mini Bank System");
        setSize(480, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));
        getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JPanel form = new JPanel(new GridLayout(3, 2, 8, 8));
        JButton create   = new JButton("Create Account");
        JButton deposit  = new JButton("Deposit");
        JButton withdraw = new JButton("Withdraw");
        JButton check    = new JButton("Check Balance");

        form.add(new JLabel("Account Name:")); form.add(accField);
        form.add(new JLabel("Amount (₹):"));   form.add(amtField);
        form.add(balance);

        create.addActionListener(e -> {
            String acc = accField.getText().trim();
            if (acc.isEmpty()) return;
            if (accounts.containsKey(acc)) {
                log("Account already exists: " + acc); return;
            }
            accounts.put(acc, 0.0);
            log("Account created: " + acc);
        });

        deposit.addActionListener(e -> {
            String acc = accField.getText().trim();
            if (!accounts.containsKey(acc)) { log("Account not found!"); return; }
            double amt = Double.parseDouble(amtField.getText());
            accounts.put(acc, accounts.get(acc) + amt);
            log("Deposited ₹" + amt + " to " + acc);
            updateBalance(acc);
        });

        withdraw.addActionListener(e -> {
            String acc = accField.getText().trim();
            if (!accounts.containsKey(acc)) { log("Account not found!"); return; }
            double amt = Double.parseDouble(amtField.getText());
            if (accounts.get(acc) < amt) { log("Insufficient balance!"); return; }
            accounts.put(acc, accounts.get(acc) - amt);
            log("Withdrawn ₹" + amt + " from " + acc);
            updateBalance(acc);
        });

        check.addActionListener(e -> {
            String acc = accField.getText().trim();
            if (accounts.containsKey(acc)) updateBalance(acc);
            else log("Account not found!");
        });

        JPanel btns = new JPanel(new GridLayout(2, 2, 5, 5));
        btns.add(create); btns.add(deposit);
        btns.add(withdraw); btns.add(check);

        log.setEditable(false);
        log.setFont(new Font("Monospaced", Font.PLAIN, 13));

        add(form,                  BorderLayout.NORTH);
        add(btns,                  BorderLayout.CENTER);
        add(new JScrollPane(log),  BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void log(String msg) {
        log.append("→ " + msg + "\n");
    }

    void updateBalance(String acc) {
        balance.setText(String.format("Balance: ₹%.2f", accounts.get(acc)));
        log("Balance for " + acc + ": ₹" + String.format("%.2f", accounts.get(acc)));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Day15_BankSystem::new);
    }
}