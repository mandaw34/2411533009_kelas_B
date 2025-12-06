package Latihan2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class DownloadGUI extends JFrame {
	
	private JProgressBar bar1, bar2, bar3;
	private JButton start;

	public DownloadGUI() {
		setTitle("Simulasi Donwload Multithreding");
		setSize(400,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(7,7));
		
		bar1= new JProgressBar(0,100);
		bar2= new JProgressBar(0,100);
		bar3= new JProgressBar(0,100);
		
		bar1.setStringPainted(true);
		bar2.setStringPainted(true);
		bar3.setStringPainted(true);
		
		start = new JButton("Mulai Download");
		start.addActionListener(e -> startDownload());
		
		add(new JLabel("File 1: "));
		add(bar1);
		add(new JLabel("File 2: "));
		add(bar2);
		add(new JLabel("File 3: "));
		add(bar3);
		add(start);
	}
	
	private void startDownload() {
		start.setEnabled(false);
		
		new Thread(() -> runDownload(bar1)).start();
		new Thread(() -> runDownload(bar2)).start();
		new Thread(() -> runDownload(bar3)).start();
		
	}
	
	private void runDownload(JProgressBar bar) {
		for (int i = 0; i <=100; i += 10) {
			int val = i;
			
			SwingUtilities.invokeLater(() -> bar.setValue(val));
			
			try {
				Thread.sleep(500);
			}catch (Exception e) {
			e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new DownloadGUI().setVisible(true));
	}
}
