import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class MainApp {
    private static final String CONNECTION_STRING = "mongodb+srv://amantripathi7550_db_user:tripathi456@ai-internship-portal.ftfkc7h.mongodb.net/?appName=ai-internship-portal";
    private static final String DATABASE_NAME = "ProjectDB";
    private static final String COLLECTION_NAME = "logins";

    private static MongoCollection<Document> collection;

    public static void main(String[] args) {
        // Initialize MongoDB Atlas connection safely
        try {
            MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            collection = database.getCollection(COLLECTION_NAME);
            System.out.println("Connected successfully to MongoDB Atlas cloud database!");
        } catch (Exception e) {
            System.out.println("Database Connection Failed: " + e.getMessage());
        }

        // Start the application with the Main Login Window
        SwingUtilities.invokeLater(() -> showLoginWindow());
    }

    // =========================================================================
    // WINDOW 1: LOGIN DETAILS
    // =========================================================================
    public static void showLoginWindow() {
        JFrame frame = new JFrame("Login Details");
        frame.setSize(400, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel lblTitle = new JLabel("Login System", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBounds(20, 15, 340, 25);
        frame.add(lblTitle);

        JLabel lblId = new JLabel("Enter Login ID:");
        lblId.setBounds(30, 60, 110, 25);
        frame.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(150, 60, 180, 25);
        frame.add(txtId);

        JLabel lblPass = new JLabel("Enter Password:");
        lblPass.setBounds(30, 100, 110, 25);
        frame.add(lblPass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(150, 100, 180, 25);
        frame.add(txtPass);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(60, 150, 110, 30);
        frame.add(btnLogin);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(200, 150, 110, 30);
        frame.add(btnCancel);

        JButton btnCreate = new JButton("Create New ID");
        btnCreate.setBounds(60, 200, 250, 25);
        frame.add(btnCreate);

        JButton btnForgot = new JButton("Forgot Password");
        btnForgot.setBounds(60, 235, 250, 25);
        frame.add(btnForgot);

        // Event Handling: Login verification
        btnLogin.addActionListener(e -> {
            String loginId = txtId.getText().trim();
            String password = new String(txtPass.getPassword());

            if (loginId.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Must accept value! Fields cannot be empty.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (collection == null) {
                JOptionPane.showMessageDialog(frame, "Database connection not configured! Please check internet/connection string.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Document userDoc = collection.find(Filters.eq("_id", loginId)).first();
            if (userDoc != null && userDoc.getString("password").equals(password)) {
                frame.dispose();
                showDashboardWindow(loginId);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Login ID or Password!", "Authentication Failed", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancel.addActionListener(e -> System.exit(0));
        btnCreate.addActionListener(e -> {
            frame.dispose();
            showCreateIdWindow();
        });
        btnForgot.addActionListener(e -> showForgotPasswordWindow());

        frame.setVisible(true);
    }

    // =========================================================================
    // WINDOW 2: CREATE NEW ID
    // =========================================================================
    public static void showCreateIdWindow() {
        JFrame frame = new JFrame("Create ID");
        frame.setSize(440, 380);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel lblTitle = new JLabel("Account Creation Window", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setBounds(20, 15, 380, 25);
        frame.add(lblTitle);

        JLabel lblId = new JLabel("L. I. D. (Login ID):");
        lblId.setBounds(30, 60, 120, 25);
        frame.add(lblId);

        JTextField txtId = new JTextField();
        txtId.setBounds(160, 60, 140, 25);
        frame.add(txtId);

        JButton btnCheck = new JButton("Check");
        btnCheck.setBounds(310, 60, 80, 25);
        frame.add(btnCheck);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(30, 100, 120, 25);
        frame.add(lblPass);

        JPasswordField txtPass = new JPasswordField();
        txtPass.setBounds(160, 100, 140, 25);
        frame.add(txtPass);

        JLabel lblRetype = new JLabel("Retype Pass:");
        lblRetype.setBounds(30, 140, 120, 25);
        frame.add(lblRetype);

        JPasswordField txtRetype = new JPasswordField();
        txtRetype.setBounds(160, 140, 140, 25);
        frame.add(txtRetype);

        JButton btnMatch = new JButton("Match");
        btnMatch.setBounds(310, 140, 80, 25);
        frame.add(btnMatch);

        JLabel lblContact = new JLabel("Email / Mobile:");
        lblContact.setBounds(30, 180, 120, 25);
        frame.add(lblContact);

        JTextField txtContact = new JTextField();
        txtContact.setBounds(160, 180, 230, 25);
        frame.add(txtContact);

        JButton btnCreate = new JButton("Create ID");
        btnCreate.setBounds(70, 250, 120, 35);
        frame.add(btnCreate);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(230, 250, 120, 35);
        frame.add(btnCancel);

        btnCheck.addActionListener(e -> {
            String id = txtId.getText().trim();
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a Login ID first.", "Input Required", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (collection == null) return;
            long count = collection.countDocuments(Filters.eq("_id", id));
            if (count > 0) {
                JOptionPane.showMessageDialog(frame, "This ID is already taken. Try another!", "Unavailable", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "ID Available!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnMatch.addActionListener(e -> {
            String p1 = new String(txtPass.getPassword());
            String p2 = new String(txtRetype.getPassword());
            if (p1.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Password field is empty.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (p1.equals(p2)) {
                JOptionPane.showMessageDialog(frame, "Passwords Match perfectly!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Passwords do not match. Check spelling.", "Mismatch", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCreate.addActionListener(e -> {
            String id = txtId.getText().trim();
            String p1 = new String(txtPass.getPassword());
            String p2 = new String(txtRetype.getPassword());
            String contact = txtContact.getText().trim();

            if (id.isEmpty() || p1.isEmpty() || contact.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "All fields are required to create an account.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!p1.equals(p2)) {
                JOptionPane.showMessageDialog(frame, "Passwords must match before creation.", "Validation Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (collection == null) return;

            Document doc = new Document("_id", id)
                    .append("password", p1)
                    .append("contact", contact);

            try {
                collection.insertOne(doc);
                JOptionPane.showMessageDialog(frame, "Account successfully created!", "Success", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                showLoginWindow();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Failed to write data. Account ID might already exist.", "Database Write Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancel.addActionListener(e -> {
            frame.dispose();
            showLoginWindow();
        });

        frame.setVisible(true);
    }

    // =========================================================================
    // WINDOW 3: FORGOT PASSWORD
    // =========================================================================
    public static void showForgotPasswordWindow() {
        JFrame frame = new JFrame("Forgot Password");
        frame.setSize(400, 260);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel lblTitle = new JLabel("Recovery Manager", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
        lblTitle.setBounds(20, 15, 340, 25);
        frame.add(lblTitle);

        JLabel lblSearch = new JLabel("Enter your Login ID, Email, or Mobile Number:");
        lblSearch.setBounds(30, 55, 340, 25);
        frame.add(lblSearch);

        JTextField txtSearch = new JTextField();
        txtSearch.setBounds(30, 90, 320, 25);
        frame.add(txtSearch);

        JButton btnCheck = new JButton("Check Account");
        btnCheck.setBounds(40, 145, 140, 35);
        frame.add(btnCheck);

        JButton btnClose = new JButton("Close");
        btnClose.setBounds(200, 145, 140, 35);
        frame.add(btnClose);

        btnCheck.addActionListener(e -> {
            String input = txtSearch.getText().trim();
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please type an identifier.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (collection == null) return;

            Document foundUser = collection.find(Filters.or(
                    Filters.eq("_id", input),
                    Filters.eq("contact", input)
            )).first();

            if (foundUser != null) {
                String userId = foundUser.getString("_id");
                JOptionPane.showMessageDialog(frame, "Account Verified! Please set a new password.", "Success", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                showResetPasswordWindow(userId);
            } else {
                JOptionPane.showMessageDialog(frame, "No matching registration records found.", "Not Found", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnClose.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }

    // =========================================================================
    // WINDOW 4: RESET PASSWORD
    // =========================================================================
    public static void showResetPasswordWindow(String userId) {
        JFrame frame = new JFrame("Reset Password");
        frame.setSize(400, 250);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel lblTitle = new JLabel("Reset Password for: " + userId, SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
        lblTitle.setBounds(20, 15, 340, 25);
        frame.add(lblTitle);

        JLabel lblNewPass = new JLabel("New Password:");
        lblNewPass.setBounds(30, 60, 130, 25);
        frame.add(lblNewPass);

        JPasswordField txtNewPass = new JPasswordField();
        txtNewPass.setBounds(170, 60, 170, 25);
        frame.add(txtNewPass);

        JLabel lblConfirmPass = new JLabel("Confirm Password:");
        lblConfirmPass.setBounds(30, 100, 130, 25);
        frame.add(lblConfirmPass);

        JPasswordField txtConfirmPass = new JPasswordField();
        txtConfirmPass.setBounds(170, 100, 170, 25);
        frame.add(txtConfirmPass);

        JButton btnUpdate = new JButton("Update Password");
        btnUpdate.setBounds(50, 150, 150, 30);
        frame.add(btnUpdate);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(210, 150, 100, 30);
        frame.add(btnCancel);

        btnUpdate.addActionListener(e -> {
            String newPass = new String(txtNewPass.getPassword());
            String confirmPass = new String(txtConfirmPass.getPassword());

            if (newPass.isEmpty() || confirmPass.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Fields cannot be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!newPass.equals(confirmPass)) {
                JOptionPane.showMessageDialog(frame, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                collection.updateOne(Filters.eq("_id", userId), new Document("$set", new Document("password", newPass)));
                JOptionPane.showMessageDialog(frame, "Password updated successfully! You can now login.", "Success", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Failed to update password: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancel.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }

    // =========================================================================
    // WINDOW 5: DASHBOARD (MAIN ENTRY SUCCESS)
    // =========================================================================
    public static void showDashboardWindow(String activeUser) {
        JFrame frame = new JFrame("Dashboard");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JLabel lblWelcome = new JLabel("Welcome to Main Dashboard Portal", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 20));
        lblWelcome.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
        frame.add(lblWelcome, BorderLayout.NORTH);

        JTextArea txtArea = new JTextArea();
        txtArea.setText("\n  Active User Session: " + activeUser + "\n  System Status: Online\n  Database Sync: MongoDB Atlas Cloud Connected Securely.\n\n  You have successfully authenticated past the secure login system.\n  Feel free to continue building your core project logic here!");
        txtArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtArea.setEditable(false);
        txtArea.setBackground(new Color(245, 245, 245));

        JScrollPane scrollPane = new JScrollPane(txtArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(e -> {
            frame.dispose();
            showLoginWindow();
        });

        JPanel pnlBottom = new JPanel();
        pnlBottom.add(btnLogout);
        frame.add(pnlBottom, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}