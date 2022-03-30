package com.multiplex.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.multiplex.entity.Hall;
import com.multiplex.exception.HallAlreadyExistException;
import com.multiplex.exception.HallNotFoundException;
import com.multiplex.repository.HallDao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HallServiceTests {

	@InjectMocks
	private HallService hallService;

	@Mock
	private HallDao hallDao;

	@InjectMocks
	private Hall hall;

	@BeforeEach
	public void setUp() {
		hall = new Hall();
		hall.setHallId(201);
		hall.setHallDesc("Large");
		hall.setTotalCapacity(500);
	}

	@Test
	public void getHallTest() {
		Mockito.doReturn(Stream.of(hall, hall).collect(Collectors.toList())).when(hallDao).findAll();
		assertEquals(Stream.of(hall, hall).collect(Collectors.toList()), hallService.getHall());
		assertEquals(2, hallService.getHall().size());
	}

	@Test
	public void addHallTest() throws HallAlreadyExistException {
		Mockito.doReturn(hall).when(hallDao).save(Mockito.any());
		assertEquals(hall.getHallId(), hallService.addHall(hall).getHallId());
		assertEquals(hall.getHallDesc(), hallService.addHall(hall).getHallDesc());
	}

	@Test
	public void updateHallTest() {
		Mockito.doReturn(hall).when(hallDao).save(Mockito.any());
		assertEquals(hall.getHallId(), hallService.updateHall(hall).getHallId());
		assertEquals(hall.getHallDesc(), hallService.updateHall(hall).getHallDesc());
	}

	@Test
	public void getHallByIdTest() throws HallNotFoundException {
		int hallId = 201;
		Mockito.when(hallDao.findById(hallId)).thenReturn(Optional.of(hall));
		assertEquals(hall.getHallId(), hallService.getHallById(hallId).getHallId());
		assertEquals(hall.getHallDesc(), hallService.getHallById(hallId).getHallDesc());
	}

	@Test
	public void deleteMoviesTest() throws HallNotFoundException {
		int hallId = 101;
		hallService.deleteHall(hallId);
		Mockito.verify(hallDao, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
	}

}
