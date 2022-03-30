package com.multiplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.entity.SeatType;
import com.multiplex.exception.SeatTypeNotFoundException;
import com.multiplex.repository.SeatTypeDao;

/**************************
 * SeatType Service Class
 *
 * Created By: Onkar Kulkarni
 * Date:19/03/2022
 ***************************/

@Service
public class SeatTypeService implements ISeatTypeService {
	@Autowired
	private SeatTypeDao dao;

	// GetMapping
	@Override
	public List<SeatType> getAllSeatTypes() {
		return dao.findAll();
	}

	// PostMapping
	@Override
	public SeatType addSeatType(SeatType seatType) {
		dao.save(seatType);
		return seatType;
	}

	// GetMapping by I'd
	@Override
	public SeatType getSeatType(Integer seatTypeId) throws SeatTypeNotFoundException {
		try {
			return dao.findById(seatTypeId).get();
		} catch (Exception e) {
			throw new SeatTypeNotFoundException("Seat type not found...");
		}
	}

	// Update(Put) Mapping
	@Override
	public SeatType updateSeatType(SeatType seatType) {
		dao.save(seatType);
		return seatType;
	}

	@Override
	public void deleteSeatType(Integer seatTypeId) throws SeatTypeNotFoundException {
		try {
			dao.deleteById(seatTypeId);
		} catch (Exception e) {
			throw new SeatTypeNotFoundException("Seat type not found...");
		}
	}

}
