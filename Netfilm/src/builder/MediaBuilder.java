package builder;

import model.*;

public class MediaBuilder {
	private int id;
	private String title;
	private String genre;
	private double rating;
	private int duration;
	private int seasons;
	private int episodes;

public MediaBuilder setId(int id) {
	this.id = id; return this; }

public MediaBuilder setTitle(String title) { 
	this.title = title; return this; }

public MediaBuilder setGenre(String genre) { 
	this.genre = genre; return this; }

public MediaBuilder setRating(double rating) {
	this.rating = rating; return this; }

public MediaBuilder setDuration(int duration) { 
	this.duration = duration; return this; }

public MediaBuilder setSeasons(int seasons) { 
	this.seasons = seasons; return this; }

public MediaBuilder setEpisodes(int episodes) { 
	this.episodes = episodes; return this; }


public Movie buildMovie() {
return new Movie(id, title, genre, rating, duration);
}


public Series buildSeries() {
return new Series(id, title, genre, rating, seasons, episodes);
}
}