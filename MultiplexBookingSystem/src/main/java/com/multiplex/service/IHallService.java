package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.Hall;
import com.multiplex.exception.HallAlreadyExistException;
import com.multiplex.exception.HallNotFoundException;

/**************************
 * Hall Service Interface
 *
 * Created By: Akshata Gurupwar
 * Date:19/03/2022
 ***************************/

public interface IHallService {

	public Hall addHall(Hall hall) throws HallAlreadyExistException;

	public void deleteHall(Integer id) throws HallNotFoundException;

	public Hall updateHall(Hall hall);

	public List<Hall> getHall();

	public Hall getHallById(Integer id) throws HallNotFoundException;

}
