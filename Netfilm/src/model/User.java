package model;

import java.util.List;


public class User {
private int userId;
private String nama;


public User(int userId, String nama) {
	this.userId = userId;
	this.nama = nama;
}


public int getUserId() {
	return userId; }
public String getNama() { 
	return nama; }
}