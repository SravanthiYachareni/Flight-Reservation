package com.sravs.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sravs.flightreservation.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
