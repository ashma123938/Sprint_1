package org.example.dao;

import org.example.entity.Room;
import java.util.List;

public interface RoomDAO {
    void saveRoom(Room room);
    void updateRoom(Room room);
    void deleteRoom(Room room);
    Room getRoomById(long id);
    List<Room> getAllRooms();
	Room getRoomById(int id);
}



