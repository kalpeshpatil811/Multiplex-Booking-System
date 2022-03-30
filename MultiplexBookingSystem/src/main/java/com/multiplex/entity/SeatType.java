package com.multiplex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**************************
 * SeatType Entity Class
 *
 * Created By: Onkar Kulkarni
 * Date: 17/03/2022
 ***************************/

@Entity
@Table(name = "seatType")
public class SeatType {

	@Id
	@Column(name = "seatTypeId")
	private int seatTypeId;
	
	@Column(name = "seatTypeDesc")
	private String seatTypeDesc;
	
	@Column(name = "seatFare")
	private float seatFare;

	public SeatType() {
		super();
	}

	public SeatType(int seatTypeId, String seatTypeDesc, float seatFare) {
		super();
		this.seatTypeId = seatTypeId;
		this.seatTypeDesc = seatTypeDesc;
		this.seatFare = seatFare;
	}

	public int getSeatTypeId() {
		return seatTypeId;
	}

	public void setSeatTypeId(int seatTypeId) {
		this.seatTypeId = seatTypeId;
	}

	public String getSeatTypeDesc() {
		return seatTypeDesc;
	}

	public void setSeatTypeDesc(String seatTypeDesc) {
		this.seatTypeDesc = seatTypeDesc;
	}

	public float getSeatFare() {
		return seatFare;
	}

	public void setSeatFare(float seatFare) {
		this.seatFare = seatFare;
	}
	
}