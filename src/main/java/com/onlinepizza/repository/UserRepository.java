package com.onlinepizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinepizza.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserName(String name);
//	User findByUserId(int id);  // check once
}
