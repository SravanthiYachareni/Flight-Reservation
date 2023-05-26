package com.sravs.flightreservation.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sravs.flightreservation.dto.ReservationRequest;
import com.sravs.flightreservation.model.Flight;
import com.sravs.flightreservation.model.Reservation;
import com.sravs.flightreservation.repos.FlightRepository;
import com.sravs.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	
	
	@Autowired
	ReservationService reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Optional<Flight> flight = flightRepository.findById(flightId);
		modelMap.addAttribute("flight", flight.get());
		return "completeReservation";

	}
	@RequestMapping(value="/completeReservation", method = RequestMethod.POST)
public String completeReservation(ReservationRequest request,ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg","Reservation created successfully and the id is "+ reservation.getId());
	return "reservationConfirmation";
	
}
}
