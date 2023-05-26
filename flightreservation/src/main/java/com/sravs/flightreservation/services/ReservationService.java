package com.sravs.flightreservation.services;

import com.sravs.flightreservation.dto.ReservationRequest;
import com.sravs.flightreservation.model.Reservation;

public interface ReservationService {
	
	public  Reservation bookFlight(ReservationRequest request);

}
