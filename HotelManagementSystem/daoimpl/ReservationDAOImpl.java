package org.example.daoimpl;

import org.example.dao.ReservationDAO;
import org.example.entity.Reservation;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    @Override
    public void saveReservation(Reservation reservation) {
        executeInsideTransaction(session -> session.save(reservation));
    }

    

    @Override
    public void deleteReservation(Reservation reservation) {
        executeInsideTransaction(session -> session.delete(reservation));
    }

    @Override
    public Reservation getReservationById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Reservation.class, id);
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Reservation", Reservation.class).list();
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
	public Reservation getReservationById(long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		
	}



}
