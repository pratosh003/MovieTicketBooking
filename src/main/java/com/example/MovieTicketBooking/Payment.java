package com.example.MovieTicketBooking;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Payment {
    private int paymentId;

    private String merchantId;
    private int customerId;
    private int orderId;
    private String cardNumber;
    private String upiId;
    private double amount;

    private String paymentStatus;

    private String paymentType;

    public Payment(String merchantId, int customerId, int orderId, String cardNumber, String upiId, double amount,
                   String paymentStatus, String paymentType) {
        this.merchantId = merchantId;
        this.customerId = customerId;
        this.orderId = orderId;
        this.cardNumber = cardNumber;
        this.upiId = upiId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paymentType = paymentType;
    }
}

