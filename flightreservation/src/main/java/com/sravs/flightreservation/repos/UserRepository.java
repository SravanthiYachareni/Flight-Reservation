package com.sravs.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sravs.flightreservation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	
	User findByEmail(String email);
}
