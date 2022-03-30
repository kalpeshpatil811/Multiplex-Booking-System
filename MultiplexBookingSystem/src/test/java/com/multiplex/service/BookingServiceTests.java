package com.multiplex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
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

import com.multiplex.entity.Booking;
import com.multiplex.entity.Hall;
import com.multiplex.entity.Movies;
import com.multiplex.entity.Shows;
import com.multiplex.entity.User;
import com.multiplex.exception.BookingAlreadyExistException;
import com.multiplex.exception.BookingNotFoundException;
import com.multiplex.repository.BookingDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingServiceTests {

	@InjectMocks
	private BookingService bookingService;

	@Mock
	private BookingDao bookingDao;

	@InjectMocks
	private Booking booking;

	@BeforeEach
	public void setUp() {
		User user = new User();
		Shows show = new Shows();
		Movies movie = new Movies();
		Hall hall = new Hall();
		final Date date = Mockito.mock(Date.class);

		booking.setBookingId(1001);
		booking.setBookedDate(date);
		booking.setShowDate(date);

		movie.setMovieId(1);
		movie.setMovieName("KGF2");

		hall.setHallId(1);
		hall.setHallDesc("Large Hall");
		hall.setTotalCapacity(1000);

		show.setShowId(101);
		show.setSlotNo(1);
		show.setFromDate(date);
		show.setToDate(date);
		show.setMovies(movie);
		show.setHall(hall);

		user.setUserId(101);
		user.setUserName("Kalpesh");
		user.setUserType("Admin");
		user.setEmailId("kalpesh@gmail.com");
		user.setPassword("Pass@123");
		user.setMobileNumber("9876543210");

		booking.setShows(show);
		booking.setUsers(user);
	}

	@Test
	public void getAllBookingsTest() {
		Mockito.doReturn(Stream.of(booking, booking).collect(Collectors.toList())).when(bookingDao).findAll();
		assertEquals(Stream.of(booking, booking).collect(Collectors.toList()), bookingService.getAllBookings());
		assertEquals(2, bookingService.getAllBookings().size());
	}

	@Test
	public void addBookingTest() throws BookingAlreadyExistException {
		Mockito.doReturn(booking).when(bookingDao).save(Mockito.any());
		assertEquals(booking.getBookingId(), bookingService.addBooking(booking).getBookingId());
		assertEquals(booking.getShows().getShowId(), bookingService.addBooking(booking).getShows().getShowId());
		assertEquals(booking.getShows().getMovies().getMovieName(),
				bookingService.addBooking(booking).getShows().getMovies().getMovieName());
		assertEquals(booking.getShows().getHall().getHallId(),
				bookingService.addBooking(booking).getShows().getHall().getHallId());
	}

	@Test
	public void updateBookingTest() {
		Mockito.doReturn(booking).when(bookingDao).save(Mockito.any());
		assertEquals(booking.getBookingId(), bookingService.updateBooking(booking).getBookingId());
		assertEquals(booking.getShows().getShowId(), bookingService.updateBooking(booking).getShows().getShowId());
		assertEquals(booking.getShows().getMovies().getMovieName(),
				bookingService.updateBooking(booking).getShows().getMovies().getMovieName());
		assertEquals(booking.getShows().getHall().getHallId(),
				bookingService.updateBooking(booking).getShows().getHall().getHallId());
	}

	@Test
	public void getBookingByIdTest() throws BookingNotFoundException {
		int bookingId = 1001;
		Mockito.when(bookingDao.findById(bookingId)).thenReturn(Optional.of(booking));
		assertEquals(booking, bookingService.getBookingById(bookingId));
		assertEquals(booking.getBookingId(), bookingService.getBookingById(bookingId).getBookingId());
	}

	@Test
	public void deleteBookingByIdTest() throws BookingNotFoundException {
		int bookingId = 1001;
		bookingService.deleteBookingById(bookingId);
		Mockito.verify(bookingDao, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
	}

}
