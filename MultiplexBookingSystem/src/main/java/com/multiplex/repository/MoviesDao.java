package com.multiplex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.entity.Movies;

public interface MoviesDao extends JpaRepository<Movies, Integer> {

}