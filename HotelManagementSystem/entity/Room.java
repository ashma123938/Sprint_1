package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "room_number")  // Column name in the database
    private String roomNumber;
    
    @Column(name = "room_type", nullable = false)  // Ensures the column is created and cannot be null
    private String roomType;
    
    @Column(name = "price_per_night", nullable = false)  // Ensures the column is created and cannot be null
    private double pricePerNight;

    // Default constructor
    public Room() {}

    // Constructor with parameters
    public Room(String roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
    }

    // Getters and Setters
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    // Optionally override toString() for easy printing of Room details
    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Room Type: " + roomType + ", Price per Night: " + pricePerNight;
    }

    
}
