package colin29.court.service;

import java.util.List;

import colin29.court.domain.reservation.Reservation;

public interface ReservationService {
	public List<Reservation> query(String courtName);
}
