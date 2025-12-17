package Latihan4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionListener;

public class ThreadPoolGUI extends JFrame {

    private JTextField threadCountField, taskCountField;
    private JButton startButton, clearButton;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskListView;
    private JTextArea logArea;
    private JLabel statusLabel;

    private ExecutorService threadPool;

    public ThreadPoolGUI() {
        setTitle("Aplikasi ThreadPool dengan GUI");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));

        JLabel label_2 = new JLabel("Jumlah Thread:");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        topPanel.add(label_2);
        threadCountField = new JTextField("3", 5);
        topPanel.add(threadCountField);

        JLabel label_3 = new JLabel("Jumlah Tugas:");
        label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        topPanel.add(label_3);
        taskCountField = new JTextField("20", 5);
        topPanel.add(taskCountField);

        startButton = new JButton("Mulai Proses");
        startButton.setFont(new Font("Tahoma", Font.BOLD, 11));
       
        startButton.setFocusPainted(false);
        startButton.addActionListener(e -> startProcessing());
        	
        clearButton = new JButton("Bersihkan Log");
        clearButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        clearButton.addActionListener(e -> clearLog());

        topPanel.add(startButton);
        topPanel.add(clearButton);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        JPanel leftPanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Status Tugas");
        label.setFont(new Font("Tahoma", Font.BOLD, 11));
        leftPanel.add(label, BorderLayout.NORTH);

        taskListModel = new DefaultListModel<>();
        taskListView = new JList<>(taskListModel);

        leftPanel.add(new JScrollPane(taskListView), BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout());
        JLabel label_1 = new JLabel("Log Aktivitas");
        label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        rightPanel.add(label_1, BorderLayout.NORTH);

        logArea = new JTextArea();
        logArea.setEditable(false);
        rightPanel.add(new JScrollPane(logArea), BorderLayout.CENTER);

        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusLabel = new JLabel("Log dibersihkan. Siap untuk proses baru.");
        bottomPanel.add(statusLabel);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    
    private void startProcessing() {
        try {
            int threadCount = Integer.parseInt(threadCountField.getText());
            int taskCount = Integer.parseInt(taskCountField.getText());

            if (threadCount < 1 || taskCount < 1) {
                JOptionPane.showMessageDialog(this,
                        "Jumlah thread dan tugas harus lebih dari 0!",
                        "Input Tidak Valid",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            startButton.setEnabled(false);
            taskListModel.clear();
            logArea.append("=== Memulai Proses Baru ===\n");
            logArea.append("ThreadPool dibuat dengan " + threadCount + " worker threads\n\n");

            statusLabel.setText("Memproses " + taskCount + " tugas dengan " + threadCount + " threads...");

            threadPool = Executors.newFixedThreadPool(threadCount);

            for (int i = 1; i <= taskCount; i++) {
                taskListModel.addElement("Task #" + i + " - Waiting");
            }

            for (int i = 1; i <= taskCount; i++) {
                Task task = new Task(i, logArea, taskListModel);
                threadPool.execute(task);
            }

            new Thread(() -> {
                threadPool.shutdown();
                try {
                    if (threadPool.awaitTermination(5, TimeUnit.MINUTES)) {
                        SwingUtilities.invokeLater(() -> {
                            logArea.append("\n=== Semua tugas selesai ===\n");
                            statusLabel.setText("Semua tugas selesai!");
                            startButton.setEnabled(true);
                        });
                    }
                } catch (InterruptedException e) {
                    threadPool.shutdownNow();
                }
            }).start();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Masukkan angka yang valid!",
                    "Input Tidak Valid",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearLog() {
		logArea.setText("");
		statusLabel.setText("Log dibersihkan. Siap untuk proses baru.");
	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ThreadPoolGUI());
    }
}
