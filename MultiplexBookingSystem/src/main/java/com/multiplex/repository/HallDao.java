package com.multiplex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.entity.Hall;

public interface HallDao extends JpaRepository<Hall, Integer> {

}