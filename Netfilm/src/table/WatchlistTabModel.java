package table;

import javax.swing.table.AbstractTableModel;
import model.Media;
import java.util.*;


public class WatchlistTabModel extends AbstractTableModel {
private final String[] columnNames = {"Title", "Genre", "Rating"};
private List<Media> data = new ArrayList<>();


public void setData(List<Media> data) {
	this.data = data;
	fireTableDataChanged();
}


@Override
public int getRowCount() {
	return data.size();
}


@Override
public int getColumnCount() {
	return columnNames.length;
}

@Override
public String getColumnName(int col) {
	return columnNames[col];
}


@Override
public Object getValueAt(int row, int col) {
	Media m = data.get(row);
	switch (col) {
	case 0: return m.getTitle();
	case 1: return m.getGenre();
	case 2: return m.getRating();
	default: return null;
	}
}
}