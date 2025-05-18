package org.example;

import org.example.entity.*;
import org.example.serviceimpl.*;

import java.util.List;

public class AllOperations {

    private GuestServiceImpl guestService;
    private RoomServiceImpl roomService;
    private ReservationServiceImpl reservationService;
    private PaymentServiceImpl paymentService;

    public AllOperations(GuestServiceImpl guestService, RoomServiceImpl roomService,
                         ReservationServiceImpl reservationService, PaymentServiceImpl paymentService) {
        this.guestService = guestService;
        this.roomService = roomService;
        this.reservationService = reservationService;
        this.paymentService = paymentService;
    }

    // -------------------- Guest Operations --------------------

    public void addGuest(Guest guest) {
        guestService.addGuest(guest);
        System.out.println("✅ Guest created successfully.");
    }

    public void viewGuests() {
        List<Guest> guests = guestService.getAllGuests();
        if (guests.isEmpty()) {
            System.out.println("No guests found.");
        } else {
            guests.forEach(System.out::println);
        }
    }

    public void deleteGuest(String guestId) {
        guestService.deleteGuest(guestId);
        System.out.println("✅ Guest deleted successfully.");
    }

    // -------------------- Room Operations --------------------

    public void addRoom(Room room) {
        roomService.addRoom(room);
        System.out.println("✅ Room created successfully.");
    }

    public void viewRooms() {
        List<Room> rooms = roomService.getAllRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms found.");
        } else {
            rooms.forEach(System.out::println);
        }
    }

    public void deleteRoom(String roomNumber) {
        roomService.deleteRoom(roomNumber);
        System.out.println("✅ Room deleted successfully.");
    }

    // -------------------- Reservation Operations --------------------

    public void addReservation(Reservation reservation) {
        reservationService.addReservation(reservation);
        System.out.println("✅ Reservation created successfully.");
    }

    public void viewReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            reservations.forEach(System.out::println);
        }
    }

    public void deleteReservation(String reservationId) {
        reservationService.deleteReservation(reservationId);
        System.out.println("✅ Reservation deleted successfully.");
    }

    // -------------------- Payment Operations --------------------

    public void addPayment(Payment payment) {
        paymentService.addPayment(payment);
        System.out.println("✅ Payment added successfully.");
    }

    public void viewPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        if (payments.isEmpty()) {
            System.out.println("No payments found.");
        } else {
            payments.forEach(System.out::println);
        }
    }

    public void deletePayment(String paymentId) {
        paymentService.deletePayment(paymentId);
        System.out.println("✅ Payment deleted successfully.");
    }
}
