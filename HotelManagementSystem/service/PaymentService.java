package org.example.service;

import org.example.entity.Payment;

import java.util.List;

public interface PaymentService {
    void addPayment(Payment payment);
    void updatePayment(Payment payment);
    void deletePayment(String deletePaymentId);
    Payment getPaymentById(long paymentId);
    List<Payment> getAllPayments();
	Payment getPaymentById(int paymentId);
	void deletePayment(int paymentId);
	void viewPayment();
	void deletePayment(long paymentId);
}
