package com.epam.songService.entity;

public class Song {

	private String title;
	private String artist;
	private String album;
	private String length;
	private String resourceId;
	private String year;

	public Song() {
	}

	public Song(String title,
				String artist,
				String album,
				String length,
				String resourceId,
				String year) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.length = length;
		this.resourceId = resourceId;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
