


package org.example.service;

import org.example.entity.Reservation;

import java.util.List;

public interface ReservationService {
    void addReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void deleteReservation(String deleteReservationId);
    Reservation getReservationById(long reservationId);
    List<Reservation> getAllReservations();
	void deleteReservation(int reservationId);
	Reservation getReservationById(int reservationId);
	void viewReservation();
	void addReservation();
	void deleteReservation(long reservationId);
}
