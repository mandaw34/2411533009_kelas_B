package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Customer;

public class TableCustomer extends AbstractTableModel {
    List<Customer> ls;
    private String[] columnNames = {"ID", "Nama Pelanggan", "Alamat", "Telepon"};

    public TableCustomer(List<Customer> ls) {
        this.ls = ls;
    }

    @Override
    public int getRowCount() {
        return ls.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	Customer customer = ls.get(rowIndex);
        switch (columnIndex) {
            case 0: return customer.getId();
            case 1: return customer.getNama();
            case 2: return customer.getAlamat();
            case 3: return customer.getNomorHp();
            default: return null;
        }
    }
}
