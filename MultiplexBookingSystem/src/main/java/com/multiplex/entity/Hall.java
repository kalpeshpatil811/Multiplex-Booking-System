package com.multiplex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**************************
 * Hall Entity Class
 *
 * Created By: Akshata Gurupwar
 * Date:17/03/2022
 ***************************/

@Entity
@Table(name = "hall")
public class Hall {

	@Id
	@Column(name = "hallId")
	private Integer hallId;
	@Column(name = "hallDesc")
	private String hallDesc;
	@Column(name = "totalCapacity")
	private Integer totalCapacity;

	public Hall() {
		super();
	}

	public Hall(Integer hallId, String hallDesc, Integer totalCapacity) {
		super();
		this.hallId = hallId;
		this.hallDesc = hallDesc;
		this.totalCapacity = totalCapacity;
	}

	public Integer getHallId() {
		return hallId;
	}

	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}

	public String getHallDesc() {
		return hallDesc;
	}

	public void setHallDesc(String hallDesc) {
		this.hallDesc = hallDesc;
	}

	public Integer getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(Integer totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
	
}
