package com.multiplex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**************************
 * HallCapacity Entity Class
 *
 * Created By: Onkar Kulkarni
 * Date: 17/03/2022
 ***************************/

@Entity
@Table(name = "hallCapacity")
public class HallCapacity {

	@Id
	@GeneratedValue
	@Column(name = "hallCapId")
	private int hallCapId;

	@Column(name = "seatCount")
	private int seatCount;
	
	@OneToOne
	@JoinColumn(name = "hallId")
	private Hall hall;

	@OneToOne
	@JoinColumn(name = "seatTypeId")
	private SeatType seatType;

	public HallCapacity() {
		super();
	}

	public HallCapacity(int hallCapId, int seatCount, SeatType seatType, Hall hall) {
		super();
		this.hallCapId = hallCapId;
		this.seatCount = seatCount;
		this.seatType = seatType;
		this.hall = hall;
	}

	public int getHallCapId() {
		return hallCapId;
	}

	public void setHallCapId(int hallCapId) {
		this.hallCapId = hallCapId;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

}
