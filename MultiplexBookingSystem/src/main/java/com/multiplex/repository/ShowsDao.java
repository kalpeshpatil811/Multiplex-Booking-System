package com.multiplex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.entity.Shows;

public interface ShowsDao extends JpaRepository<Shows, Integer> {

}