

package org.example.dao;

import org.example.entity.Guest;
import java.util.List;

public interface GuestDAO {
    void saveGuest(Guest guest);
    void updateGuest(Guest guest);
    void deleteGuest(Guest guest);
    Guest getGuestById(long id);
    List<Guest> getAllGuests();
	Guest getGuestById(int id);
}
