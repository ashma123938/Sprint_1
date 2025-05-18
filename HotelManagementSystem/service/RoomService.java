package org.example.service;

import org.example.entity.Room;

import java.util.List;

public interface RoomService {
    void addRoom(Room room);
    void updateRoom(Room room);
    void deleteRoom(String deleteRoomNumber);
    Room getRoomById(long roomId);
    List<Room> getAllRooms();
	void deleteRoom(int roomId);
	Room getRoomById(int roomId);
	void viewRoom();
	void deleteRoom(long roomId);
}
