package ui;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Service;
import table.TableLayanan;

public class LayananFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField txtNamaLayanan;
    private JTextField txtHarga;
    private JTable tableLayanan;
    
    LayananRepo repo = new LayananRepo();
    List<Service> ls;
    public String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LayananFrame frame = new LayananFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void reset() {
        txtNamaLayanan.setText("");
        txtHarga.setText("");
    }

    // Load data ke tabel
    public void loadTable() {
        ls = repo.show();
        TableLayanan tl = new TableLayanan(ls);
        tableLayanan.setModel(tl);
        tableLayanan.getTableHeader().setVisible(true);
    }
	/**
	 * Create the frame.
	 */
	public LayananFrame() {
		setTitle("CRUD Layanan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNama = new JLabel("Nama Layanan");
        lblNama.setBounds(30, 30, 100, 25);
        contentPane.add(lblNama);

        txtNamaLayanan = new JTextField();
        txtNamaLayanan.setBounds(140, 30, 400, 25);
        contentPane.add(txtNamaLayanan);

        JLabel lblHarga = new JLabel("Harga");
        lblHarga.setBounds(30, 70, 100, 25);
        contentPane.add(lblHarga);

        txtHarga = new JTextField();
        txtHarga.setBounds(140, 70, 400, 25);
        contentPane.add(txtHarga);

        // Save
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(30, 110, 80, 25);
        contentPane.add(btnSave);
        btnSave.addActionListener(e -> {
            Service layanan = new Service();
            layanan.setJenis(txtNamaLayanan.getText());
            layanan.setHarga(txtHarga.getText());
            repo.save(layanan);
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            reset();
            loadTable();
        });

        // Update
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(120, 110, 90, 25);
        contentPane.add(btnUpdate);
        btnUpdate.addActionListener(e -> {
            if (id != null) {
                Service layanan = new Service();
                layanan.setId(id);
                layanan.setJenis(txtNamaLayanan.getText());
                layanan.setHarga(txtHarga.getText());
                repo.update(layanan);
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
                reset();
                loadTable();
            }
        });

        // Delete
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(220, 110, 90, 25);
        contentPane.add(btnDelete);
        btnDelete.addActionListener(e -> {
            if (id != null) {
                repo.delete(id);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                reset();
                loadTable();
            } else {
                JOptionPane.showMessageDialog(null, "Pilih data dulu!");
            }
        });

        // Cancel
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(320, 110, 90, 25);
        contentPane.add(btnCancel);
        btnCancel.addActionListener(e -> reset());

        // Table
        tableLayanan = new JTable();
        tableLayanan.setBounds(30, 160, 510, 280);
        tableLayanan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                id = tableLayanan.getValueAt(tableLayanan.getSelectedRow(), 0).toString();
                txtNamaLayanan.setText(tableLayanan.getValueAt(tableLayanan.getSelectedRow(), 1).toString());
                txtHarga.setText(tableLayanan.getValueAt(tableLayanan.getSelectedRow(), 2).toString());
            }
        });
        contentPane.add(tableLayanan);
    }
}