package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.SeatType;
import com.multiplex.exception.SeatTypeNotFoundException;

/**************************
 * SeatType Service Interface
 *
 * Created By: Onkar Kulkarni
 * Date:19/03/2022
 ***************************/

public interface ISeatTypeService {
	//GetMapping
	public List<SeatType> getAllSeatTypes();
	
	//PostMapping
	public SeatType addSeatType(SeatType seatType );
	
	//GetMapping By I'd
	public SeatType getSeatType(Integer seatTypeId) throws SeatTypeNotFoundException;
	
	//Update(Put) Mapping
	public SeatType updateSeatType(SeatType seatType);
	
	//Delete Mapping
	public void deleteSeatType(Integer seatTypeId) throws SeatTypeNotFoundException;

}
