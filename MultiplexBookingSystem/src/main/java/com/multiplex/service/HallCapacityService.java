package com.multiplex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.entity.HallCapacity;
import com.multiplex.repository.HallCapacityDao;

import java.util.List;

/**************************
 * HallCapacity Service Class
 *
 * Created By: Onkar Kulkarni
 * Date:19/03/2022
 ***************************/

@Service
public class HallCapacityService implements IHallCapacityService {

	@Autowired
	private HallCapacityDao hallCapacityDao;

	@Override
	public HallCapacity addHallCapacity(HallCapacity hallCapacity) {
		return hallCapacityDao.save(hallCapacity);
	}

	@Override
	public HallCapacity findByHallCapacityId(int hallCapId) {
		return hallCapacityDao.findById(hallCapId).get();
	}

	@Override
	public List<HallCapacity> getHallCapacity() {
		return hallCapacityDao.findAll();
	}

	@Override
	public HallCapacity updateHallCapacity(HallCapacity updatehallcap) {
		return hallCapacityDao.save(updatehallcap);
	}

	@Override
	public void deleteHallCapacityById(Integer happCapId) {
		hallCapacityDao.deleteById(happCapId);
	}
}
