package org.example.daoimpl;

import org.example.dao.GuestDAO;
import org.example.entity.Guest;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GuestDAOImpl implements GuestDAO {

    @Override
    public void saveGuest(Guest guest) {
        executeInsideTransaction(session -> session.save(guest));
    }

   
    @Override
    public void deleteGuest(Guest guest) {
        executeInsideTransaction(session -> session.delete(guest));
    }

    @Override
    public Guest getGuestById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Guest.class, id);
        }
    }

    @Override
    public List<Guest> getAllGuests() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Guest", Guest.class).list();
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
	public Guest getGuestById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateGuest(Guest guest) {
		// TODO Auto-generated method stub
		
	}


	
}
