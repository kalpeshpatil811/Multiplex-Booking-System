package com.multiplex.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.multiplex.repository.BookingDetailDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingDetailsServiceTests {
	
	@InjectMocks
	private BookingDetailsService bookingDetailsService;
	
	@Mock
	private BookingDetailDao bookingDetailDao;
	
	@Test
	public void addBookingDetailTest() {
		
	}
}
