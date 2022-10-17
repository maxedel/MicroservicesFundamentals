package com.epam.resourceProcessor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESOURCES")
public class Resource {

	@Id
	private Long id;
	private String audio;

	public Resource() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	@Override
	public String toString() {
		return "Resource{" +
				"id=" + id +
				", audio='" + audio + '\'' +
				'}';
	}
}
