import javax.swing.*;
import java.awt.*;

public class KidsMonitorLogin extends JFrame {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final AuthService authService;

    public KidsMonitorLogin(AuthService authService) {
        this.authService = authService;

        setTitle("Kids Monitor App - User Login");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username Label
        gbc.insets = new Insets(10, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Username:"), gbc);

        // Username Text Field
        gbc.gridx = 1;
        usernameField = new JTextField(15);
        add(usernameField, gbc);

        // Password Label
        gbc.insets = new Insets(5, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Password:"), gbc);

        // Password Field
        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        add(passwordField, gbc);

        // Login Button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        JButton loginBtn = new JButton("Login");
        add(loginBtn, gbc);

        loginBtn.addActionListener(e -> authenticateUser());
    }

    private void authenticateUser() {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if (authService.authenticate(username, password)) {
            JOptionPane.showMessageDialog(this, "Login Successful! Welcome, " + username + ".");
            usernameField.setText("");
            passwordField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {
        UserDataStore dataStore = new UserDataStore();
        AuthService authService = new AuthService(dataStore);

        SwingUtilities.invokeLater(() -> {
            KidsMonitorLogin loginWindow = new KidsMonitorLogin(authService);
            loginWindow.setVisible(true);
        });
    }
}
