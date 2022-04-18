package com.multiplex.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/***************************
 * Shows Entity Class
 *
 * Created By: Laxman Adkune
 * Date:17/03/2022
 ***************************/

@Entity
@Table(name = "shows")
public class Shows {

	@Id
	@Column(name = "showId")
	private int showId;

	@Column(name = "slotNo")
	private int slotNo;
	
	@Column(name="showTime")
	private String showTime;
	
	@Column(name = "fromDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fromDate;

	@Column(name = "toDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date toDate;

	@ManyToOne
	@JoinColumn(name = "hallId")
	private Hall hall;
	
	@ManyToOne
	@JoinColumn(name = "movieId")
	private Movies movies;

	public Shows() {
		super();
	}

	public Shows(int showId, int slotNo, String showTime, Date fromDate, Date toDate, Hall hall, Movies movies) {
		super();
		this.showId = showId;
		this.slotNo = slotNo;
		this.showTime = showTime;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.hall = hall;
		this.movies = movies;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public int getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Movies getMovies() {
		return movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}

}
