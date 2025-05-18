package org.example.serviceimpl;

import org.example.entity.Reservation;
import org.example.service.ReservationService;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {

	@Override
	public void addReservation(Reservation reservation) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        if (reservation == null) {
	            System.out.println("Reservation object is null!");
	            return;
	        }

	        // Begin transaction
	        transaction = session.beginTransaction();

	        // Save the reservation
	        session.save(reservation);

	        // Commit the transaction
	        transaction.commit();
	        
	        // Print success message only after transaction commit
	        System.out.println("Reservation added successfully.");
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
	        System.out.println("Failed to add reservation: " + e.getMessage());
	    }
	}


    @Override
    public void updateReservation(Reservation reservation) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(reservation);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReservation(int reservationId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, reservationId);
            if (reservation != null) {
                session.delete(reservation);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Reservation.class, reservationId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Reservation> query = session.createQuery("FROM Reservation", Reservation.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	@Override
	public void deleteReservation(long reservationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reservation getReservationById(long reservationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void viewReservation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReservation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReservation(String deleteReservationId) {
		// TODO Auto-generated method stub
		
	}
}
