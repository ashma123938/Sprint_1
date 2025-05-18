package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
    
    @Id
    @Column(name = "payment_id")  // Ensures the column in the database matches the field name
    private String paymentId;
    
    @Column(name = "amount", nullable = false)  // Ensures the column is created and cannot be null
    private double amount;
    
    @Column(name = "method", nullable = false)  // Ensures the column is created and cannot be null
    private String method;

    // Default constructor
    public Payment() {}

    // Constructor with parameters
    public Payment(String paymentId, double amount, String method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
    }

    // Getters and Setters
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    // Optionally override toString() for easy printing of Payment details
    @Override
    public String toString() {
        return "Payment ID: " + paymentId + ", Amount: " + amount + ", Method: " + method;
    }
}
