package com.multiplex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.multiplex.entity.Hall;
import com.multiplex.entity.HallCapacity;
import com.multiplex.entity.SeatType;
import com.multiplex.exception.SeatTypeNotFoundException;
import com.multiplex.repository.HallCapacityDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HallCapacityServiceTests {
	@InjectMocks
	private HallCapacityService hallCapacityService;

	@Mock
	private HallCapacityDao hallCapacityDao;

	@InjectMocks
	private HallCapacity hallCapacity;

	@BeforeEach
	public void setUP() {
		hallCapacity = new HallCapacity();
		Hall hall = new Hall();
		SeatType seatType = new SeatType();

		hallCapacity.setHallCapId(11);
		hallCapacity.setSeatCount(600);

		hall.setHallId(1);
		hall.setHallDesc("Large Hall");
		hall.setTotalCapacity(1000);

		seatType.setSeatTypeId(101);
		seatType.setSeatTypeDesc("Diamond Row");
		seatType.setSeatFare(500);

		hallCapacity.setSeatType(seatType);
		hallCapacity.setHall(hall);
	}

	@Test
	public void getHallCapacityTest() {
		Mockito.doReturn(Stream.of(hallCapacity, hallCapacity).collect(Collectors.toList())).when(hallCapacityDao)
				.findAll();
		assertEquals(Stream.of(hallCapacity, hallCapacity).collect(Collectors.toList()),
				hallCapacityService.getHallCapacity());
		assertEquals(2, hallCapacityService.getHallCapacity().size());
	}

	@Test
	public void addHallCapacityTest() {

		Mockito.doReturn(hallCapacity).when(hallCapacityDao).save(Mockito.any());
		assertEquals(hallCapacity.getHallCapId(), hallCapacityService.addHallCapacity(hallCapacity).getHallCapId());
		assertEquals(hallCapacity.getSeatCount(), hallCapacityService.addHallCapacity(hallCapacity).getSeatCount());
		assertEquals(hallCapacity.getSeatType().getSeatFare(),
				hallCapacityService.addHallCapacity(hallCapacity).getSeatType().getSeatFare());
		assertEquals(hallCapacity.getSeatType().getSeatTypeDesc(),
				hallCapacityService.addHallCapacity(hallCapacity).getSeatType().getSeatTypeDesc());
		assertEquals(hallCapacity.getHall().getHallId(),
				hallCapacityService.addHallCapacity(hallCapacity).getHall().getHallId());
		assertEquals(hallCapacity.getHall().getHallDesc(),
				hallCapacityService.addHallCapacity(hallCapacity).getHall().getHallDesc());
		assertEquals(hallCapacity.getHall().getTotalCapacity(),
				hallCapacityService.addHallCapacity(hallCapacity).getHall().getTotalCapacity());

	}

	@Test
	public void updateHallCapacityTest() {

		Mockito.doReturn(hallCapacity).when(hallCapacityDao).save(Mockito.any());
		assertEquals(hallCapacity.getHallCapId(), hallCapacityService.updateHallCapacity(hallCapacity).getHallCapId());
		assertEquals(hallCapacity.getSeatCount(), hallCapacityService.updateHallCapacity(hallCapacity).getSeatCount());
		assertEquals(hallCapacity.getSeatType().getSeatFare(),
				hallCapacityService.updateHallCapacity(hallCapacity).getSeatType().getSeatFare());
		assertEquals(hallCapacity.getSeatType().getSeatTypeDesc(),
				hallCapacityService.updateHallCapacity(hallCapacity).getSeatType().getSeatTypeDesc());
		assertEquals(hallCapacity.getHall().getHallId(),
				hallCapacityService.updateHallCapacity(hallCapacity).getHall().getHallId());
		assertEquals(hallCapacity.getHall().getHallDesc(),
				hallCapacityService.updateHallCapacity(hallCapacity).getHall().getHallDesc());
		assertEquals(hallCapacity.getHall().getTotalCapacity(),
				hallCapacityService.updateHallCapacity(hallCapacity).getHall().getTotalCapacity());

	}

	@Test
	public void getHallCapacityByIdTest() throws SeatTypeNotFoundException {
		int hallCapacityTypeId = 1001;
		Mockito.when(hallCapacityDao.findById(hallCapacityTypeId)).thenReturn(Optional.of(hallCapacity));
		assertEquals(hallCapacity, hallCapacityService.findByHallCapacityId(hallCapacityTypeId));
		assertEquals(hallCapacity.getHallCapId(),
				hallCapacityService.findByHallCapacityId(hallCapacityTypeId).getHallCapId());
	}

	@Test
	public void deleteHallCapacityByIdTest() throws SeatTypeNotFoundException {
		int hallCapacityTypeId = 1001;
		hallCapacityService.deleteHallCapacityById(hallCapacityTypeId);
		Mockito.verify(hallCapacityDao, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
	}

}
