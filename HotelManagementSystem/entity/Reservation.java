package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "reservation_id")  // Column in the database
    private String reservationId;
    
    @Column(name = "guest_id", nullable = false)  // Ensures the column is created and cannot be null
    private String customerId;
    
    @Column(name = "room_number", nullable = false)  // Ensures the column is created and cannot be null
    private String roomNumber;
    
    @Column(name = "check_in_date", nullable = false)  // Ensures the column is created and cannot be null
    private String checkInDate;
    
    @Column(name = "check_out_date", nullable = false)  // Ensures the column is created and cannot be null
    private String checkOutDate;

    // Default constructor
    public Reservation() {}

    // Constructor with parameters
    public Reservation(String reservationId, String customerId, String roomNumber, String checkInDate, String checkOutDate) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Additional constructor (if needed)
    public Reservation(String reservationId, String customerId, String roomNumber) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.roomNumber = roomNumber;
    }

    // Getters and Setters
    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    // Optionally override toString() for easy printing of Reservation details
    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + ", Customer ID: " + customerId + ", Room Number: " + roomNumber +
                ", Check-in Date: " + checkInDate + ", Check-out Date: " + checkOutDate;
    }
}
