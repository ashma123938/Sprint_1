package org.example.association;

import javax.persistence.*;

import org.example.entity.Guest;
import org.example.entity.Reservation;

@Entity
@Table(name = "reservation_guest")
public class ReservationGuest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_guest_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @Column(name = "guest_preferences")
    private String guestPreferences;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public String getGuestPreferences() {
        return guestPreferences;
    }

    public void setGuestPreferences(String guestPreferences) {
        this.guestPreferences = guestPreferences;
    }
}
