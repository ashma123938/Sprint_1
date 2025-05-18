package org.example.serviceimpl;

import org.example.entity.Guest;
import org.example.service.GuestService;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GuestServiceImpl implements GuestService {

    
	@Override
	public void addGuest(Guest guest) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        if (guest == null) {
	            System.out.println("Guest object is null!");
	            return;
	        }
	        // Begin transaction
	        transaction = session.beginTransaction();
	        
	        // Save guest
	        session.save(guest);
	        
	        // Commit the transaction
	        transaction.commit();
	        
	        // Print success message after commit
	        System.out.println("Guest added successfully.");
	    } catch (Exception e) {
	        // Rollback if an exception occurs
	        if (transaction != null) {
	            try {
	                transaction.rollback();
	            } catch (Exception rollbackEx) {
	                System.out.println("Rollback failed: " + rollbackEx.getMessage());
	            }
	        }
	        // Print the error message
	        System.out.println("Failed to add guest: " + e.getMessage());
	    }
	}


    @Override
    public void deleteGuest(Long guestId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Guest guest = session.get(Guest.class, guestId);
            if (guest != null) {
                session.delete(guest);
                System.out.println("Guest deleted successfully.");
            } else {
                System.out.println("Guest not found with ID: " + guestId);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Guest getGuestById(Long guestId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Guest.class, guestId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Guest> getAllGuests() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Guest> query = session.createQuery("FROM Guest", Guest.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void viewGuest() {
        List<Guest> guests = getAllGuests();
        if (guests == null || guests.isEmpty()) {
            System.out.println("No guests found.");
        } else {
            for (Guest guest : guests) {
                System.out.println(guest);
            }
        }
    }

	@Override
	public void deleteGuest(long guestId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Guest getGuestById(long guestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveGuest(Guest guest) {
		// TODO Auto-generated method stub
		
	}


	
	@Override
	public void deleteGuest(String deleteGuestId) {
		// TODO Auto-generated method stub
		
	}

	

	
}
