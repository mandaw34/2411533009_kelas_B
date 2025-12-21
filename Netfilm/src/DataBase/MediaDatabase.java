package DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class MediaDatabase {

    private static MediaDatabase instance;
    private Connection conn;

    private MediaDatabase() {
        conn = DBConnection.getConnection();
    }
    
    public static MediaDatabase getInstance() {
    	if (instance == null) {
    		instance = new MediaDatabase();
    	}
    	return instance;
    	}

    public List<Media> getAllMedia() {
        List<Media> list = new ArrayList<>();

        String sql = "SELECT * FROM media";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String type = rs.getString("type");

                if (type.equals("MOVIE")) {
                    list.add(new Movie(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getDouble("rating"),
                        rs.getInt("duration")
                    ));
                } else {
                    list.add(new Series(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getDouble("rating"),
                        rs.getInt("seasons"),
                        rs.getInt("episodes")
                    ));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
