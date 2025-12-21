package DataBase;

import java.sql.*;

public class UserDatabase {
    private Connection conn;

    public UserDatabase() {
        conn = DBConnection.getConnection();
    }

    // login
    public int login(String username, String password) {
        String sql = "SELECT id FROM users WHERE username=? AND password=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // gagal
    }

    // register
    public boolean register(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
