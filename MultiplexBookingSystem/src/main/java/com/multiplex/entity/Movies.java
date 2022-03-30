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

	public Movies() {
		super();
	}

	public Movies(int movieId, String movieName) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
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

}
