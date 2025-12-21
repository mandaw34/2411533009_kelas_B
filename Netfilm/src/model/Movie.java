package model;

public class Movie extends Media {
private int duration;


public Movie(int id, String title, String genre, double rating, int duration) {
    super(id, title, genre, rating);
    this.duration = duration;
}

public int getDuration() {
    return duration;
}

@Override
public String getInfo() {
    return title + " (Movie, " + duration + " menit)";
}

@Override
public void play() {
    System.out.println("Playing movie: " + title);
}
}
