package com.sravs.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sravs.flightreservation.model.Reservation;

public interface ReservationRepositoy extends JpaRepository<Reservation, Long> {

}
