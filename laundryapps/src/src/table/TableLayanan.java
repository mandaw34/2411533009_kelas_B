package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Service;

public class TableLayanan extends AbstractTableModel {
    List<Service> ls;
    private String[] columnNames = {"ID", "Nama Layanan", "Harga"};

    public TableLayanan(List<Service> ls) {
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
    	Service layanan = ls.get(rowIndex);
        switch (columnIndex) {
            case 0: return layanan.getId();
            case 1: return layanan.getJenis();
            case 2: return layanan.getHarga();
            default: return null;
        }
    }
}
