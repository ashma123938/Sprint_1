package org.example.daoimpl;

import org.example.dao.RoomDAO;
import org.example.entity.Room;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public void saveRoom(Room room) {
        executeInsideTransaction(session -> session.save(room));
    }

   

    @Override
    public void deleteRoom(Room room) {
        executeInsideTransaction(session -> session.delete(room));
    }

    @Override
    public Room getRoomById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Room.class, id);
        }
    }

    @Override
    public List<Room> getAllRooms() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Room", Room.class).list();
        }
    }

    private void executeInsideTransaction(java.util.function.Consumer<Session> action) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            action.accept(session);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

	@Override
	public Room getRoomById(long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void updateRoom(Room room) {
		// TODO Auto-generated method stub
		
	}
}
