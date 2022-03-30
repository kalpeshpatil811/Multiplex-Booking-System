package com.multiplex.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**************************
 * Booking Entity Class
 *
 * Created By: Kalpesh Patil
 * Date:17/03/2022
 ***************************/

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@Column(name = "bookingId")
	private int bookingId;

	@Column(name = "bookedDate")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date bookedDate;

	@Column(name = "showDate")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date showDate;
	
	@ManyToOne
	@JoinColumn(name = "showId")
	private Shows shows;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User users;

	public Booking() {
		super();
	}

	public Booking(int bookingId, Date bookedDate, Date showDate, User users, Shows shows) {
		super();
		this.bookingId = bookingId;
		this.bookedDate = bookedDate;
		this.showDate = showDate;
		this.users = users;
		this.shows = shows;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Shows getShows() {
		return shows;
	}

	public void setShows(Shows shows) {
		this.shows = shows;
	}

}
