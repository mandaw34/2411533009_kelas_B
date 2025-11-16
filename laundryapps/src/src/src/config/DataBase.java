package config;

import java.sql.*;
import javax.swing.JOptionPane;

public class DataBase {
    private static Connection conn;

    public static Connection koneksi() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/laundry_apps", 
                    "root", 
                    ""
                );
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return conn;
    }
}
