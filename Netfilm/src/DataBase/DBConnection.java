package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/netfilm";
                String user = "root";
                String pass = ""; 

                connection = DriverManager.getConnection(url, user, pass);
                System.out.println("Koneksi database berhasil");
            } catch (SQLException e) {
                System.out.println("Koneksi database gagal");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
