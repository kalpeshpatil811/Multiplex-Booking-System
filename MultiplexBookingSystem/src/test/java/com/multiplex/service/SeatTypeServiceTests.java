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

import com.multiplex.entity.SeatType;
import com.multiplex.exception.SeatTypeNotFoundException;
import com.multiplex.repository.SeatTypeDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeatTypeServiceTests {
	
	@InjectMocks
	private SeatTypeService seatTypeService;

	@Mock
	private SeatTypeDao seatTypeDao;

	@InjectMocks
	private SeatType seatType;

	@BeforeEach
	public void setUp() {
		seatType = new SeatType();
		seatType.setSeatTypeId(101);
		seatType.setSeatTypeDesc("Diamond Row");
		seatType.setSeatFare(500);

	}

	@Test
	public void getAllSeatTypeTest() {
		Mockito.doReturn(Stream.of(seatType, seatType).collect(Collectors.toList())).when(seatTypeDao).findAll();
		assertEquals(Stream.of(seatType, seatType).collect(Collectors.toList()), seatTypeService.getAllSeatTypes());
		assertEquals(2, seatTypeService.getAllSeatTypes().size());
	}

	@Test
	public void addSeatTypeTest() {

		Mockito.doReturn(seatType).when(seatTypeDao).save(Mockito.any());
		assertEquals(seatType.getSeatTypeId(), seatTypeService.addSeatType(seatType).getSeatTypeId());
		assertEquals(seatType.getSeatFare(), seatTypeService.addSeatType(seatType).getSeatFare());
		assertEquals(seatType.getSeatTypeDesc(), seatTypeService.addSeatType(seatType).getSeatTypeDesc());
	}

	@Test
	public void updateSeatTypeTest() {

		Mockito.doReturn(seatType).when(seatTypeDao).save(Mockito.any());
		assertEquals(seatType.getSeatTypeId(), seatTypeService.updateSeatType(seatType).getSeatTypeId());
		assertEquals(seatType.getSeatFare(), seatTypeService.updateSeatType(seatType).getSeatFare());
		assertEquals(seatType.getSeatTypeDesc(), seatTypeService.updateSeatType(seatType).getSeatTypeDesc());

	}

	@Test
	public void getSeatTypeByIdTest() throws SeatTypeNotFoundException {
		int seatTypeId = 1001;
		Mockito.when(seatTypeDao.findById(seatTypeId)).thenReturn(Optional.of(seatType));
		assertEquals(seatType, seatTypeService.getSeatType(seatTypeId));
		assertEquals(seatType.getSeatTypeId(), seatTypeService.getSeatType(seatTypeId).getSeatTypeId());
	}

	@Test
	public void deleteSeatTypeByIdTest() throws SeatTypeNotFoundException {
		int seatTypeId = 1001;
		seatTypeService.deleteSeatType(seatTypeId);
		Mockito.verify(seatTypeDao, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
	}

}
