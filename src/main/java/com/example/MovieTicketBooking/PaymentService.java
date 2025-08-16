package com.example.MovieTicketBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;
}
