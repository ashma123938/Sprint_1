package org.example.dao;

import org.example.entity.Payment;
import java.util.List;

public interface PaymentDAO {
    void savePayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(Payment payment);
    Payment getPaymentById(long id);
    List<Payment> getAllPayments();
	Payment getPaymentById(int id);
}
