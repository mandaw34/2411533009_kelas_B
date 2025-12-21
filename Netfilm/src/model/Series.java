package model;

public class Series extends Media {
    private int seasons;
    private int episodes;

    public Series(int id, String title, String genre, double rating, int seasons, int episodes) {
        super(id, title, genre, rating);
        this.seasons = seasons;
        this.episodes = episodes;
    }

    public int getSeasons() {
        return seasons;
    }

    public int getEpisodes() {
        return episodes;
    }

    @Override
    public String getInfo() {
        return title + " (Series, " + seasons + " season)";
    }

    @Override
    public void play() {
        System.out.println("Playing series: " + title);
    }
}
