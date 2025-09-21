package ui;

import java.awt.EventQueue;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DAO.CustomerRepo;
import model.Customer;
import table.TableCustomer;

public class CustomerFrame extends JFrame {

    private JPanel contentPane;
    private JTextField txtNama, txtAlamat, txtTelepon;
    private JTable tablePelanggan;

    CustomerRepo repo = new CustomerRepo();
    List<Customer> ls;
    public String id;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
            	CustomerFrame frame = new CustomerFrame();
                frame.setVisible(true);
                frame.loadTable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void reset() {
        txtNama.setText("");
        txtAlamat.setText("");
        txtTelepon.setText("");
    }

    public void loadTable() {
        ls = repo.show();
        TableCustomer tp = new TableCustomer(ls);
        tablePelanggan.setModel(tp);
        tablePelanggan.getTableHeader().setVisible(true);
    }

    public CustomerFrame() {
        setTitle("CRUD Pelanggan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNama = new JLabel("Nama Pelanggan");
        lblNama.setBounds(30, 30, 120, 25);
        contentPane.add(lblNama);

        txtNama = new JTextField();
        txtNama.setBounds(160, 30, 400, 25);
        contentPane.add(txtNama);

        JLabel lblAlamat = new JLabel("Alamat");
        lblAlamat.setBounds(30, 70, 120, 25);
        contentPane.add(lblAlamat);

        txtAlamat = new JTextField();
        txtAlamat.setBounds(160, 70, 400, 25);
        contentPane.add(txtAlamat);

        JLabel lblTelepon = new JLabel("Telepon");
        lblTelepon.setBounds(30, 110, 120, 25);
        contentPane.add(lblTelepon);

        txtTelepon = new JTextField();
        txtTelepon.setBounds(160, 110, 400, 25);
        contentPane.add(txtTelepon);

        // Save
        JButton btnSave = new JButton("Save");
        btnSave.setBounds(30, 150, 80, 25);
        contentPane.add(btnSave);
        btnSave.addActionListener(e -> {
        	Customer customer = new Customer();
        	customer.setNama(txtNama.getText());
        	customer.setAlamat(txtAlamat.getText());
        	customer.setNomorHp(txtTelepon.getText());
            repo.save(customer);
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            reset();
            loadTable();
        });

  
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(120, 150, 90, 25);
        contentPane.add(btnUpdate);
        btnUpdate.addActionListener(e -> {
            if (id != null) {
            	Customer customer = new Customer();
            	customer.setId(id);
            	customer.setNama(txtNama.getText());
            	customer.setAlamat(txtAlamat.getText());
            	customer.setNomorHp(txtTelepon.getText());
                repo.update(customer);
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate!");
                reset();
                loadTable();
            }
        });


        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(220, 150, 90, 25);
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


        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(320, 150, 90, 25);
        contentPane.add(btnCancel);
        btnCancel.addActionListener(e -> reset());

       
        tablePelanggan = new JTable();
        tablePelanggan.setBounds(30, 200, 580, 250);
        tablePelanggan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                id = tablePelanggan.getValueAt(tablePelanggan.getSelectedRow(), 0).toString();
                txtNama.setText(tablePelanggan.getValueAt(tablePelanggan.getSelectedRow(), 1).toString());
                txtAlamat.setText(tablePelanggan.getValueAt(tablePelanggan.getSelectedRow(), 2).toString());
                txtTelepon.setText(tablePelanggan.getValueAt(tablePelanggan.getSelectedRow(), 3).toString());
            }
        });
        contentPane.add(tablePelanggan);
    }
}
