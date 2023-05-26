package com.sravs.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sravs.flightreservation.dto.ReservationUpdateRequest;
import com.sravs.flightreservation.model.Reservation;
import com.sravs.flightreservation.repos.ReservationRepositoy;

@RestController
@CrossOrigin
public class ReservationRestController {
	@Autowired
	ReservationRepositoy reservationRepository;

	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {

		return reservationRepository.findById(id).get();

	}

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());

		return reservationRepository.save(reservation);

	}

}
