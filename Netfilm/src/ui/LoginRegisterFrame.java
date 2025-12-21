package ui;

import DataBase.UserDatabase;

import javax.swing.*;
import java.awt.*;

public class LoginRegisterFrame extends JFrame {
	public static void main(String[] args) {
        new LoginRegisterFrame().setVisible(true);
    }


    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnRegister;

    private UserDatabase userDb;

    public LoginRegisterFrame() {
        userDb = new UserDatabase();
        initComponents();
    }

    private void initComponents() {
        setTitle("Netfilm - Login / Register");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitle = new JLabel("NETFILM");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblUsername = new JLabel("Username");
        JLabel lblPassword = new JLabel("Password");

        txtUsername = new JTextField(15);
        txtPassword = new JPasswordField(15);

        btnLogin = new JButton("Login");
        btnRegister = new JButton("Register");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitle, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        panel.add(lblUsername, gbc);

        gbc.gridx = 1;
        panel.add(txtUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(lblPassword, gbc);

        gbc.gridx = 1;
        panel.add(txtPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(btnLogin, gbc);

        gbc.gridx = 1;
        panel.add(btnRegister, gbc);

        add(panel);

        btnLogin.addActionListener(e -> login());
        btnRegister.addActionListener(e -> register());
    }

    // login
    private void login() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Username dan password wajib diisi",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int userId = userDb.login(username, password);
        if (userId != -1) {
            JOptionPane.showMessageDialog(this, "Login berhasil!");
            SwingUtilities.invokeLater(() -> {
            	NetfilmFrame nf = new NetfilmFrame(userId);
            	nf.setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog(this,
                    "Username atau password salah",
                    "Login gagal",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // register
    private void register() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Username dan password wajib diisi",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean success = userDb.register(username, password);
        if (success) {
            JOptionPane.showMessageDialog(this,
                    "Register berhasil! Silakan login.");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Register gagal (username mungkin sudah ada)",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
