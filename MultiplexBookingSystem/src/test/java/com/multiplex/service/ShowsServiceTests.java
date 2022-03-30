package com.multiplex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
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
import com.multiplex.entity.Movies;
import com.multiplex.entity.Shows;
import com.multiplex.exception.ShowAlreadyExistException;
import com.multiplex.exception.ShowNotFoundException;
import com.multiplex.repository.ShowsDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShowsServiceTests {

	@InjectMocks
	private ShowsService showsService;

	@Mock
	private ShowsDao showsDao;

	@InjectMocks
	private Shows shows;

	@BeforeEach
	public void setUp() {

		Movies movie = new Movies();
		Hall hall = new Hall();
		final Date date = Mockito.mock(Date.class);

		movie.setMovieId(1);
		movie.setMovieName("KGF2");

		hall.setHallId(1);
		hall.setHallDesc("Large Hall");
		hall.setTotalCapacity(1000);

		shows.setShowId(101);
		shows.setSlotNo(1);
		shows.setFromDate(date);
		shows.setToDate(date);
		shows.setMovies(movie);
		shows.setHall(hall);

	}

	@Test
	public void getShowsTests() {
		Mockito.doReturn(Stream.of(shows, shows).collect(Collectors.toList())).when(showsDao).findAll();
		assertEquals(Stream.of(shows, shows).collect(Collectors.toList()), showsService.getShows());
		assertEquals(2, showsService.getShows().size());
	}

	@Test
	public void addShowsTest() throws ShowAlreadyExistException {
		Mockito.doReturn(shows).when(showsDao).save(Mockito.any());
		assertEquals(shows.getShowId(), showsService.addShows(shows).getShowId());

		assertEquals(shows.getMovies().getMovieName(), showsService.addShows(shows).getMovies().getMovieName());

		assertEquals(shows.getHall().getHallId(), showsService.addShows(shows).getHall().getHallId());
	}

	@Test
	public void updateShowsTest() {
		Mockito.doReturn(shows).when(showsDao).save(Mockito.any());
		assertEquals(shows.getShowId(), showsService.updateShows(shows).getShowId());

		assertEquals(shows.getShowId(), showsService.updateShows(shows).getShowId());

		assertEquals(shows.getMovies().getMovieName(), showsService.updateShows(shows).getMovies().getMovieName());

		assertEquals(shows.getHall().getHallId(), showsService.updateShows(shows).getHall().getHallId());
	}

	@Test
	public void getShowsByIdTest() throws ShowNotFoundException {
		int showId = 1001;
		Mockito.when(showsDao.findById(showId)).thenReturn(Optional.of(shows));
		assertEquals(shows, showsService.getShowById(showId));
		assertEquals(shows.getShowId(), showsService.getShowById(showId).getShowId());
	}

	@Test
	public void deleteShowsByIdTest() throws ShowNotFoundException {
		int showId = 1001;
		showsService.deleteShowsById(showId);
		Mockito.verify(showsDao, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
	}

}