package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import DataBase.MediaDatabase;
import table.MediaTableModel;
import model.Media;

public class NetfilmFrame extends JFrame {

    private JTable tableMedia;
    private MediaTableModel mediaTableModel;
    private MediaDatabase db;
    private int userId;
    
    public NetfilmFrame(int userId) {
    	    this.userId = userId;

    	    setTitle("Netfilm");
    	    setSize(600, 400);
    	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    setLocationRelativeTo(null);
    	    setLayout(new BorderLayout());

    	    db = MediaDatabase.getInstance();

    	    mediaTableModel = new MediaTableModel(db.getAllMedia());
    	    tableMedia = new JTable(mediaTableModel);
    	    add(new JScrollPane(tableMedia), BorderLayout.CENTER);

    	    JPanel panel = new JPanel();
    	    JButton btnDetail = new JButton("Detail Media");
    	    JButton btnTambahWatchlist = new JButton("Tambah ke Watchlist");
    	    JButton btnLihatWatchlist = new JButton("Lihat Watchlist");

    	    panel.add(btnDetail);
    	    panel.add(btnTambahWatchlist);
    	    panel.add(btnLihatWatchlist);
    	    add(panel, BorderLayout.SOUTH);

    	    btnDetail.addActionListener(e -> showDetail());
    	    btnTambahWatchlist.addActionListener(e -> tambahKeWatchlist());
    	    btnLihatWatchlist.addActionListener(e -> lihatWatchlist());
    	}

    private List<Media> watchlist = new ArrayList<>();

    public NetfilmFrame() {
        setTitle("Netfilm");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
       


        db = MediaDatabase.getInstance();

        mediaTableModel = new MediaTableModel(db.getAllMedia());
        tableMedia = new JTable(mediaTableModel);

        add(new JScrollPane(tableMedia), BorderLayout.CENTER);

        JPanel panel = new JPanel();

        JButton btnDetail = new JButton("Detail Media");
        JButton btnTambahWatchlist = new JButton("Tambah ke Watchlist");
        JButton btnLihatWatchlist = new JButton("Lihat Watchlist");

        panel.add(btnDetail);
        panel.add(btnTambahWatchlist);
        panel.add(btnLihatWatchlist);

        add(panel, BorderLayout.SOUTH);

        btnDetail.addActionListener(e -> showDetail());
        btnTambahWatchlist.addActionListener(e -> tambahKeWatchlist());
        btnLihatWatchlist.addActionListener(e -> lihatWatchlist());
    }

    // detail media film/series
    private void showDetail() {
        int row = tableMedia.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih media dulu!");
            return;
        }

        Media m = db.getAllMedia().get(row);
        JOptionPane.showMessageDialog(this,
                "Judul : " + m.getTitle() +
                "\nGenre : " + m.getGenre() +
                "\nRating : " + m.getRating() +
                "\nInfo   : " + m.getInfo(),
                "Detail Media",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // tambah watchlist
    private void tambahKeWatchlist() {
        int row = tableMedia.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih media dulu!");
            return;
        }

        Media m = db.getAllMedia().get(row);

        if (watchlist.contains(m)) {
            JOptionPane.showMessageDialog(this, "Media sudah ada di watchlist!");
            return;
        }

        watchlist.add(m);
        JOptionPane.showMessageDialog(this, "Media ditambahkan ke watchlist");
    }

    // liat watchlist
    private void lihatWatchlist() {
        if (watchlist.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Watchlist masih kosong");
            return;
        }

        StringBuilder sb = new StringBuilder("Watchlist:\n");
        for (int i = 0; i < watchlist.size(); i++) {
            sb.append(i + 1)
              .append(". ")
              .append(watchlist.get(i).getTitle())
              .append("\n");
        }

        int pilihan = JOptionPane.showConfirmDialog(
                this,
                sb.toString() + "\nHapus item pertama?",
                "Watchlist",
                JOptionPane.YES_NO_OPTION
        );

        // crud delete
        if (pilihan == JOptionPane.YES_OPTION) {
            watchlist.remove(0);
            JOptionPane.showMessageDialog(this, "Item dihapus dari watchlist");
        }
    }
}
