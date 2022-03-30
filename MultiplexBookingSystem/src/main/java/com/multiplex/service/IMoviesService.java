package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.Movies;
import com.multiplex.exception.MovieNotFoundException;

/**************************
 * Movies Service Interface
 *
 * Created By: Akshata Gurupwar
 * Date:19/03/2022
 ***************************/

public interface IMoviesService {
	public Movies addMovies(Movies movies);

	public void deleteMovies(Integer id) throws MovieNotFoundException;

	public Movies updateMovies(Movies movies);

	public List<Movies> getMovies();

	public Movies getMoviesById(Integer id) throws MovieNotFoundException;

}
