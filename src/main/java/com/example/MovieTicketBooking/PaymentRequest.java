package com.example.MovieTicketBooking;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRequest {
    private int paymentId;
    private String merchantId;
    private int customerId;
    private int orderId;
    private String cardNumber;
    private String upiId;
    private double amount;
    private String paymentType;
}
