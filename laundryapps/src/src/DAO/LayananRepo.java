package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import config.DataBase;
import model.Service;

public class LayananRepo implements LayananDAO {
    private Connection connection;

    final String insert = "INSERT INTO layanan (nama_layanan, harga) VALUES (?, ?)";
    final String select = "SELECT * FROM layanan";
    final String update = "UPDATE layanan SET nama_layanan=?, harga=? WHERE id=?";
    final String delete = "DELETE FROM layanan WHERE id=?";

    public LayananRepo() {
        connection = DataBase.koneksi();
    }

    @Override
    public void save(Service layanan) {
        try (PreparedStatement st = connection.prepareStatement(insert)) {
            st.setString(1, layanan.getJenis());
            st.setDouble(2, layanan.getHarga());
            st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(LayananRepo.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<Service> show() {
        List<Service> ls = new ArrayList<>();
        try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(select)) {
            while (rs.next()) {
            	Service layanan = new Service();
                layanan.setId(rs.getString("id"));
                layanan.setJenis(rs.getString("nama_layanan"));
                layanan.setHarga(rs.getDouble("harga"));
                ls.add(layanan);
            }
        } catch (SQLException e) {
            Logger.getLogger(LayananRepo.class.getName()).log(Level.SEVERE, null, e);
        }
        return ls;
    }

    @Override
    public void update(Service layanan) {
        try (PreparedStatement st = connection.prepareStatement(update)) {
            st.setString(1, layanan.getJenis());
            st.setDouble(2, layanan.getHarga());
            st.setString(3, layanan.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(LayananRepo.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String id) {
        try (PreparedStatement st = connection.prepareStatement(delete)) {
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(LayananRepo.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
