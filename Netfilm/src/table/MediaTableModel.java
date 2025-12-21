package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Media;


public class MediaTableModel extends AbstractTableModel {
private List<Media> list;
private String[] columnNames = {"ID", "Judul", "Genre", "Rating"};


public MediaTableModel(List<Media> list) {
	this.list = list;
}


@Override
public int getRowCount() {
	return list.size(); 
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
	Media m = list.get(rowIndex);
	switch (columnIndex) {
	case 0: return m.getId();
	case 1: return m.getTitle();
	case 2: return m.getGenre();
	case 3: return m.getRating();
	default: return null;
	}
	}
}