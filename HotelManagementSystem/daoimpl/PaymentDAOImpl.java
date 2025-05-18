package org.example.daoimpl;

import org.example.dao.PaymentDAO;
import org.example.entity.Payment;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public void savePayment(Payment payment) {
        executeInsideTransaction(session -> session.save(payment));
    }

   

    @Override
    public void deletePayment(Payment payment) {
        executeInsideTransaction(session -> session.delete(payment));
    }

    @Override
    public Payment getPaymentById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Payment.class, id);
        }
    }

    @Override
    public List<Payment> getAllPayments() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Payment", Payment.class).list();
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
	public Payment getPaymentById(long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		
	}


}
	