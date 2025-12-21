package model;

public class Watchlist {
private int userId;
private int mediaId;

	public Watchlist(int userId, int mediaId) {
		this.userId = userId;
		this.mediaId = mediaId;
		}


	public int getUserId() {
		return userId;
	}


	public int getMediaId() {
		return mediaId;
		}
	}