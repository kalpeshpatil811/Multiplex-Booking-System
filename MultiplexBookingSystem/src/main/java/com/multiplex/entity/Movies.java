package com.multiplex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**************************
 * Movies Entity Class
 *
 * Created By: Akshata Gurupwar
 * Date:17/03/2022
 ***************************/

@Entity
@Table(name = "movies")
public class Movies {

	@Id
	@Column(name = "movieId")
	private int movieId;

	@Column(name = "movieName")
	private String movieName;
	
	@Column(name = "prize")
	private String prize;
	
	@Column(name = "description")
	private String description;

	public Movies() {
		super();
	}

	public Movies(int movieId, String movieName, String prize, String description) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.prize = prize;
		this.description = description;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
