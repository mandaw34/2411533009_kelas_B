package DAO;

import java.util.List;
import model.Service;

public interface LayananDAO {
    void save(Service layanan);
    List<Service> show();
    void update(Service layanan);
    void delete(String id);
}
