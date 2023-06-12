package com.booking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticketflash")
public class TicketModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String moviename;
	private String language;
	private String genre;
	private String format;
	private String leadactor;
	private String leadActress;
	private String director;
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getLeadactor() {
		return leadactor;
	}
	public void setLeadactor(String leadactor) {
		this.leadactor = leadactor;
	}
	public String getLeadActress() {
		return leadActress;
	}
	public void setLeadActress(String leadActress) {
		this.leadActress = leadActress;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMusicdirector() {
		return musicdirector;
	}
	public void setMusicdirector(String musicdirector) {
		this.musicdirector = musicdirector;
	}
	private String musicdirector;

}
