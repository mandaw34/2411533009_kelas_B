package model;


public abstract class Media {
    protected int id;
    protected String title;
    protected String genre;
    protected double rating;

    public Media(int id, String title, String genre, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public abstract String getInfo();
    public abstract void play();
}
