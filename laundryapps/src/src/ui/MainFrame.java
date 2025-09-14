package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Laundry Apps");
		lblNewLabel.setForeground(new Color(121, 53, 80));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(56, 40, 157, 25);
		contentPane.add(lblNewLabel);
		
		
		JButton btnKLR = new JButton("KELUAR");
		btnKLR.setBounds(54, 284, 512, 37);
		contentPane.add(btnKLR);
		
		JButton btnPSN = new JButton("PESANAN");
		btnPSN.setBounds(56, 92, 143, 59);
		contentPane.add(btnPSN);
		
		JButton btnLYN = new JButton("LAYANAN");
		btnLYN.setBounds(248, 92, 143, 59);
		contentPane.add(btnLYN);
		
		JButton btnPLG = new JButton("PELANGGAN");
		btnPLG.setBounds(423, 92, 143, 59);
		contentPane.add(btnPLG);
		
		JButton btnPGN = new JButton("PENGGUNA");
		btnPGN.setBounds(56, 186, 143, 59);
		contentPane.add(btnPGN);
		
		JButton btnLPR = new JButton("LAPORAN");
		btnLPR.setBounds(248, 186, 143, 59);
		contentPane.add(btnLPR);
		
		JButton btnPRF = new JButton("PROFILE");
		btnPRF.setBounds(423, 186, 143, 59);
		contentPane.add(btnPRF);
	}
}
