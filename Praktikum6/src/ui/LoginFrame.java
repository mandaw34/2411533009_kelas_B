package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.User;
import error.ValidationException;
import service.LoginService;
import util.ValidationUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Laundry Apps");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(65, 6, 164, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Males aja nyuci, biar kami cuciin");
		lblNewLabel_1.setBounds(65, 33, 221, 16);
		contentPane.add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(65, 90, 240, 25);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(65, 161, 240, 25);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				        String userValue = txtUsername.getText();
				        String passValue = txtPassword.getText();

				        User user = new User(userValue, passValue);

				        try {
				            ValidationUtil.validate(user);
				            LoginService loginService = new LoginService();
				            
				            if (loginService.authenticate(user)) {
				                System.out.println("Login successful");
				                new MainFrame().setVisible(true);
				                dispose();
				            } else {
				                System.out.println("Invalid username or password");
				                JOptionPane.showMessageDialog(null,
				                        "Login Gagal, Invalid username or password");
				            }
				        } catch (ValidationException exception) {
				            System.out.println("Data tidak valid: " + exception.getMessage());
				            JOptionPane.showMessageDialog(null,
				                    "Login Gagal: " + exception.getMessage());
				        } catch (Exception exception) {
				            exception.printStackTrace();
				            JOptionPane.showMessageDialog(null,
				                    "Terjadi kesalahan: " + exception.getMessage());
				        } finally {
				            System.out.println("Selalu di eksekusi");
				        }
				    }
				});

	
		btnLogin.setBounds(56, 215, 249, 29);
		contentPane.add(btnLogin);
		
		JLabel lblUsn = new JLabel("Username");
		lblUsn.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblUsn.setBounds(65, 75, 90, 16);
		contentPane.add(lblUsn);
		
		JLabel lblPw = new JLabel("Password");
		lblPw.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblPw.setBounds(65, 144, 61, 16);
		contentPane.add(lblPw);
		}
}
