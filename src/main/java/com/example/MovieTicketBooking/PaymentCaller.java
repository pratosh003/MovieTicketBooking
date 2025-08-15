package com.example.MovieTicketBooking;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-gateway")
public interface PaymentCaller {

    @PostMapping("/create")
    Payment createPayment(@RequestBody PaymentRequest paymentRequest);

    @PutMapping("/completePayment")
    Payment completePayment(@RequestBody PaymentRequest paymentRequest);
}
