package org.example.service;

import org.example.entity.Guest;

import java.util.List;

public interface GuestService {
    void addGuest(Guest guest);
    
    void deleteGuest(String deleteGuestId);
    Guest getGuestById(Long guestId);
    List<Guest> getAllGuests();
    void viewGuest();
	void saveGuest(Guest guest);
	Guest getGuestById(long guestId);
	void deleteGuest(long guestId);
	void deleteGuest(Long guestId);
}
