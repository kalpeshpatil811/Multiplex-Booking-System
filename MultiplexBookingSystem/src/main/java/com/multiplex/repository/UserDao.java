package com.multiplex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiplex.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
