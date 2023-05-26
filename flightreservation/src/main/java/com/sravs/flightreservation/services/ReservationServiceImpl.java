package com.sravs.flightreservation.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sravs.flightreservation.dto.ReservationRequest;
import com.sravs.flightreservation.model.Flight;
import com.sravs.flightreservation.model.Passenger;
import com.sravs.flightreservation.model.Reservation;
import com.sravs.flightreservation.repos.FlightRepository;
import com.sravs.flightreservation.repos.PassengerRepository;
import com.sravs.flightreservation.repos.ReservationRepositoy;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	ReservationRepositoy reservationRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		// TODO Auto-generated method stub
		Long flightId = request.getFlightId();
		Optional<Flight> flight = flightRepository.findById(flightId);
		Passenger passenger = new Passenger();

		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());

		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight.get());
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		Reservation savedReservation = reservationRepository.save(reservation);
		return savedReservation;
	}

}
