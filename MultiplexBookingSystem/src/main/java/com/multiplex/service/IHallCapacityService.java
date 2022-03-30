package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.HallCapacity;

/**************************
 * HallCapacity Service Interface
 *
 * Created By: Onkar Kulkarni
 * Date:19/03/2022
 ***************************/

public interface IHallCapacityService {

	public HallCapacity addHallCapacity(HallCapacity hallCapacity);

	public HallCapacity findByHallCapacityId(int hallCapId);

	public List<HallCapacity> getHallCapacity();

	public HallCapacity updateHallCapacity(HallCapacity updatehallcap);

	public void deleteHallCapacityById(Integer happCapId);

}
