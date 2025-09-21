package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import config.DataBase;
import model.Customer;

public class CustomerRepo implements CustomerDAO {
    private Connection connection;

    final String insert = "INSERT INTO pelanggan (nama_pelanggan, alamat, telepon) VALUES (?, ?, ?)";
    final String select = "SELECT * FROM pelanggan";
    final String update = "UPDATE pelanggan SET nama_pelanggan=?, alamat=?, telepon=? WHERE id=?";
    final String delete = "DELETE FROM pelanggan WHERE id=?";

    public CustomerRepo() {
        connection = DataBase.koneksi();
    }

    @Override
    public void save(Customer customer) {
        try (PreparedStatement st = connection.prepareStatement(insert)) {
            st.setString(1, customer.getNama());
            st.setString(2, customer.getAlamat());
            st.setString(3, customer.getNomorHp());
            st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(CustomerRepo.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<Customer> show() {
        List<Customer> ls = new ArrayList<>();
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(select)) {
            while (rs.next()) {
            	Customer pelanggan = new Customer();
                pelanggan.setId(rs.getString("id"));
                pelanggan.setNama(rs.getString("nama_pelanggan"));
                pelanggan.setAlamat(rs.getString("alamat"));
                pelanggan.setNomorHp(rs.getString("telepon"));
                ls.add(pelanggan);
            }
        } catch (SQLException e) {
            Logger.getLogger(CustomerRepo.class.getName()).log(Level.SEVERE, null, e);
        }
        return ls;
    }

    @Override
    public void update(Customer customer) {
        try (PreparedStatement st = connection.prepareStatement(update)) {
            st.setString(1, customer.getNama());
            st.setString(2, customer.getAlamat());
            st.setString(3, customer.getNomorHp());
            st.setString(4, customer.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(CustomerRepo.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String id) {
        try (PreparedStatement st = connection.prepareStatement(delete)) {
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(CustomerRepo.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
