
package org.example.dao;

import org.example.entity.Reservation;
import java.util.List;

public interface ReservationDAO {
    void saveReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void deleteReservation(Reservation reservation);
    Reservation getReservationById(long id);
    List<Reservation> getAllReservations();
	Reservation getReservationById(int id);
}
