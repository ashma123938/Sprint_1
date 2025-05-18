package org.example.serviceimpl;

import org.example.entity.Room;
import org.example.service.RoomService;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RoomServiceImpl implements RoomService {

	@Override
	public void addRoom(Room room) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        if (room == null) {
	            System.out.println("Room object is null!");
	            return;
	        }

	        // Begin transaction
	        transaction = session.beginTransaction();

	        // Save the room
	        session.save(room);

	        // Commit the transaction
	        transaction.commit();
	        
	        // Print success message only after transaction commit
	        System.out.println("Room added successfully.");
	    } catch (Exception e) {
	        // Rollback if there is an error
	        if (transaction != null) {
	            try {
	                transaction.rollback();
	            } catch (Exception rollbackEx) {
	                System.out.println("Rollback failed: " + rollbackEx.getMessage());
	            }
	        }
	        // Print error message
	        System.out.println("Failed to add room: " + e.getMessage());
	    }
	}


    @Override
    public void updateRoom(Room room) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(room);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoom(long roomId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Room room = session.get(Room.class, roomId);
            if (room != null) {
                session.delete(room);
                System.out.println("Room deleted successfully.");
            } else {
                System.out.println("Room with ID " + roomId + " not found.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Room getRoomById(long roomId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Room.class, roomId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Room> getAllRooms() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Room> query = session.createQuery("FROM Room", Room.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void viewRoom() {
        List<Room> rooms = getAllRooms();
        if (rooms != null && !rooms.isEmpty()) {
            for (Room room : rooms) {
                System.out.println(room);
            }
        } else {
            System.out.println("No rooms available.");
        }
    }

	@Override
	public void deleteRoom(int roomId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Room getRoomById(int roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRoom(String deleteRoomNumber) {
		// TODO Auto-generated method stub
		
	}
}
