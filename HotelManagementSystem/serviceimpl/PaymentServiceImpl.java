package org.example.serviceimpl;

import org.example.entity.Payment;
import org.example.service.PaymentService;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {

	@Override
	public void addPayment(Payment payment) {
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        if (payment == null) {
	            System.out.println("Payment object is null!");
	            return;
	        }

	        // Begin transaction
	        transaction = session.beginTransaction();

	        // Save the payment
	        session.save(payment);

	        // Commit the transaction
	        transaction.commit();
	        
	        // Print success message only after transaction commit
	        System.out.println("Payment added successfully.");
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
	        System.out.println("Failed to add payment: " + e.getMessage());
	    }
	}


   

    @Override
    public void deletePayment(long paymentId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Payment payment = session.get(Payment.class, paymentId);
            if (payment != null) {
                session.delete(payment);
                System.out.println("Payment deleted successfully.");
            } else {
                System.out.println("Payment with ID " + paymentId + " not found.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Payment getPaymentById(long paymentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Payment.class, paymentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Payment> getAllPayments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Payment> query = session.createQuery("FROM Payment", Payment.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void viewPayment() {
        // Implement logic to view payment details, e.g., fetch and display a list of all payments
        System.out.println("Viewing payment details...");
    }

	@Override
	public Payment getPaymentById(int paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePayment(int paymentId) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deletePayment(String deletePaymentId) {
		// TODO Auto-generated method stub
		
	}
}
