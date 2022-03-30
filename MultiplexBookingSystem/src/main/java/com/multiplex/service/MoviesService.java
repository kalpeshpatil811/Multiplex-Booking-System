package com.multiplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multiplex.entity.Movies;
import com.multiplex.exception.MovieNotFoundException;
import com.multiplex.repository.MoviesDao;

/**************************
 * Movies Service Class
 *
 * Created By: Akshata Gurupwar
 * Date:19/03/2022
 ***************************/

@Service
@Transactional
public class MoviesService implements IMoviesService {

	@Autowired
	private MoviesDao moviesdao;

	@Override
	public Movies addMovies(Movies movies) {
		return moviesdao.save(movies);
	}

	@Override
	public Movies updateMovies(Movies movies) {
		moviesdao.save(movies);
		return movies;
	}

	@Override
	public List<Movies> getMovies() {
		return moviesdao.findAll();
	}

	@Override
	public void deleteMovies(Integer moviesId) throws MovieNotFoundException {
		try {
			moviesdao.deleteById(moviesId);
		} catch (Exception e) {
			throw new MovieNotFoundException("Movie not found...");
		}
	}

	@Override
	public Movies getMoviesById(Integer moviesId) throws MovieNotFoundException {
		try {
			return moviesdao.findById(moviesId).get();
		} catch (Exception e) {
			throw new MovieNotFoundException("Movie not found...");
		}
	}

}
