package com.multiplex.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.multiplex.entity.Movies;
import com.multiplex.exception.MovieNotFoundException;
import com.multiplex.repository.MoviesDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MoviesServiceTests {

	@InjectMocks
	private MoviesService moviesService;

	@Mock
	private MoviesDao moviesDao;

	@InjectMocks
	private Movies movies;

	@BeforeEach
	public void setUp() {
		movies = new Movies();
		movies.setMovieId(101);
		movies.setMovieName("Khushi");
	}

	@Test
	public void getMoviesTest() {
		Mockito.doReturn(Stream.of(movies, movies).collect(Collectors.toList())).when(moviesDao).findAll();
		assertEquals(Stream.of(movies, movies).collect(Collectors.toList()), moviesService.getMovies());
		assertEquals(2, moviesService.getMovies().size());
	}

	@Test
	public void addMoviesTest() {
		Mockito.doReturn(movies).when(moviesDao).save(Mockito.any());
		assertEquals(movies.getMovieId(), moviesService.addMovies(movies).getMovieId());
		assertEquals(movies.getMovieName(), moviesService.addMovies(movies).getMovieName());
	}

	@Test
	public void updateMoviesTest() {
		Mockito.doReturn(movies).when(moviesDao).save(Mockito.any());
		assertEquals(movies.getMovieId(), moviesService.updateMovies(movies).getMovieId());
		assertEquals(movies.getMovieName(), moviesService.updateMovies(movies).getMovieName());
	}

	@Test
	public void getMoviesByIdTest() throws MovieNotFoundException {
		int moviesId = 101;
		Mockito.when(moviesDao.findById(moviesId)).thenReturn(Optional.of(movies));
		assertEquals(movies.getMovieId(), moviesService.getMoviesById(moviesId).getMovieId());
		assertEquals(movies.getMovieName(), moviesService.getMoviesById(moviesId).getMovieName());
	}

	@Test
	public void deleteMoviesTest() throws MovieNotFoundException {
		int moviesId = 101;
		moviesService.deleteMovies(moviesId);
		Mockito.verify(moviesDao, Mockito.atLeastOnce()).deleteById(Mockito.anyInt());
	}

}
